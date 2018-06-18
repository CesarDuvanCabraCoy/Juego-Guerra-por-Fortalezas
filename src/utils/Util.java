package utils;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.util.ArrayList;

import javax.swing.JLabel;

import models.Fort;
import views.ConstantsGUI;

public class Util {

	public static void generateBasicGrid(Container comp, GridBagConstraints gbc){
		gbc.weightx = 1;
		for (int i = 0; i < ConstantsGUI.COLUMNS_NUMBER; i++) {
			gbc.gridx = i;
			comp.add(new JLabel(""), gbc);
		}
	}
	
	public static String[] getListNamesForts(ArrayList<Fort> forts) {
		String[] listForts = new String[forts.size()];
		for (int i = 0; i < listForts.length; i++) {
			listForts[i] = forts.get(i).getName();
		}
		return listForts;
	}
}