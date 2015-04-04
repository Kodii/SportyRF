package gui.competition.add.window;

import gui.Window;
import gui.competition.add.NewCompetition;
import gui.intefaces.NewWindow;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class NewCompetitionWindow extends NewWindow {

	private JPanel mainPanel, titlePanel, datePanel, placePanel, lapsPanel,
			typePanel, checkBoxesOuterPanel, checkBoxesPanel;

	private JLabel titleLabel, dateLabel, placeLabel, lapsLabel, typeLabel,
			checkBoxesLabel;

	private JComboBox typeComboBox;

	private JTextField titleTextField, dateTextField, placeTextField,
			lapsTextField;

	private JCheckBox birthCheckBox, categoryCheckBox, cityCheckBox,
			districtCheckBox, genderCheckBox, weightCheckBox, heightCheckBox,
			teamCheckBox;;

	private NewCompetition competition;

	public NewCompetitionWindow(Window window) {
		super(window);

		setTitle("NOWE ZAWODY");
		setSize(650, 250);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public void initUI() {

		contentPane = new Container();
		contentPane = getContentPane();

		// mainPanel
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		contentPane.add(mainPanel, BorderLayout.NORTH);

		// competitionTitle
		titlePanel = new JPanel();
		titlePanel.setLayout(new GridLayout(1, 2));
		titleLabel = new JLabel("Nazwa zawodów");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleTextField = new JTextField();

		titlePanel.add(titleLabel);
		titlePanel.add(titleTextField);
		mainPanel.add(titlePanel);

		// competitionDate
		datePanel = new JPanel();
		datePanel.setLayout(new GridLayout(1, 2));
		dateLabel = new JLabel("Data zawodów");
		dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateTextField = new JTextField();

		datePanel.add(dateLabel);
		datePanel.add(dateTextField);
		mainPanel.add(datePanel);

		// competitionPlace
		placePanel = new JPanel();
		placePanel.setLayout(new GridLayout(1, 2));
		placeLabel = new JLabel("Miejsce zawodów");
		placeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		placeTextField = new JTextField();

		placePanel.add(placeLabel);
		placePanel.add(placeTextField);
		mainPanel.add(placePanel);

		// competitionLaps
		lapsPanel = new JPanel();
		lapsPanel.setLayout(new GridLayout(1, 2));
		lapsLabel = new JLabel("Liczba okr¹¿eñ");
		lapsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lapsTextField = new JTextField();

		lapsPanel.add(lapsLabel);
		lapsPanel.add(lapsTextField);
		mainPanel.add(lapsPanel);

		// competitionType
		typePanel = new JPanel();
		typePanel.setLayout(new GridLayout(1, 2));
		typeLabel = new JLabel("Rodzaj startu");
		typeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		typeComboBox = new JComboBox();
		typeComboBox.addItem("Wspolny");
		typeComboBox.addItem("Indywidualny");

		typePanel.add(typeLabel);
		typePanel.add(typeComboBox);
		mainPanel.add(typePanel);

		// competitionCheckBoxes
		checkBoxesOuterPanel = new JPanel();
		checkBoxesOuterPanel.setLayout(new GridLayout(1, 2));

		checkBoxesPanel = new JPanel();
		checkBoxesPanel.setLayout(new GridLayout(2, 4));
		checkBoxesLabel = new JLabel("Kolumny tabeli");
		checkBoxesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		birthCheckBox = new JCheckBox("Data UR");
		cityCheckBox = new JCheckBox("Miasto");
		districtCheckBox = new JCheckBox("Powiat");
		categoryCheckBox = new JCheckBox("Kategoria");
		genderCheckBox = new JCheckBox("P³eæ");
		weightCheckBox = new JCheckBox("Waga");
		heightCheckBox = new JCheckBox("Wzrost");
		teamCheckBox = new JCheckBox("Dru¿yna");

		checkBoxesPanel.add(birthCheckBox);
		checkBoxesPanel.add(cityCheckBox);
		checkBoxesPanel.add(districtCheckBox);
		checkBoxesPanel.add(categoryCheckBox);
		checkBoxesPanel.add(genderCheckBox);
		checkBoxesPanel.add(weightCheckBox);
		checkBoxesPanel.add(heightCheckBox);
		checkBoxesPanel.add(teamCheckBox);

		checkBoxesOuterPanel.add(checkBoxesLabel);
		checkBoxesOuterPanel.add(checkBoxesPanel);
		mainPanel.add(checkBoxesOuterPanel);

		// competitionButtons
		confirmButton = new JButton("OK");
		confirmButton.setHorizontalAlignment(SwingConstants.CENTER);
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				competition = new NewCompetition(window, NewCompetitionWindow.this);
			}
		});

		mainPanel.add(confirmButton);

	}

	public JTextField getTitleTextField() {
		return titleTextField;
	}

	public JTextField getDateTextField() {
		return dateTextField;
	}

	public JTextField getPlaceTextField() {
		return placeTextField;
	}

	public JTextField getLapsTextField() {
		return lapsTextField;
	}

	public void setTitleTextField(JTextField titleTextField) {
		this.titleTextField = titleTextField;
	}

	public void setDateTextField(JTextField dateTextField) {
		this.dateTextField = dateTextField;
	}

	public void setPlaceTextField(JTextField placeTextField) {
		this.placeTextField = placeTextField;
	}

	public void setLapsTextField(JTextField lapsTextField) {
		this.lapsTextField = lapsTextField;
	}

	public JComboBox getTypeComboBox() {
		return typeComboBox;
	}

	public JCheckBox getBirthCheckBox() {
		return birthCheckBox;
	}

	public JCheckBox getCategoryCheckBox() {
		return categoryCheckBox;
	}

	public JCheckBox getCityCheckBox() {
		return cityCheckBox;
	}

	public JCheckBox getDistrictCheckBox() {
		return districtCheckBox;
	}

	public JCheckBox getGenderCheckBox() {
		return genderCheckBox;
	}

	public JCheckBox getWeightCheckBox() {
		return weightCheckBox;
	}

	public JCheckBox getHeightCheckBox() {
		return heightCheckBox;
	}

	public JCheckBox getTeamCheckBox() {
		return teamCheckBox;
	}

	public void setTypeComboBox(JComboBox typeComboBox) {
		this.typeComboBox = typeComboBox;
	}

	public void setBirthCheckBox(JCheckBox birthCheckBox) {
		this.birthCheckBox = birthCheckBox;
	}

	public void setCategoryCheckBox(JCheckBox categoryCheckBox) {
		this.categoryCheckBox = categoryCheckBox;
	}

	public void setCityCheckBox(JCheckBox cityCheckBox) {
		this.cityCheckBox = cityCheckBox;
	}

	public void setDistrictCheckBox(JCheckBox districtCheckBox) {
		this.districtCheckBox = districtCheckBox;
	}

	public void setGenderCheckBox(JCheckBox genderCheckBox) {
		this.genderCheckBox = genderCheckBox;
	}

	public void setWeightCheckBox(JCheckBox weightCheckBox) {
		this.weightCheckBox = weightCheckBox;
	}

	public void setHeightCheckBox(JCheckBox heightCheckBox) {
		this.heightCheckBox = heightCheckBox;
	}

	public void setTeamCheckBox(JCheckBox teamCheckBox) {
		this.teamCheckBox = teamCheckBox;
	}
}
