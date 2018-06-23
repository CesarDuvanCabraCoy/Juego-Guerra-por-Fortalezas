package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class JDLoading extends JDialog{

	private static final long serialVersionUID = 1L;
	private JLabel jlInfo;
	
	public JDLoading() {
		this.setTitle(ConstantsGUI.T_JD_LOADING);
		this.setSize(ConstantsGUI.JD_LOADING_WIDTH, ConstantsGUI.JD_LOADING_HEIGHT);
		this.setIconImage(new ImageIcon(getClass().getResource(ConstantsGUI.URL_IMAGE_ICON)).getImage());
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.WHITE);
		this.setLayout(new BorderLayout());
		this.setResizable(true);
		this.setModal(true);
		init();
	}
	
	private void init() {
		jlInfo = new JLabel(ConstantsGUI.LOADING);
		jlInfo.setFont(new Font(ConstantsGUI.TYPE_LETTER, Font.BOLD, 25));
		this.add(jlInfo, BorderLayout.CENTER);
	}
}
