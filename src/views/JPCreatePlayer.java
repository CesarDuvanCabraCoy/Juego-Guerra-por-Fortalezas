package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import controllers.JBActions;
import controllers.MainController;
import utils.Util;

public class JPCreatePlayer extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel jlInfo;
	private JLabel jlIdInfo;
	private JSpinner jlId;
	private JLabel jlName;
	private  JTextField jtfName;
	private JLabel jlFort;
	private JComboBox<String> jcbForts;
	private JLabel jlChooseAvatar;
	private JButton jbAvatarOne;
	private JButton jbAvatarTwo;
	private JButton jbAvatarThree;
	private JButton jbAvatarFour;
	private MainController mainController;
	private Image image;
	
	public JPCreatePlayer(MainController mainController, String[] forts) {
		this.mainController = mainController;
		this.setLayout(new GridBagLayout());
		image = new ImageIcon(getClass().getResource(ConstantsGUI.URL_WALLPAPER_CREATE_PLAYER)).getImage();
		init(forts);
	}
	
	private void init(String[] forts) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(20, 20, 10, 10);
		Util.generateBasicGrid(this, gbc);
		
		jlInfo = new JLabel(ConstantsGUI.JL_INFO_CREATE_PLAYER);
		jlInfo.setFont(new Font(ConstantsGUI.TYPE_LETTER, Font.BOLD, 35));
		jlInfo.setForeground(Color.WHITE);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 10;
		this.add(jlInfo, gbc);
		
		jlIdInfo = new JLabel(ConstantsGUI.JL_ID);
		jlIdInfo.setFont(new Font(ConstantsGUI.TYPE_LETTER, Font.BOLD, 30));
		jlIdInfo.setForeground(Color.WHITE);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 4;
		this.add(jlIdInfo, gbc);
		
		jlId = new JSpinner();
		gbc.gridx = 6;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 4;
		this.add(jlId, gbc);
		
		jlName = new JLabel(ConstantsGUI.JL_NAME);
		jlName.setFont(new Font(ConstantsGUI.TYPE_LETTER, Font.BOLD, 30));
		jlName.setForeground(Color.WHITE);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridheight = 1;
		gbc.gridwidth = 4;
		this.add(jlName, gbc);
		
		jtfName = new JTextField();
		gbc.gridx = 6;
		gbc.gridy = 2;
		gbc.gridheight = 1;
		gbc.gridwidth = 4;
		this.add(jtfName, gbc);
		
		jlFort = new JLabel(ConstantsGUI.JL_FORT);
		jlFort.setFont(new Font(ConstantsGUI.TYPE_LETTER, Font.BOLD, 30));
		jlFort.setForeground(Color.WHITE);
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridheight = 1;
		gbc.gridwidth = 4;
		this.add(jlFort, gbc);
		
		jcbForts = new JComboBox<>(forts);
		gbc.gridx = 6;
		gbc.gridy = 3;
		gbc.gridheight = 1;
		gbc.gridwidth = 4;
		this.add(jcbForts, gbc);
		
		jlChooseAvatar = new JLabel(ConstantsGUI.JL_CHOOSE_AVATAR);
		jlChooseAvatar.setFont(new Font(ConstantsGUI.TYPE_LETTER, Font.BOLD, 30));
		jlChooseAvatar.setForeground(Color.WHITE);
		gbc.gridx = 4;
		gbc.gridy = 4;
		gbc.gridheight = 1;
		gbc.gridwidth = 4;
		this.add(jlChooseAvatar, gbc);
		
		addButtonAvatar(jbAvatarOne, ConstantsGUI.URL_AVATAR_ONE, ConstantsGUI.ID_AVATAR_ONE, 2, gbc);
		addButtonAvatar(jbAvatarTwo, ConstantsGUI.URL_AVATAR_TWO, ConstantsGUI.ID_AVATAR_TWO, 4, gbc);
		addButtonAvatar(jbAvatarThree, ConstantsGUI.URL_AVATAR_THREE, ConstantsGUI.ID_AVATAR_THREE, 6, gbc);
		addButtonAvatar(jbAvatarFour, ConstantsGUI.URL_AVATAR_FOUR, ConstantsGUI.ID_AVATAR_FOUR, 8, gbc);
	}

	private void addButtonAvatar(JButton jb, String urlImageAvatar, String nameButton, int x, GridBagConstraints gbc) {
		jb = new JButton(new ImageIcon(getClass().getResource(urlImageAvatar)));
		jb.setActionCommand(JBActions.CHOOSE_AVATAR.name());
		jb.addActionListener(mainController);
		jb.setBackground(Color.WHITE);
		gbc.gridx = x;
		gbc.gridy = 5;
		gbc.gridheight = 3;
		gbc.ipady = 2;
		gbc.gridwidth = 2;
		this.add(jb, gbc);
	}
	
	private void drawImage(Graphics g) {
		int width = this.getSize().width;
		int height = this.getSize().height;
		g.drawImage(image, 0, 0, width, height, this);
	}
	
	@Override
	public void paint(Graphics g) {
		this.setOpaque(false);
		drawImage(g);
		super.paint(g);
	}
	
	public static void main(String[] args) {
		JFCreatePlayer jf = new JFCreatePlayer(null, new String[] {"EEUU, COLOMBIA"});
		jf.setVisible(true);
	}
}