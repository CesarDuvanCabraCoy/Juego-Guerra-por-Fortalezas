package views;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import controllers.MainController;

public class JFCreateClient extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPCreateClient jpCreateClient;
	private MainController mainController;
	
	public JFCreateClient(MainController mainController) {
		this.mainController = mainController;
		this.setTitle(ConstantsGUI.T_JF_LOGIN);
		this.setIconImage(new ImageIcon(getClass().getResource((ConstantsGUI.URL_IMAGE_ICON))).getImage());
		this.setSize(ConstantsGUI.T_JF_WIDTH, ConstantsGUI.T_JF_HEIGHT);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		init();
		this.setVisible(true);
	}

	private void init() {
		jpCreateClient = new JPCreateClient(mainController);
		this.add(jpCreateClient, BorderLayout.CENTER);
	}
	
	public String getIP() {
		return jpCreateClient.getIP();
	}
	
	public int getPort() {
		return jpCreateClient.getPort();
	}
	
	public void cleanFields() {
		jpCreateClient.cleanFields();
	}

}