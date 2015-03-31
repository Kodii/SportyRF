package gui.intefaces;

import gui.Window;
import gui.competitor.Competitor;
import gui.competitor.DeleteCompetitor;

import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

public abstract class NewWindow extends JFrame implements NewWindowInterface {

	private int option;
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
