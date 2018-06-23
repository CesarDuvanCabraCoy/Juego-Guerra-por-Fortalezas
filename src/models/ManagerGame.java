package models;

import java.io.IOException;
import java.util.ArrayList;

import exceptions.ExcFortNotFound;
import utils.Util;

public class ManagerGame {

	private ArrayList<Fort> listForts;
	private Player player;
	private ArrayList<Player> players;
	
	public ManagerGame() {
		listForts = new ArrayList<>();
		players = new ArrayList<Player>();
		generateForts();
	}
	
	public void createPlayer(String name, Fort fort, int avatar) throws IOException {
		player = new Player(name, fort.getIdFort(), avatar);
	}

	public void setPosMyPlayer(int id, int x, int y) {
		player.setId(id);
		player.setX(x);
		player.setY(y);
	}
	
	private void generateForts() {
		listForts.add(new Fort(0, ConstantsMOD.FORT_EEUU, ConstantsMOD.URL_FORT_EEUU));
		listForts.add(new Fort(1, ConstantsMOD.FORT_COLOMBIA, ConstantsMOD.URL_FORT_COLOMBIA));
		listForts.add(new Fort(2, ConstantsMOD.FORT_FRANCE, ConstantsMOD.URL_FORT_FRANCE));
	}
	
	public void loadPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	
	public Fort searchFort(String nameFort) throws ExcFortNotFound {
		for (Fort fort : listForts) {
			if (fort.getName().equals(nameFort)) {
				return fort;
			}
		}throw new ExcFortNotFound();
	}
	
	public String[] getListNamesForts() {
		return Util.getListNamesForts(listForts);
	}
	
	public ArrayList<Fort> getListForts() {
		return listForts;
	}
	
	public Player getPlayer() {
		return player;
	}

	public void printPlayers() {
		for (Player pla : players) {
			System.out.println(pla.toString());
		}
	}
	
	public void moveAvatar(int keyCode) {
		switch (keyCode) {
		case ConstantsMOD.KEY_MOVE_UP:
			players.get(player.getId()).movePlayer(MoveTo.UP);
			break;
		case ConstantsMOD.KEY_MOVE_DOWN:
			players.get(player.getId()).movePlayer(MoveTo.DOWN);
			break;
		case ConstantsMOD.KEY_MOVE_RIGHT:
			players.get(player.getId()).movePlayer(MoveTo.RIGHT);
			break;
		case ConstantsMOD.KEY_MOVE_LEFT:
			players.get(player.getId()).movePlayer(MoveTo.LEFT);
			break;
		default:
			break;
		}
	}
	
	public ArrayList<Player> getPlayers() {
		return players;
	}
}