package gui.intefaces;

import gui.Window;
import gui.competition.NewCompetition;
import gui.competition.NewCompetitionWindow;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class NewWindow extends JFrame implements NewWindowInterface {

	protected JButton confirmButton;

	protected Container contentPane;

	protected Window window;

	public NewWindow() {
		
		setTitle("SET TITLE");
		setSize(640, 480);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		
		initUI();
	}

	public NewWindow(Window window) {
		this.window = window;

		setTitle("SET TITLE");
		setSize(640, 480);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);

		initUI();
	}

}
