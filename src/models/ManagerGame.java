package models;

import java.util.ArrayList;

import utils.Util;

public class ManagerGame {

	private ArrayList<Fort> listForts;
	
	public ManagerGame() {
		listForts = new ArrayList<>();
		generateForts();
	}

	private void generateForts() {
		listForts.add(new Fort(0, ConstantsMOD.FORT_EEUU, ConstantsMOD.URL_FORT_EEUU));
		listForts.add(new Fort(1, ConstantsMOD.FORT_COLOMBIA, ConstantsMOD.URL_FORT_COLOMBIA));
	}
	
	public String[] getListNamesForts() {
		return Util.getListNamesForts(listForts);
	}
	
	public ArrayList<Fort> getListForts() {
		return listForts;
	}
}