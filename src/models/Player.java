package models;

import java.io.IOException;
import communications.Client;

public class Player {

	private int id;
	private String name;
	private Client client;
	private int score;
	
	public Player(int id, String name, String ip, int port) throws IOException {
		this.id = id;
		this.name = name;
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
}