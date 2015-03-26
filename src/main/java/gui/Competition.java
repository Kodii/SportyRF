package gui;

import gui.database.Select;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class Competition extends JFrame {

	private int competitionID;
	private String title, date, place, laps;
	private int startType;

	private JTable jtableStartList;
	private DefaultTableModel model;

	private JPanel jpanelMainPanel, jpanelCompetitionTitle,
			jpanelCompetitionDate, jpanelCompetitionPlace,
			jpanelCompetitionLaps, jpanelCompetitionType,
			jpanelCompetitionButtons, jpanelCompetitionCheckBoxes;
	private JComboBox jboxCompetitionType;
	private JLabel jlabelCompetitionTitle, jlabelCompetitionDate,
			jlabelCompetitionPlace, jlabelCompetitionLaps,
			jlabelCompetitionType, jlabelCompetitionCheckBoxes;
	private JTextField jtextfieldCompetitionTitle, jtextfieldCompetitionDate,
			jtextfieldCompetitionPlace, jtextfieldCompetitionLaps;
	private JCheckBox jcheckboxCompetitionBirth, jcheckboxCompetitionCity,
			jcheckboxCompetitionState, jcheckboxCompetitionCategory,
			jcheckboxCompetitionGender, jcheckboxCompetitionWeight,
			jcheckboxCompetitionHeight, jcheckboxCompetitionTeam;
	private String[] columnNames;
	private JButton jbuttonNewCompetitionConfirm;

	private JScrollPane listScroller;
	private Window window;

	private Select s1;

	private ArrayList<String> optionList = new ArrayList<String>();

	public Competition(Window window) {

		this.window = window;

		jtableStartList = window.getJtableStartList();
		model = (DefaultTableModel) jtableStartList.getModel();

		// clearing colums in table model
		for (int i = 0; i < model.getColumnCount(); i++) {
			model.setColumnIdentifiers(new Object[] {});
		}

		setTitle("NOWE ZAWODY");
		setSize(650, 250);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);

		initUI();
	}

	private void initUI() {

		jpanelMainPanel = new JPanel();
		jpanelMainPanel.setLayout(new BoxLayout(jpanelMainPanel,
				BoxLayout.Y_AXIS));

		jpanelCompetitionTitle = new JPanel();
		jpanelCompetitionTitle.setLayout(new GridLayout(1, 2));

		jpanelCompetitionDate = new JPanel();
		jpanelCompetitionDate.setLayout(new GridLayout(1, 2));

		jpanelCompetitionPlace = new JPanel();
		jpanelCompetitionPlace.setLayout(new GridLayout(1, 2));

		jpanelCompetitionLaps = new JPanel();
		jpanelCompetitionLaps.setLayout(new GridLayout(1, 2));

		jpanelCompetitionType = new JPanel();
		jpanelCompetitionType.setLayout(new GridLayout(1, 2));

		jpanelCompetitionButtons = new JPanel();
		jpanelCompetitionButtons.setLayout(new GridLayout(1, 2));
		jpanelCompetitionCheckBoxes = new JPanel();
		jpanelCompetitionCheckBoxes.setLayout(new GridLayout(2, 4));

		jlabelCompetitionTitle = new JLabel("Nazwa zawodów");
		jlabelCompetitionTitle.setHorizontalAlignment(SwingConstants.CENTER);
		jtextfieldCompetitionTitle = new JTextField();

		jlabelCompetitionDate = new JLabel("Data zawodów");
		jlabelCompetitionDate.setHorizontalAlignment(SwingConstants.CENTER);
		jtextfieldCompetitionDate = new JTextField();

		jlabelCompetitionPlace = new JLabel("Miejsce zawodów");
		jlabelCompetitionPlace.setHorizontalAlignment(SwingConstants.CENTER);
		jtextfieldCompetitionPlace = new JTextField();

		jlabelCompetitionLaps = new JLabel("Liczba okr¹¿eñ");
		jlabelCompetitionLaps.setHorizontalAlignment(SwingConstants.CENTER);
		jtextfieldCompetitionLaps = new JTextField();

		jlabelCompetitionType = new JLabel("Rodzaj startu");
		jlabelCompetitionType.setHorizontalAlignment(SwingConstants.CENTER);
		jboxCompetitionType = new JComboBox();
		jboxCompetitionType.addItem("Wspolny");
		jboxCompetitionType.addItem("Indywidualny");

		jlabelCompetitionCheckBoxes = new JLabel("Kolumny tabeli");
		jlabelCompetitionCheckBoxes
				.setHorizontalAlignment(SwingConstants.CENTER);
		jcheckboxCompetitionBirth = new JCheckBox("Data UR");
		jcheckboxCompetitionCity = new JCheckBox("Miasto");
		jcheckboxCompetitionState = new JCheckBox("Powiat");
		jcheckboxCompetitionCategory = new JCheckBox("Kategoria");
		jcheckboxCompetitionGender = new JCheckBox("P³eæ");
		jcheckboxCompetitionWeight = new JCheckBox("Waga");
		jcheckboxCompetitionHeight = new JCheckBox("Wzrost");
		jcheckboxCompetitionTeam = new JCheckBox("Dru¿yna");

		jbuttonNewCompetitionConfirm = new JButton("OK");
		jbuttonNewCompetitionConfirm
				.setHorizontalAlignment(SwingConstants.CENTER);

		Container contentPane = new Container();
		contentPane = getContentPane();

		contentPane.add(jpanelMainPanel, BorderLayout.NORTH);

		jpanelCompetitionTitle.add(jlabelCompetitionTitle);
		jpanelCompetitionTitle.add(jtextfieldCompetitionTitle);
		jpanelMainPanel.add(jpanelCompetitionTitle);

		jpanelCompetitionDate.add(jlabelCompetitionDate);
		jpanelCompetitionDate.add(jtextfieldCompetitionDate);
		jpanelMainPanel.add(jpanelCompetitionDate);

		jpanelCompetitionPlace.add(jlabelCompetitionPlace);
		jpanelCompetitionPlace.add(jtextfieldCompetitionPlace);
		jpanelMainPanel.add(jpanelCompetitionPlace);

		jpanelCompetitionLaps.add(jlabelCompetitionLaps);
		jpanelCompetitionLaps.add(jtextfieldCompetitionLaps);
		jpanelMainPanel.add(jpanelCompetitionLaps);

		jpanelCompetitionType.add(jlabelCompetitionType);
		jpanelCompetitionType.add(jboxCompetitionType);
		jpanelMainPanel.add(jpanelCompetitionType);

		jpanelCompetitionButtons.add(jlabelCompetitionCheckBoxes);
		jpanelCompetitionCheckBoxes.add(jcheckboxCompetitionBirth);
		jpanelCompetitionCheckBoxes.add(jcheckboxCompetitionCity);
		jpanelCompetitionCheckBoxes.add(jcheckboxCompetitionState);
		jpanelCompetitionCheckBoxes.add(jcheckboxCompetitionCategory);
		jpanelCompetitionCheckBoxes.add(jcheckboxCompetitionGender);
		jpanelCompetitionCheckBoxes.add(jcheckboxCompetitionWeight);
		jpanelCompetitionCheckBoxes.add(jcheckboxCompetitionHeight);
		jpanelCompetitionCheckBoxes.add(jcheckboxCompetitionTeam);
		jpanelCompetitionButtons.add(jpanelCompetitionCheckBoxes);

		jpanelMainPanel.add(jpanelCompetitionButtons);

		jpanelMainPanel.add(jbuttonNewCompetitionConfirm);

		jbuttonNewCompetitionConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				title = jtextfieldCompetitionTitle.getText();
				date = jtextfieldCompetitionDate.getText();
				place = jtextfieldCompetitionPlace.getText();
				laps = jtextfieldCompetitionLaps.getText();
				if (jboxCompetitionType.getSelectedItem().toString() == "Wspolny")
					startType = 1;
				else
					startType = 2;

				Insert.insertCompetition(title, place, date, laps, startType);

				// System.out.println(Select.getCompetition(Select.getCompetitionId()));
				// competition.put("compId", Integer.toString(rs.getInt(1)));
				// competition.put("compName", rs.getString(2));
				// competition.put("compPlace", rs.getString(3));
				// competition.put("compDate", rs.getString(4));
				// competition.put("compLaps", rs.getString(5));
				// competition.put("compStartType",
				// Integer.toString(rs.getInt(6)));
				System.out.println("dodano nastepujaco:");
				System.out.println("compID :"
						+ Select.getCompetition(Select.getCompetitionId() - 1));

				setColumns(); // Setting collumns
				drawTable(); // drawing table into JFrame

				dispose(); // disposing add window

			}
		});

	}

	private void setColumns() {
		optionList.add("NR");
		optionList.add("NAZWISKO");
		optionList.add("IMIÊ");
		if (jcheckboxCompetitionBirth.isSelected() == true) {
			optionList.add("DATA UR");
		}
		if (jcheckboxCompetitionCity.isSelected() == true) {
			optionList.add("MIASTO");
		}
		if (jcheckboxCompetitionState.isSelected() == true) {
			optionList.add("POWIAT");
		}
		if (jcheckboxCompetitionCategory.isSelected() == true) {
			optionList.add("KATEGORIA");
		}
		if (jcheckboxCompetitionGender.isSelected() == true) {
			optionList.add("P£EÆ");
		}
		if (jcheckboxCompetitionWeight.isSelected() == true) {
			optionList.add("WAGA");
		}
		if (jcheckboxCompetitionHeight.isSelected() == true) {
			optionList.add("WZROST");
		}
		if (jcheckboxCompetitionTeam.isSelected() == true) {
			optionList.add("DRU¯YNA");
		}
	}

	private void drawTable() {

		for (int i = 0; i < optionList.size(); i++) {
			model.addColumn(optionList.get(i));
		}

		jtableStartList.setFillsViewportHeight(true);
		setRowColor(jtableStartList);

		// SETING COLUMNS WIDHT

		TableColumn column = null;
		for (int i = 0; i < model.getColumnCount(); i++) {
			column = jtableStartList.getColumnModel().getColumn(i);
			// column.setResizable(false);
			if (i == 0) { // NR
				column.setPreferredWidth(70);
			} else if (i == 1) { // NAZWISKO
				column.setPreferredWidth(270);
			} else if (i == 2) { // IMIE
				column.setPreferredWidth(170);
			} else {
				column.setPreferredWidth(170);
			}
		}

		// SETING COLUMNS WIDHT

	}

	public void setRowColor(JTable table) {
		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table,
					Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				final Component c = super.getTableCellRendererComponent(table,
						value, isSelected, hasFocus, row, column);
				c.setBackground(row % 2 == 0 ? Color.LIGHT_GRAY : Color.WHITE);
				return this;
			}
		});
	}
}
