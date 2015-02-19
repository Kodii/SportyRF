package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JToolBar;

/**
 * Created by Kordian on 2014-12-28.
 */

public class Window extends JFrame {

	private JTabbedPane tabbedPane;
	private JPanel jpanelStartList, jpanelRace, jpanelInside;
	private JScrollPane listScroller, rightPane;
	private JTable list;
	private JFrame addNewCompetition;
	private Competition competition;

	public JPanel getJpanelStartList() {
		return jpanelStartList;
	}

	public Window() {
		setTitle("Tutaj nazwa programu");
		setSize(800, 600);
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		initExitOnClose();
		initUI();
	}

	private void initUI() {

		JMenuBar menuBar = new JMenuBar();
		ImageIcon quitIcon = new ImageIcon("images/blank.png");
		ImageIcon menuCompetitionNewIcon = new ImageIcon("images/blank.png");
		ImageIcon menuCompetitorNewIcon = new ImageIcon("images/blank.png");
		ImageIcon menuRFIDConnectIcon = new ImageIcon("images/blank.png");

		// Menu Competition //
		JMenu menuCompetitions = new JMenu("ZAWODY");
		menuCompetitions.setMnemonic(KeyEvent.VK_Z);
		menuCompetitions.setToolTipText("Menu zawody (alt+z)");
		menuBar.add(menuCompetitions);

		// Menu Competition - new
		JMenuItem menuCompetitionNew = new JMenuItem("NOWE",
				menuCompetitionNewIcon);
		menuCompetitionNew.setMnemonic(KeyEvent.VK_X);
		menuCompetitionNew.setToolTipText("Dodaj nowy (alt+x)");
		menuCompetitionNew.addActionListener(new MenuCompetitionNewListener());
		menuCompetitions.add(menuCompetitionNew);
		// Menu Competition - new
		// menuCompetitions.addActionListener(new MenuCompetitionNewListener());
		// Menu Competition - load
		JMenuItem menuCompetitionLoad = new JMenuItem("WCZYTAJ");
		menuCompetitionLoad.setMnemonic(KeyEvent.VK_C);
		menuCompetitionLoad.setToolTipText("Wczytuje z pliku (alt+c)");
		menuCompetitions.add(menuCompetitionLoad);
		// Menu Competition - load

		// Menu Competition - edit
		JMenuItem menuCompetitionEdit = new JMenuItem("EDYTUJ");
		menuCompetitionEdit.setMnemonic(KeyEvent.VK_V);
		menuCompetitionEdit.setToolTipText("EDYTUJE (alt+v)");
		menuCompetitions.add(menuCompetitionEdit);
		// Menu Competition - edit

		// Menu Competition //

		// Menu Competitor //
		JMenu menuCompetitor = new JMenu("ZAWODNIK");
		menuCompetitor.setMnemonic(KeyEvent.VK_A);
		menuCompetitor.setToolTipText("Menu Zawodnik (alt+a)");
		menuBar.add(menuCompetitor);

		// Menu Competitor - new
		JMenuItem menuCompetititorNew = new JMenuItem("NOWY",
				menuCompetitorNewIcon);
		menuCompetititorNew.setMnemonic(KeyEvent.VK_S);
		menuCompetititorNew.setToolTipText("Dodaj nowego zawodnika (alt+s)");
		menuCompetitor.add(menuCompetititorNew);
		// Menu Competitor - new

		// Menu Competitor - delete
		JMenuItem menuCompetitorDelete = new JMenuItem("USUŃ");
		menuCompetitorDelete.setMnemonic(KeyEvent.VK_D);
		menuCompetitorDelete.setToolTipText("Wczytuje z pliku (alt+d)");
		menuCompetitor.add(menuCompetitorDelete);
		// Menu Competitor - delete

		// Menu Competitor - edit
		JMenuItem menuCompetitorEdit = new JMenuItem("EDYTUJ");
		menuCompetitorEdit.setMnemonic(KeyEvent.VK_F);
		menuCompetitorEdit.setToolTipText("EDYTUJ Zawodnika (alt+F)");
		menuCompetitor.add(menuCompetitorEdit);
		// Menu Competitor - edit

		// Menu Competitor //

		// Menu RFID //
		JMenu menuRFID = new JMenu("RFID");
		menuRFID.setMnemonic(KeyEvent.VK_Q);
		menuRFID.setToolTipText("Menu RFID (alt+q)");
		menuBar.add(menuRFID);

		// Menu RFID - connect
		JMenuItem menuRFIDConnect = new JMenuItem("POŁĄCZ",
				menuRFIDConnectIcon);
		menuRFIDConnect.setMnemonic(KeyEvent.VK_Q);
		menuRFIDConnect.setToolTipText("POLACZ (alt+q)");
		menuRFID.add(menuRFIDConnect);
		// Menu RFID - connect

		// Menu RFID - disconnect
		JMenuItem menuRFIDDisconnect = new JMenuItem("ROZŁĄCZ");
		menuRFIDDisconnect.setMnemonic(KeyEvent.VK_W);
		menuRFIDDisconnect.setToolTipText("POLACZ (alt+w)");
		menuRFID.add(menuRFIDDisconnect);
		// Menu RFID - disconnect

		// Menu RFID - set to competitor
		JMenuItem menuRFIDSetToCompetitor = new JMenuItem(
				"PRZYPISZ DO ZAWODNIKA");
		menuRFIDSetToCompetitor.setMnemonic(KeyEvent.VK_E);
		menuRFIDSetToCompetitor.setToolTipText("Przypisuje (alt+e)");
		menuRFID.add(menuRFIDSetToCompetitor);
		// Menu RFID - set to competitor

		// Menu RFID - code Tag
		JMenuItem menuRFIDCodeTag = new JMenuItem("ZAKODUJ TAG");
		menuRFIDCodeTag.setMnemonic(KeyEvent.VK_R);
		menuRFIDCodeTag.setToolTipText("Koduje (alt+r)");
		menuRFID.add(menuRFIDCodeTag);
		// Menu RFID - code Tag

		// Menu RFID //

		// Menu Quit //
		JMenu menuQuit = new JMenu("QUIT");
		menuQuit.setMnemonic(KeyEvent.VK_Q);
		menuQuit.setToolTipText("Wyjście z aplikacji (alt+Q)");

		JMenuItem eMenuQuit = new JMenuItem("QUIT", quitIcon);
		eMenuQuit.addActionListener(getQuitActionObject());

		menuBar.add(menuQuit);

		menuQuit.add(eMenuQuit);
		// Menu Quit //
		setJMenuBar(menuBar);

		// TABS //

		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());

		getContentPane().add(topPanel);

		// Create the tab pages
		createPage1();
		createPage2();

		tabbedPane = new JTabbedPane();
		tabbedPane.addTab("LISTA STARTOWA", jpanelStartList);
		tabbedPane.addTab("WYSCIG", jpanelRace);
		topPanel.add(tabbedPane, BorderLayout.CENTER);

		// TABS //

	}

	public void createPage1() {

		jpanelStartList = new JPanel();
		jpanelStartList.setLayout(new BorderLayout());
		// IF WE WANT TO MOVE TOOLBAR WHEN RESIZING PASTE LINE BELOW
		// jpanelStartList.setLayout(new BoxLayout(jpanelStartList,
		// BoxLayout.PAGE_AXIS));

		// TOOLBAR

		JToolBar jtoolbarStartList = new JToolBar();
		jtoolbarStartList.setLayout(new GridLayout());
		jtoolbarStartList.setFloatable(false);

		JLabel label1 = new JLabel("  ");
		jtoolbarStartList.add(label1);

		ImageIcon icon1 = new ImageIcon("images/blank.png");
		JButton z1 = new JButton("NOWE", icon1);
		jtoolbarStartList.add(z1);

		ImageIcon icon2 = new ImageIcon("images/blank.png");
		JButton z2 = new JButton("WCZYTAJ", icon2);
		jtoolbarStartList.add(z2);

		ImageIcon icon3 = new ImageIcon("images/blank.png");
		JButton z3 = new JButton("EDYTUJ", icon3);
		jtoolbarStartList.add(z3);

		JLabel label2 = new JLabel("  ");
		jtoolbarStartList.add(label2);

		ImageIcon icon4 = new ImageIcon("images/blank.png");
		JButton zaw1 = new JButton("NOWY", icon4);
		jtoolbarStartList.add(zaw1);

		ImageIcon icon5 = new ImageIcon("images/blank.png");
		JButton zaw2 = new JButton("USUŃ", icon5);
		jtoolbarStartList.add(zaw2);

		ImageIcon icon6 = new ImageIcon("images/blank.png");
		JButton zaw3 = new JButton("EDYTUJ", icon6);
		jtoolbarStartList.add(zaw3);

		JLabel label3 = new JLabel("  ");
		jtoolbarStartList.add(label3);

		ImageIcon icon7 = new ImageIcon("images/blank.png");
		JButton r1 = new JButton("POŁĄCZ", icon7);
		jtoolbarStartList.add(r1);

		ImageIcon icon8 = new ImageIcon("images/blank.png");
		JButton r2 = new JButton("ROZŁĄCZ", icon8);
		jtoolbarStartList.add(r2);

		ImageIcon icon9 = new ImageIcon("images/blank.png");
		JButton r3 = new JButton("PRZYPISZ", icon9);
		jtoolbarStartList.add(r3);

		ImageIcon icon10 = new ImageIcon("images/blank.png");
		JButton r4 = new JButton("ZAKODUJ", icon10);
		jtoolbarStartList.add(r4);

		// TOOLBAR

		competition = new Competition();
		list = competition.createList1();

		jpanelInside = new JPanel();
		jpanelInside
				.setLayout(new BoxLayout(jpanelInside, BoxLayout.LINE_AXIS));
		jpanelInside.setPreferredSize(new Dimension(600, 400));

		listScroller = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension(500, 60));
		jpanelInside.add(listScroller, BorderLayout.WEST);

		rightPane = new JScrollPane();
		rightPane.setPreferredSize(new Dimension(140, 80));
		jpanelInside.add(rightPane, BorderLayout.EAST);

		// ADD CONTENTS

		jpanelStartList.add(jtoolbarStartList, BorderLayout.NORTH);
		jpanelStartList.add(jpanelInside, BorderLayout.CENTER);

		// ADD CONTENTS

	}

	public class MenuCompetitionNewListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO tutaj musze potestowac te smiecie
			competition = new Competition(addNewCompetition);
			competition.initUI(jpanelInside, rightPane);
			// System.out.println(competition.listFirstOption[0]);
			// competition.jboxFirstOption.action;
			// if(competition.listFirstOption[0] == "A") {
			// jpanelInside.removeAll();
			// JTable list2 = competition.createList2();
			// listScroller = new JScrollPane(list2);
			// jpanelInside.add(listScroller, BorderLayout.WEST);
			// jpanelInside.add(rightPane, BorderLayout.EAST);
			// }
		}
	}

	public void createPage2() {

		jpanelRace = new JPanel();
		jpanelRace.setLayout(new BorderLayout());

		// TOOLBAR

		JToolBar jtoolbarRace = new JToolBar();

		ImageIcon icon1 = new ImageIcon("images/blank.png");
		JButton startButton1 = new JButton("start", icon1);
		jtoolbarRace.add(startButton1);

		ImageIcon icon2 = new ImageIcon("images/blank.png");
		JButton startButton2 = new JButton("stop", icon2);
		jtoolbarRace.add(startButton2);

		jpanelRace.add(jtoolbarRace, BorderLayout.NORTH);

		// TOOLBAR

	}

	private void initExitOnClose() { // Initiate button X on window pane

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exitOnClose();
			}
		});

	}

	private void exitOnClose() { // Functionality of button X on window pane

		if (JOptionPane.showConfirmDialog(this,
				"Jesteś pewny, że chcesz wyjść?", "Zatwierdź",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	private Action getQuitActionObject() { // Functionality menuItem quit
		Action quitAction = new AbstractAction("QUIT") {
			public void actionPerformed(ActionEvent event) {
				exitOnClose();
			}
		};
		return quitAction;
	}

	public static void windowStart() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Window window = new Window();
				window.setVisible(true);
			}
		});
	}
}
