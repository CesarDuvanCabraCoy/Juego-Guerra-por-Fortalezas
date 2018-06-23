package views;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controllers.MainController;
import models.Player;

public class WindowGame extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPMainGame jpMainGame;
	
	public WindowGame(MainController mainController) {
		this.setTitle(ConstantsGUI.TITLE_JF_MAIN);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setIconImage(new ImageIcon(getClass().getResource(ConstantsGUI.URL_IMAGE_ICON)).getImage());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.addKeyListener(mainController);
		init(mainController);
	}
	
	private void init(MainController mainController) {
		jpMainGame = new JPMainGame(mainController);
		this.add(jpMainGame, BorderLayout.CENTER);
	}
	
	public void updatePlayers(ArrayList<Player> players) {
		jpMainGame.updatePlayers(players);
	}
}