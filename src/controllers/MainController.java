package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import communications.Client;
import exceptions.ExcFortNotFound;
import models.ConstantsMOD;
import models.Fort;
import models.ManagerGame;
import models.Player;
import perssistence.FileManager;
import utils.Util;
import views.ConstantsGUI;
import views.JDLoading;
import views.JFCreateClient;
import views.JFCreatePlayer;
import views.WindowGame;

public class MainController implements ActionListener, KeyListener{

	private ManagerGame managerGame;
	private FileManager fileManager;
	private JFCreateClient jfCreateClient;
	private JFCreatePlayer jfCreatePlayer;
	private WindowGame windowGame;
	private Client client;
	private String ip;
	private int port;
	private int idAvatar;
	private boolean isPlay;
	private JDLoading jdLoading;

	public MainController() {
		fileManager = new FileManager();
		managerGame = new ManagerGame();
		windowGame = new WindowGame(this);
		this.isPlay = false;
		jfCreatePlayer = new JFCreatePlayer(this, managerGame.getListNamesForts());
		jdLoading = new JDLoading();
		jfCreateClient = new JFCreateClient(this);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		switch (JBActions.valueOf(event.getActionCommand())) {
		case ACCEPT_CREATE_CLIENT:
			acceptCreateClient();
			break;
		case CHOOSE_AVATAR:
			chooseAvatar(event);
			break;
		case ACCEPT_CREATE_PLAYER:
			acceptCreatePlayer();
			break;
		default:
			break;
		}
	}

	private void initGame() {
		SwingWorker<Void, Void> refreshBoard = new SwingWorker<Void, Void>() {
			@Override
			protected Void doInBackground() throws Exception {
				while (isPlay) {
					windowGame.updatePlayers(managerGame.getPlayers());
				}
				return null;
			}
		};
		refreshBoard.execute();
	}

	private void chooseAvatar(ActionEvent event) {
		idAvatar = Integer.parseInt(((JComponent) (event.getSource())).getName());
		JOptionPane.showMessageDialog(null, ConstantsGUI.AVATAR_CHOOSE + Util.getNameAvatarById(idAvatar), ConstantsGUI.SUCCESSFUL, JOptionPane.INFORMATION_MESSAGE);
	}

	private void acceptCreatePlayer() {
		try {
			Fort fort = managerGame.searchFort(jfCreatePlayer.getFort());
			String name = jfCreatePlayer.getNamePlayer();
			managerGame.createPlayer(name, fort, idAvatar);
			client = new Client(ip, port, this);
			client.sendCreateClient(name, idAvatar, fort.getIdFort());
			jdLoading.setVisible(true);
		} catch (ExcFortNotFound e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), ConstantsMOD.WRONG, JOptionPane.WARNING_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), ConstantsMOD.WRONG, JOptionPane.WARNING_MESSAGE);
		}
	}

	private void acceptCreateClient() {
		ip = jfCreateClient.getIP();
		port = jfCreateClient.getPort();
		jfCreateClient.setVisible(false);
		jfCreatePlayer.setVisible(true);
	}

	public void addPosPlayer(int id, int x, int y) {
		managerGame.setPosMyPlayer(id, x, y);

		System.out.println(managerGame.getPlayer().getX() + " "+ managerGame.getPlayer().getY());
	}

	private void readyToPlay() {
		isPlay = true;
		managerGame.printPlayers();
		windowGame.updatePlayers(managerGame.getPlayers());
		jdLoading.setVisible(false);
		jfCreatePlayer.setVisible(false);
		windowGame.setVisible(true);	
	}

	public void saveListPlayers(ArrayList<Player> players) {
		managerGame.loadPlayers(players);
		System.out.println("pasa ----------------------------------");
		readyToPlay();
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent event) {
		System.out.println(event.getKeyCode());
		managerGame.moveAvatar(event.getKeyCode());
		windowGame.updatePlayers(managerGame.getPlayers());
		System.out.println("posx" + managerGame.getPlayer().getX());
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}