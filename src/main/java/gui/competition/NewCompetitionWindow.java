package gui.competition;

import gui.Window;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class NewCompetitionWindow extends JFrame {

	private JPanel mainPanel, competitionTitlePanel, competitionDatePanel,
			competitionPlacePanel, competitionLapsPanel, competitionTypePanel,
			competitionCheckBoxesOuterPanel, competitionCheckBoxesPanel;
	private JComboBox competitionTypeComboBox;
	private JLabel competitionTitleLabel, competititionDateLabel,
			competitionPlaceLabel, competitionLapsLabel, competititonTypeLabel,
			compettionCheckBoxesLabel;
	private JTextField competitionTitleTextFIeld, competitionDateTextField,
			competitionPlaceTextField, competitionLapsTextField;
	private JCheckBox competitionCheckBoxBirth, competitionCheckBoxCity,
			competitionCheckBoxDistrict, competitionCheckBoxCategory,
			competitionCheckBoxGender, competitionCheckBoxWeight,
			competitionCheckBoxHeight, competitionCheckBoxTeam;
	private JButton competitionConfirmButton;

	private Window window;
	private NewCompetitionWindow competitionWindow;

	private Competition competition;

	public NewCompetitionWindow(Window window) {
		this.window = window;
		this.competitionWindow = this;

		setTitle("NOWE ZAWODY");
		setSize(650, 250);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);

		initUI();
	}

	private void initUI() {

		Container contentPane = new Container();
		contentPane = getContentPane();

		// mainPanel
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		contentPane.add(mainPanel, BorderLayout.NORTH);

		// competitionTitle
		competitionTitlePanel = new JPanel();
		competitionTitlePanel.setLayout(new GridLayout(1, 2));
		competitionTitleLabel = new JLabel("Nazwa zawodów");
		competitionTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		competitionTitleTextFIeld = new JTextField();

		competitionTitlePanel.add(competitionTitleLabel);
		competitionTitlePanel.add(competitionTitleTextFIeld);
		mainPanel.add(competitionTitlePanel);

		// competitionDate
		competitionDatePanel = new JPanel();
		competitionDatePanel.setLayout(new GridLayout(1, 2));
		competititionDateLabel = new JLabel("Data zawodów");
		competititionDateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		competitionDateTextField = new JTextField();

		competitionDatePanel.add(competititionDateLabel);
		competitionDatePanel.add(competitionDateTextField);
		mainPanel.add(competitionDatePanel);

		// competitionPlace
		competitionPlacePanel = new JPanel();
		competitionPlacePanel.setLayout(new GridLayout(1, 2));
		competitionPlaceLabel = new JLabel("Miejsce zawodów");
		competitionPlaceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		competitionPlaceTextField = new JTextField();

		competitionPlacePanel.add(competitionPlaceLabel);
		competitionPlacePanel.add(competitionPlaceTextField);
		mainPanel.add(competitionPlacePanel);

		// competitionLaps
		competitionLapsPanel = new JPanel();
		competitionLapsPanel.setLayout(new GridLayout(1, 2));
		competitionLapsLabel = new JLabel("Liczba okr¹¿eñ");
		competitionLapsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		competitionLapsTextField = new JTextField();

		competitionLapsPanel.add(competitionLapsLabel);
		competitionLapsPanel.add(competitionLapsTextField);
		mainPanel.add(competitionLapsPanel);

		// competitionType
		competitionTypePanel = new JPanel();
		competitionTypePanel.setLayout(new GridLayout(1, 2));
		competititonTypeLabel = new JLabel("Rodzaj startu");
		competititonTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		competitionTypeComboBox = new JComboBox();
		competitionTypeComboBox.addItem("Wspolny");
		competitionTypeComboBox.addItem("Indywidualny");

		competitionTypePanel.add(competititonTypeLabel);
		competitionTypePanel.add(competitionTypeComboBox);
		mainPanel.add(competitionTypePanel);

		// competitionCheckBoxes
		competitionCheckBoxesOuterPanel = new JPanel();
		competitionCheckBoxesOuterPanel.setLayout(new GridLayout(1, 2));

		competitionCheckBoxesPanel = new JPanel();
		competitionCheckBoxesPanel.setLayout(new GridLayout(2, 4));
		compettionCheckBoxesLabel = new JLabel("Kolumny tabeli");
		compettionCheckBoxesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		competitionCheckBoxBirth = new JCheckBox("Data UR");
		competitionCheckBoxCity = new JCheckBox("Miasto");
		competitionCheckBoxDistrict = new JCheckBox("Powiat");
		competitionCheckBoxCategory = new JCheckBox("Kategoria");
		competitionCheckBoxGender = new JCheckBox("P³eæ");
		competitionCheckBoxWeight = new JCheckBox("Waga");
		competitionCheckBoxHeight = new JCheckBox("Wzrost");
		competitionCheckBoxTeam = new JCheckBox("Dru¿yna");

		competitionCheckBoxesPanel.add(competitionCheckBoxBirth);
		competitionCheckBoxesPanel.add(competitionCheckBoxCity);
		competitionCheckBoxesPanel.add(competitionCheckBoxDistrict);
		competitionCheckBoxesPanel.add(competitionCheckBoxCategory);
		competitionCheckBoxesPanel.add(competitionCheckBoxGender);
		competitionCheckBoxesPanel.add(competitionCheckBoxWeight);
		competitionCheckBoxesPanel.add(competitionCheckBoxHeight);
		competitionCheckBoxesPanel.add(competitionCheckBoxTeam);

		competitionCheckBoxesOuterPanel.add(compettionCheckBoxesLabel);
		competitionCheckBoxesOuterPanel.add(competitionCheckBoxesPanel);
		mainPanel.add(competitionCheckBoxesOuterPanel);

		// competitionButtons
		competitionConfirmButton = new JButton("OK");
		competitionConfirmButton.setHorizontalAlignment(SwingConstants.CENTER);
		competitionConfirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				competition = new Competition(window, competitionWindow);
			}
		});

		mainPanel.add(competitionConfirmButton);

	}

	public JTextField getCompetitionTitleTextFIeld() {
		return competitionTitleTextFIeld;
	}

	public JTextField getCompetitionDateTextField() {
		return competitionDateTextField;
	}

	public JTextField getCompetitionPlaceTextField() {
		return competitionPlaceTextField;
	}

	public JTextField getCompetitionLapsTextField() {
		return competitionLapsTextField;
	}

	public JComboBox getCompetitionTypeComboBox() {
		return competitionTypeComboBox;
	}

	public JCheckBox getCompetitionCheckBoxBirth() {
		return competitionCheckBoxBirth;
	}

	public JCheckBox getCompetitionCheckBoxCity() {
		return competitionCheckBoxCity;
	}

	public JCheckBox getCompetitionCheckBoxDistrict() {
		return competitionCheckBoxDistrict;
	}

	public JCheckBox getCompetitionCheckBoxCategory() {
		return competitionCheckBoxCategory;
	}

	public JCheckBox getCompetitionCheckBoxGender() {
		return competitionCheckBoxGender;
	}

	public JCheckBox getCompetitionCheckBoxWeight() {
		return competitionCheckBoxWeight;
	}

	public JCheckBox getCompetitionCheckBoxHeight() {
		return competitionCheckBoxHeight;
	}

	public JCheckBox getCompetitionCheckBoxTeam() {
		return competitionCheckBoxTeam;
	}

}
