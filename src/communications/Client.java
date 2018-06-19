package communications;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client extends Thread{

	private Socket connection;
	private DataInputStream input;
	private DataOutputStream output;
	private boolean stop;

	public Client(String ip, int port) throws IOException {
		this.connection = new Socket(ip, port);
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
				e.printStackTrace();
			}
		}
	}

	private void manageResponse(String response) {
	
	}

	public void sendCreateClient(int id, String name, int x, int y) throws IOException {
		output.writeUTF(Petition.C_CREATE_CLIENT.name());
		output.writeInt(id);
		output.writeUTF(name);
		output.writeInt(x);
		output.writeInt(y);
	}
}
