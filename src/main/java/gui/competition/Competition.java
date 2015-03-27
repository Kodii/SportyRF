package gui.competition;

import gui.Window;
import gui.database.Insert;
import gui.database.Select;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class Competition {

	private String title, date, place, laps;
	private int startType;

	private JTable jtableStartList;
	private DefaultTableModel model;
	private TableColumnModel tableColumnModel;

	private Window mainWindow;
	private NewCompetitionWindow window;

	private ArrayList<String> optionList = new ArrayList<String>();

	public Competition(Window mainWindow, NewCompetitionWindow window) {

		this.mainWindow = mainWindow;
		this.window = window;

		jtableStartList = mainWindow.getStartListTable();
		model = (DefaultTableModel) jtableStartList.getModel();
		tableColumnModel = jtableStartList.getColumnModel();

		// clearing colums in table model
		for (int i = 0; i < model.getColumnCount(); i++) {
			model.setColumnIdentifiers(new Object[] {});
			model.setRowCount(0);
		}

		databaseInsert();

		setColumns(); // Setting collumns

		drawTable(); // drawing table into JFrame

		window.dispose(); // disposing add window
	}

	private void databaseInsert() {

		title = window.getCompetitionTitleTextFIeld().getText();
		date = window.getCompetitionDateTextField().getText();
		place = window.getCompetitionPlaceTextField().getText();
		laps = window.getCompetitionLapsTextField().getText();
		if (window.getCompetitionTypeComboBox().getSelectedItem().toString() == "Wspolny")
			startType = 1;
		else
			startType = 2;

		Insert.insertCompetition(title, place, date, laps, startType);

		System.out.println("Inserted:"
				+ Select.getCompetition(Select.getCompetitionId() - 1));

	}

	private void setColumns() {
		optionList.add("NR");
		optionList.add("NAZWISKO");
		optionList.add("IMIÊ");
		if (window.getCompetitionCheckBoxBirth().isSelected() == true) {
			optionList.add("DATA UR");
		}
		if (window.getCompetitionCheckBoxCity().isSelected() == true) {
			optionList.add("MIASTO");
		}
		if (window.getCompetitionCheckBoxDistrict().isSelected() == true) {
			optionList.add("POWIAT");
		}
		if (window.getCompetitionCheckBoxCategory().isSelected() == true) {
			optionList.add("KATEGORIA");
		}
		if (window.getCompetitionCheckBoxGender().isSelected() == true) {
			optionList.add("P£EÆ");
		}
		if (window.getCompetitionCheckBoxWeight().isSelected() == true) {
			optionList.add("WAGA");
		}
		if (window.getCompetitionCheckBoxHeight().isSelected() == true) {
			optionList.add("WZROST");
		}
		if (window.getCompetitionCheckBoxTeam().isSelected() == true) {
			optionList.add("DRU¯YNA");
		}
	}

	private void drawTable() {
		for (int i = 0; i < optionList.size(); i++) {
			model.addColumn(optionList.get(i));
		}

		// SETING COLUMNS WIDHT
		TableColumn column = null;
		String optionListValue;
		for (int i = 0; i < optionList.size(); i++) {
			column = tableColumnModel.getColumn(i);
			optionListValue = optionList.get(i);
			// column.setResizable(false);
			if (optionListValue == "NR") {
				column.setPreferredWidth(70);
			} else if (optionListValue == "NAZWISKO") {
				column.setPreferredWidth(270);
			} else if (optionListValue == "IMIÊ") {
				column.setPreferredWidth(170);
			} else if (optionListValue == "DATA UR") {
				column.setPreferredWidth(220);
			} else if (optionListValue == "MIASTO") {
				column.setPreferredWidth(220);
			} else if (optionListValue == "POWIAT") {
				column.setPreferredWidth(220);
			} else if (optionListValue == "KATEGORIA") {
				column.setPreferredWidth(300);
			} else if (optionListValue == "P£EÆ") {
				column.setPreferredWidth(100);
			} else if (optionListValue == "WAGA") {
				column.setPreferredWidth(100);
			} else if (optionListValue == "WZROST") {
				column.setPreferredWidth(100);
			} else if (optionListValue == "DRU¯YNA") {
				column.setPreferredWidth(220);
			} else {
				column.setPreferredWidth(1700);
			}
		}
	}

}
