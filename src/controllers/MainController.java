package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Player;
import views.JFCreateClient;

public class MainController implements ActionListener{

	private JFCreateClient jfCreateClient;
	private Player player;
	private String ip;
	private int port;
	
	public MainController() {
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
	}	
}