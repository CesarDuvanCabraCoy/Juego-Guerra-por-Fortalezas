package utils;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JLabel;

import org.w3c.dom.Element;

import models.Fort;
import models.Player;
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
	
	public static String getNameAvatarById(int idAvatar) {
		String name = "";
		switch (idAvatar) {
		case 1:
			name = ConstantsGUI.NA_ONE;
			break;
		case 2:
			name = ConstantsGUI.NA_TWO;
			break;
		case 3:
			name = ConstantsGUI.NA_THREE;
			break;
		case 4:
			name = ConstantsGUI.NA_FOUR;
			break;
		}
		return name;
	}

	public static Player getPlayer(Element element) {
		int id = Integer.parseInt(element.getElementsByTagName("idPlayer").item(0).getTextContent());
		String name = element.getElementsByTagName("namePlayer").item(0).getTextContent();
		int x = Integer.parseInt(element.getElementsByTagName("posXPlayer").item(0).getTextContent());
		int y = Integer.parseInt(element.getElementsByTagName("posYPlayer").item(0).getTextContent());
		int life = Integer.parseInt(element.getElementsByTagName("lifePlayer").item(0).getTextContent());
		int idAvatar = Integer.parseInt(element.getElementsByTagName("idAvatar").item(0).getTextContent());
		int fort = Integer.parseInt(element.getElementsByTagName("fortPlayer").item(0).getTextContent());
		int score = Integer.parseInt(element.getElementsByTagName("scorePlayer").item(0).getTextContent());
		return new Player(id, name, score, life, fort, idAvatar, x, y);
	}
	
	
	public static String getImageAvatarSinceId(int idAvatar) {
		String urlImg = ConstantsGUI.URL_AVATAR_ONE;
		switch (idAvatar) {
		case 2:
			urlImg = ConstantsGUI.URL_AVATAR_TWO;
			break;
		case 3:
			urlImg = ConstantsGUI.URL_AVATAR_THREE;
			break;
		case 4:
			urlImg = ConstantsGUI.URL_AVATAR_FOUR;
			break;
		}
		return urlImg;
	}
	
	public static String getImageFortSinceId(int idFort) {
		String urlImg = ConstantsGUI.URL_FORT_ONE;
		switch (idFort) {
		case 1:
			urlImg = ConstantsGUI.URL_FORT_TWO;
			break;
		case 2:
			urlImg = ConstantsGUI.URL_FORT_THREE;
			break;
		}
		return urlImg;
	}
}