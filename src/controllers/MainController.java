package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

import exceptions.ExcFortNotFound;
import models.ConstantsMOD;
import models.Fort;
import models.ManagerGame;
import models.Player;
import utils.Util;
import views.ConstantsGUI;
import views.JFCreateClient;
import views.JFCreatePlayer;

public class MainController implements ActionListener{

	private JFCreateClient jfCreateClient;
	private JFCreatePlayer jfCreatePlayer;
	private ManagerGame managerGame;
	private Player player;
	private String ip;
	private int port;
	private int idAvatar;
	
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
		case CHOOSE_AVATAR:
			chooseAvatar(event);
			break;
		case ACCEPT_CREATE_PLAYER:
			acceptCreatePlayer();
			break;
		default:
			break;
		}
	}

	private void chooseAvatar(ActionEvent event) {
		idAvatar = Integer.parseInt(((JComponent) (event.getSource())).getName());
		JOptionPane.showMessageDialog(null, ConstantsGUI.AVATAR_CHOOSE + Util.getNameAvatarById(idAvatar), ConstantsGUI.SUCCESSFUL, JOptionPane.INFORMATION_MESSAGE);
	}

	private void acceptCreatePlayer() {
		try {
			Fort fort = managerGame.searchFort(jfCreatePlayer.getFort());
			managerGame.createPlayer(jfCreatePlayer.getId(), jfCreatePlayer.getNamePlayer(), fort, idAvatar, ip, port);
			managerGame.sendToServerCreatePlayer();
		} catch (ExcFortNotFound e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), ConstantsMOD.WRONG, JOptionPane.WARNING_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), ConstantsMOD.WRONG, JOptionPane.WARNING_MESSAGE);
		}
	}

	private void acceptCreateClient() {
		ip = jfCreateClient.getIP();
		port = jfCreateClient.getPort();
		jfCreateClient.setVisible(false);
		jfCreatePlayer.setVisible(true);
	}	
}