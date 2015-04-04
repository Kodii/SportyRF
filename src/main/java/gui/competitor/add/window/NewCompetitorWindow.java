package gui.competitor.add.window;

import gui.competitor.add.NewCompetitor;
import gui.handlers.MyInputVerifier;
import gui.intefaces.NewWindow;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class NewCompetitorWindow extends NewWindow {

	private JPanel mainPanel, namePanel, surnamePanel, datePanel, cityPanel,
			districtPanel, categoryPanel, genderPanel, weightPanel,
			heightPanel, teamPanel, startNumberPanel;

	private JLabel nameLabel, surnameLabel, dateLabel, cityLabel,
			districtLabel, categoryLabel, genderLabel, weightLabel,
			heightLabel, teamLabel, startNumberLabel;

	private JTextField nameTextField, surnameTextField, dateTextField,
			cityTextField, districtTextField, weightTextField, heightTextField,
			startNumberTextField;

	private JComboBox teamComboBox, categoryComboBox, genderComboBox;

	private NewCompetitor competitor;

	private MyInputVerifier myInputVerifier;

	public NewCompetitorWindow() {
		setTitle("DODAJ NOWEGO ZAWODNIKA");
		setSize(650, 300);
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

		// competitorName
		namePanel = new JPanel();
		namePanel.setLayout(new GridLayout(1, 2));
		nameLabel = new JLabel("Imiê");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameTextField = new JTextField();
		namePanel.add(nameLabel);
		namePanel.add(nameTextField);
		mainPanel.add(namePanel);

		// competitorSurname
		surnamePanel = new JPanel();
		surnamePanel.setLayout(new GridLayout(1, 2));
		surnameLabel = new JLabel("Nazwisko");
		surnameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		surnameTextField = new JTextField();
		surnamePanel.add(surnameLabel);
		surnamePanel.add(surnameTextField);
		mainPanel.add(surnamePanel);

		// competitorDate
		datePanel = new JPanel();
		datePanel.setLayout(new GridLayout(1, 2));
		dateLabel = new JLabel("Data urodzenia");
		dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateTextField = new JTextField();
		datePanel.add(dateLabel);
		datePanel.add(dateTextField);
		mainPanel.add(datePanel);

		// competitorCity
		cityPanel = new JPanel();
		cityPanel.setLayout(new GridLayout(1, 2));
		cityLabel = new JLabel("Miasto");
		cityLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cityTextField = new JTextField();
		cityPanel.add(cityLabel);
		cityPanel.add(cityTextField);
		mainPanel.add(cityPanel);

		// competitorDistrict
		districtPanel = new JPanel();
		districtPanel.setLayout(new GridLayout(1, 2));
		districtLabel = new JLabel("Powiat");
		districtLabel.setHorizontalAlignment(SwingConstants.CENTER);
		districtTextField = new JTextField();
		districtPanel.add(districtLabel);
		districtPanel.add(districtTextField);
		mainPanel.add(districtPanel);

		// competitiorCategory
		categoryPanel = new JPanel();
		categoryPanel.setLayout(new GridLayout(1, 2));
		categoryLabel = new JLabel("Kategoria");
		categoryLabel.setHorizontalAlignment(SwingConstants.CENTER);
		categoryComboBox = new JComboBox();
		categoryComboBox.addItem("DO 25");
		categoryComboBox.addItem("DO 35");
		categoryComboBox.addItem("DO 45");
		categoryComboBox.addItem("DO 55");
		categoryComboBox.addItem("ELITA");
		categoryPanel.add(categoryLabel);
		categoryPanel.add(categoryComboBox);
		mainPanel.add(categoryPanel);

		// competitorGender
		genderPanel = new JPanel();
		genderPanel.setLayout(new GridLayout(1, 2));
		genderLabel = new JLabel("P³eæ");
		genderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		genderComboBox = new JComboBox();
		genderComboBox.addItem("MEZCZYZNA");
		genderComboBox.addItem("KOBIETA");
		genderPanel.add(genderLabel);
		genderPanel.add(genderComboBox);
		mainPanel.add(genderPanel);

		// competitorWeight
		weightPanel = new JPanel();
		weightPanel.setLayout(new GridLayout(1, 2));
		weightLabel = new JLabel("Waga");
		weightLabel.setHorizontalAlignment(SwingConstants.CENTER);
		weightTextField = new JTextField();
		weightPanel.add(weightLabel);
		weightPanel.add(weightTextField);
		mainPanel.add(weightPanel);

		// competitorHeight
		heightPanel = new JPanel();
		heightPanel.setLayout(new GridLayout(1, 2));
		heightLabel = new JLabel("Wzrost");
		heightLabel.setHorizontalAlignment(SwingConstants.CENTER);
		heightTextField = new JTextField();
		heightPanel.add(heightLabel);
		heightPanel.add(heightTextField);
		mainPanel.add(heightPanel);

		// competitiorTeam
		teamPanel = new JPanel();
		teamPanel.setLayout(new GridLayout(1, 2));
		teamLabel = new JLabel("Dru¿yna");
		teamLabel.setHorizontalAlignment(SwingConstants.CENTER);
		teamComboBox = new JComboBox();
		teamComboBox.addItem("CZERWONI");
		teamComboBox.addItem("NIEBIESCY");
		teamComboBox.addItem("ZIELONI");
		teamPanel.add(teamLabel);
		teamPanel.add(teamComboBox);
		mainPanel.add(teamPanel);

		// competitiorStartNumber
		startNumberPanel = new JPanel();
		startNumberPanel.setLayout(new GridLayout(1, 2));
		startNumberLabel = new JLabel("Numer Startowy");
		startNumberLabel.setHorizontalAlignment(SwingConstants.CENTER);
		startNumberTextField = new JTextField();
		myInputVerifier = new MyInputVerifier(startNumberTextField,
				MyInputVerifier.NUMBER);
		startNumberTextField.setInputVerifier(myInputVerifier);

		startNumberPanel.add(startNumberLabel);
		startNumberPanel.add(startNumberTextField);
		mainPanel.add(startNumberPanel);

		// competitorButtons
		confirmButton = new JButton("OK");
		confirmButton.setHorizontalAlignment(SwingConstants.CENTER);
		confirmButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (myInputVerifier.isCanProceed())
					competitor = new NewCompetitor(NewCompetitorWindow.this);
			}
		});

		mainPanel.add(confirmButton);

	}

	public JComboBox getTeamComboBox() {
		return teamComboBox;
	}

	public JComboBox getCategoryComboBox() {
		return categoryComboBox;
	}

	public JComboBox getGenderComboBox() {
		return genderComboBox;
	}

	public JTextField getNameTextField() {
		return nameTextField;
	}

	public JTextField getSurnameTextField() {
		return surnameTextField;
	}

	public JTextField getDateTextField() {
		return dateTextField;
	}

	public JTextField getCityTextField() {
		return cityTextField;
	}

	public JTextField getDistrictTextField() {
		return districtTextField;
	}

	public JTextField getWeightTextField() {
		return weightTextField;
	}

	public JTextField getHeightTextField() {
		return heightTextField;
	}

	public JTextField getStartNumberTextField() {
		return startNumberTextField;
	}

}
