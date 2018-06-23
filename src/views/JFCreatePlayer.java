package views;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import controllers.MainController;

public class JFCreatePlayer extends JFrame{

	private static final long serialVersionUID = 1L;
	private MainController mainController;
	private JPCreatePlayer jpCreatePlayer;
	
	public JFCreatePlayer(MainController mainController, String[] forts) {
		this.mainController = mainController;
		this.setTitle(ConstantsGUI.T_JF_CREATE_PLAYER);
		this.setIconImage(new ImageIcon(getClass().getResource((ConstantsGUI.URL_IMAGE_ICON))).getImage());
		this.setSize(ConstantsGUI.T_JF_WIDTH_CP, ConstantsGUI.T_JF_HEIGHT_CP);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		init(forts);
	}
	
	private void init(String[] forts) {
		jpCreatePlayer = new JPCreatePlayer(mainController, forts);
		this.add(jpCreatePlayer, BorderLayout.CENTER);
	}

	public String getFort() {
		return jpCreatePlayer.getFort();
	}
	
	public String getNamePlayer() {
		return jpCreatePlayer.getName();
	}
	
}