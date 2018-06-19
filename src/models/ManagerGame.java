package models;

import java.io.IOException;
import java.util.ArrayList;

import exceptions.ExcFortNotFound;
import utils.Util;

public class ManagerGame {

	private ArrayList<Fort> listForts;
	private Player player;
	
	public ManagerGame() {
		listForts = new ArrayList<>();
		generateForts();
	}
	
	public void createPlayer(int id, String name, Fort fort, int avatar, String ip, int port) throws IOException {
		player = new Player(id, name, fort, avatar, ip, port);
	}
	
	public void sendToServerCreatePlayer() throws IOException {
		player.sendCreatePlayer();
	}

	private void generateForts() {
		listForts.add(new Fort(0, ConstantsMOD.FORT_EEUU, ConstantsMOD.URL_FORT_EEUU));
		listForts.add(new Fort(1, ConstantsMOD.FORT_COLOMBIA, ConstantsMOD.URL_FORT_COLOMBIA));
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
}