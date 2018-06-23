package views;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import controllers.MainController;
import models.Player;
import utils.Util;

public class JPMainGame extends JPanel{

	private static final long serialVersionUID = 1L;
	private ArrayList<Player> players;
	private Image image;
	
	public JPMainGame(MainController mainController) {
		this.addKeyListener(mainController);
		image = new ImageIcon(getClass().getResource(ConstantsGUI.URL_WALLPAPER_MAIN)).getImage();
	}
	
	private void drawImage(Graphics g) {
		int width = this.getSize().width;
		int height = this.getSize().height;
		g.drawImage(image, 0, 0, width, height, this);
	}
	
	public void updatePlayers(ArrayList<Player> players) {
		this.players = players;
		this.repaint();
	}
	
	private void drawPlayers(Graphics g) {
		for (int i = 0; i < players.size(); i++) {
			Player pl = players.get(i);
			Image avatar = new ImageIcon(getClass().getResource(Util.getImageAvatarSinceId(pl.getAvatar()))).getImage();
			g.drawImage(avatar, pl.getX(), pl.getY(), ConstantsGUI.WIDTH_AVATAR, ConstantsGUI.HEIGHT_AVATAR, this);
			g.drawString(pl.getName(), pl.getX(), pl.getY() - 20);
			Image fort = new ImageIcon(getClass().getResource(Util.getImageFortSinceId(pl.getFort()))).getImage();
			g.drawImage(fort, pl.getxFort(), pl.getyFort(), ConstantsGUI.WIDTH_FORT, ConstantsGUI.HEIGHT_FORT, this);
		}
	}
		
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		drawImage(g);
		drawPlayers(g);
		this.setOpaque(false);
	}
	
}
