package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import controllers.JBActions;
import controllers.MainController;
import utils.Util;

public class JPCreateClient extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel jlInfo;
	private JLabel jlPort;
	private JSpinner jsPort;
	private JLabel jlIP;
	private JTextField jtfIP;
	private JButton jbAccept;
	private MainController mainController;
	
	public JPCreateClient(MainController mainController) {
		this.mainController = mainController;
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.WHITE);
		init();
	}
	
	private void init() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(20, 20, 10, 10);
		Util.generateBasicGrid(this, gbc);
		
		jlInfo = new JLabel(ConstantsGUI.JL_INFO_FIELDS);
		jlInfo.setFont(new Font(ConstantsGUI.TYPE_LETTER, Font.BOLD, 23));
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 8;
		this.add(jlInfo, gbc);
		
		jlIP = new JLabel(ConstantsGUI.JL_IP);
		jlIP.setFont(new Font(ConstantsGUI.TYPE_LETTER, Font.BOLD, 18));
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 4;
		this.add(jlIP, gbc);
		
		jtfIP = new JTextField("localhost");
		gbc.gridx = 5;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 5;
		this.add(jtfIP, gbc);
		
		jlPort = new JLabel(ConstantsGUI.JL_PORT);
		jlPort.setFont(new Font(ConstantsGUI.TYPE_LETTER, Font.BOLD, 18));
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridheight = 1;
		gbc.gridwidth = 4;
		this.add(jlPort, gbc);
		
		jsPort = new JSpinner();
		jsPort.setValue(8004);
		gbc.gridx = 5;
		gbc.gridy = 2;
		gbc.gridheight = 1;
		gbc.gridwidth = 5;
		this.add(jsPort, gbc);
		
		jbAccept = new JButton(ConstantsGUI.JB_ACCEPT);
		jbAccept.setActionCommand(JBActions.ACCEPT_CREATE_CLIENT.toString());
		jbAccept.addActionListener(mainController);
		gbc.gridx = 4;
		gbc.gridy = 6;
		gbc.gridheight = 1;
		gbc.gridwidth = 3;
		this.add(jbAccept, gbc);
	}
	
	public int getPort() {
		return (int) jsPort.getValue();
	}
	
	public String getIP() {
		return jtfIP.getText();
	}
	
	public void cleanFields() {
		jsPort.setValue(0);
		jtfIP.setText(ConstantsGUI.SPACE);
	}
}
