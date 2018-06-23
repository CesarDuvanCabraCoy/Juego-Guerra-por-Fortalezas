package models;

import java.io.IOException;
import communications.Client;

public class Player {

	private int id;
	private String name;
	private int score;
	private int life;
	private int idFort;
	private int idAvatar;
	private int x;
	private int y;
	private int xFort;
	private int yFort;
	
	public Player(String name, int idFort, int avatar) throws IOException {
		this.id = 0;
		this.name = name;
		this.idFort = idFort;
		this.idAvatar = avatar;
		this.score = 0;
		this.life = 100;
		x = 0;
		y = 0;
	}

	public Player(int id, String name, int score, int life, int idFort, int idAvatar, int x, int y) {
		this.id = id;
		this.name = name;
		this.score = score;
		this.life = life;
		this.idFort = idFort;
		this.idAvatar = idAvatar;
		this.x = x;
		this.y = y;
		xFort = x;
		yFort = y;
	}

	public void movePlayer(MoveTo moveTo){
		switch (moveTo) {
		case UP:
			this.setY(this.getY() - ConstantsMOD.MOVE_UNITS);
			break;
		case DOWN:
			this.setY(this.getY() + ConstantsMOD.MOVE_UNITS);
			break;
		case LEFT:
			this.setX(this.getX() - ConstantsMOD.MOVE_UNITS);
			break;
		case RIGHT:
			this.setX(this.getX() + ConstantsMOD.MOVE_UNITS);
			break;
		default:
			break;
		}
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}
	
	public int getAvatar() {
		return idAvatar;
	}
	
	public int getFort() {
		return idFort;
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
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	public int getxFort() {
		return xFort;
	}
	
	public int getyFort() {
		return yFort;
	}
	
	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", score=" + score + ", life=" + life + ", idFort=" + idFort
				+ ", idAvatar=" + idAvatar + ", x=" + x + ", y=" + y + "]";
	}
}