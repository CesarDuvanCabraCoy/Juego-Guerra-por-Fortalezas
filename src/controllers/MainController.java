package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.ManagerGame;
import models.Player;
import views.JFCreateClient;
import views.JFCreatePlayer;

public class MainController implements ActionListener{

	private JFCreateClient jfCreateClient;
	private JFCreatePlayer jfCreatePlayer;
	private ManagerGame managerGame;
	private Player player;
	private String ip;
	private int port;
	
	public MainController() {
		managerGame = new ManagerGame();
		jfCreatePlayer = new JFCreatePlayer(this, managerGame.getListNamesForts());
		jfCreateClient = new JFCreateClient(this);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		switch (JBActions.valueOf(event.getActionCommand())) {
		case ACCEPT_CREATE_CLIENT:
			acceptCreateClient();
			break;
		default:
			break;
		}
	}

	private void acceptCreateClient() {
		ip = jfCreateClient.getIP();
		port = jfCreateClient.getPort();
		jfCreateClient.setVisible(false);
		jfCreatePlayer.setVisible(true);
	}	
}