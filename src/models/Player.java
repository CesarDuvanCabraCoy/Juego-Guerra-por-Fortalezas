package models;

import java.io.IOException;
import communications.Client;

public class Player {

	private int id;
	private String name;
	private Client client;
	private int score;
	private int life;
	private Fort fort;
	private int idAvatar;
	private int x;
	private int y;
	
	public Player(int id, String name, Fort fort, int avatar, String ip, int port) throws IOException {
		this.id = id;
		this.name = name;
		this.fort = fort;
		this.idAvatar = avatar;
		this.client = new Client(ip, port);
		this.score = 0;
		this.life = 100;
		x = 0;
		y = 0;
	}
	
	public void sendCreatePlayer() throws IOException {
		client.sendCreateClient(id, name, x, y);
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
		return idAvatar;
	}
	
	public Fort getFort() {
		return fort;
	}
	
	public int getLife() {
		return life;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}