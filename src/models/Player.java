package models;

import java.io.IOException;
import communications.Client;

public class Player {

	private int id;
	private String name;
	private Client client;
	private int score;
	private Fort fort;
	private int avatar;
	
	public Player(int id, String name, Fort fort, int avatar, String ip, int port) throws IOException {
		this.id = id;
		this.name = name;
		this.fort = fort;
		this.avatar = avatar;
		this.client = new Client(ip, port);
		this.score = 0;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Client getClient() {
		return client;
	}

	public int getScore() {
		return score;
	}
	
	public int getAvatar() {
		return avatar;
	}
	
	public Fort getFort() {
		return fort;
	}
}