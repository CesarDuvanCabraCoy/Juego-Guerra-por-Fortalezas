package communications;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import controllers.MainController;
import models.ConstantsMOD;
import models.ManagerGame;
import perssistence.ConstantsPER;
import perssistence.FileManager;
import views.ConstantsGUI;

public class Client extends Thread{

	private Socket connection;
	private FileManager fileManager;
	private DataInputStream input;
	private DataOutputStream output;
	private boolean stop;
	private MainController mainController;

	public Client(String ip, int port, MainController mainController) throws IOException {
		this.connection = new Socket(ip, port);
		this.mainController = mainController;
		fileManager = new FileManager();
		input = new DataInputStream(connection.getInputStream());
		output = new DataOutputStream(connection.getOutputStream());
		start();
	}

	@Override
	public void run() {
		while (!stop) {
			String response;
			try {
				response = input.readUTF();
				if (response != null) {
					manageResponse(response);
				}
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), ConstantsGUI.WRONG, JOptionPane.ERROR_MESSAGE);
				stop = true;
			}
		}
	}

	private void manageResponse(String response) {
		switch (Response.valueOf(response)) {
		case S_SEND_PLAYERS:
			receivePlayers();
			break;
		case S_SEND_POS_PLAYER:
			receiveMyPos();
			break;
		default:
			break;
		}
	}

	private void receiveMyPos() {
		try {
			int id = input.readInt();
			int x = input.readInt();
			int y = input.readInt();
			mainController.addPosPlayer(id, x, y);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void receivePlayers() {
		try {
			receiveFile();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}
	
	public byte[] receiveFile() throws IOException, ParserConfigurationException, SAXException {
		int size = input.readInt();
		System.out.println(size);
		byte arrayFile [] = new byte[size];
		for (int i = 0; i < size; i++) {
			arrayFile[i] = (byte) input.read();
		}
		mainController.saveListPlayers(fileManager.loadInfoPlayers(arrayFile));
		return arrayFile;
	}	

	public void sendCreateClient(String name, int avatar, int fort) throws IOException {
		output.writeUTF(Request.C_CREATE_CLIENT.name());
		output.writeUTF(name);
		output.writeInt(avatar);
		output.writeInt(fort);
	}
}
