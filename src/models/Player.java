package models;

import java.io.IOException;
import communications.Client;

public class Player {

	private int id;
	private String name;
	private Client client;
	private int score;
	private String avatar;
	
	public Player(int id, String name, String avatar, String ip, int port) throws IOException {
		this.id = id;
		this.name = name;
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
	
	public String getAvatar() {
		return avatar;
	}
}