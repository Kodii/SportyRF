package gui.competitor;

import gui.Window;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class NewCompetitor extends Competitor {

	private Window window;
	private JFrame frame;

	public NewCompetitor(Window window) {
		this.window = window;

		frame = new JFrame();

		frame.setTitle("DODAJ NOWEGO ZAWODNIKA");
		frame.setSize(650, 250);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);

		initUI();
	}

	private void initUI() {
		
		Container contentPane = new Container();
		contentPane = frame.getContentPane();
		
		// mainPanel
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		contentPane.add(mainPanel, BorderLayout.NORTH);
		
		// competitorName
		JPanel panelCompetitorName = new JPanel();
		panelCompetitorName.setLayout(new GridLayout(1,2));
		JLabel labelCompetitorName = new JLabel("Imiê zawodnika");
		labelCompetitorName.setHorizontalAlignment(SwingConstants.CENTER);
		JTextField textFieldCompetitiorName = new JTextField();
		panelCompetitorName.add(labelCompetitorName);
		panelCompetitorName.add(textFieldCompetitiorName);
		mainPanel.add(panelCompetitorName);
		
		// competitorSurname
		JPanel panelCompetitorSurname = new JPanel();
		panelCompetitorSurname.setLayout(new GridLayout(1,2));
		JLabel labelCompetitorSurname = new JLabel("Nazwisko zawodnika");
		labelCompetitorSurname.setHorizontalAlignment(SwingConstants.CENTER);
		JTextField textFieldCompetitiorSurname = new JTextField();
		panelCompetitorSurname.add(labelCompetitorSurname);
		panelCompetitorSurname.add(textFieldCompetitiorSurname);
		mainPanel.add(panelCompetitorSurname);
		
		// competitorDate
		JPanel panelCompetitorDate = new JPanel();
		panelCompetitorDate.setLayout(new GridLayout(1,2));
		JLabel labelCompetitorDate = new JLabel("Data urodzenia");
		labelCompetitorDate.setHorizontalAlignment(SwingConstants.CENTER);
		JTextField textFieldCompetitiorDate = new JTextField();
		panelCompetitorDate.add(labelCompetitorDate);
		panelCompetitorDate.add(textFieldCompetitiorDate);
		mainPanel.add(panelCompetitorDate);
		
		// competitorCity
		JPanel panelCompetitorCity = new JPanel();
		panelCompetitorCity.setLayout(new GridLayout(1,2));
		JLabel labelCompetitorCity = new JLabel("Miasto zawodnika");
		labelCompetitorCity.setHorizontalAlignment(SwingConstants.CENTER);
		JTextField textFieldCompetitiorCity = new JTextField();
		panelCompetitorCity.add(labelCompetitorCity);
		panelCompetitorCity.add(textFieldCompetitiorCity);
		mainPanel.add(panelCompetitorCity);
		
		
		// competitorDistrict
		JPanel panelCompetitorDistrict = new JPanel();
		panelCompetitorDistrict.setLayout(new GridLayout(1,2));
		JLabel labelCompetitorDistrict = new JLabel("Miasto zawodnika");
		labelCompetitorDistrict.setHorizontalAlignment(SwingConstants.CENTER);
		JTextField textFieldCompetitiorDistrict = new JTextField();
		panelCompetitorDistrict.add(labelCompetitorDistrict);
		panelCompetitorDistrict.add(textFieldCompetitiorDistrict);
		mainPanel.add(panelCompetitorDistrict);
		
		// competitiorCategory
		JPanel panelCompetitorCategory = new JPanel();
		panelCompetitorCategory.setLayout(new GridLayout(1,2));
		
		// competitorGender
		JPanel panelCompetitorGender = new JPanel();
		panelCompetitorGender.setLayout(new GridLayout(1,2));
		
		// competitorWeight
		JPanel panelCompetitorWeight = new JPanel();
		panelCompetitorWeight.setLayout(new GridLayout(1,2));
		
		// competitorHeight
		JPanel panelCompetitorHeight = new JPanel();
		panelCompetitorHeight.setLayout(new GridLayout(1,2));
	
		// competitiorTeam
		JPanel panelCompetitorTeam = new JPanel();
		panelCompetitorTeam.setLayout(new GridLayout(1,2));

		// competitiorStartNumber
		JPanel panelCompetitorStartNumber = new JPanel();
		panelCompetitorStartNumber.setLayout(new GridLayout(1,2));
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
