package gui.competitor.delete.window;

import gui.competitor.Competitor;
import gui.competitor.delete.DeleteCompetitor;
import gui.intefaces.NewWindow;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class DeleteCompetitorWindow extends NewWindow {
	
	private JPanel mainPanel, deletePanel;
	
	private JScrollPane deleteScrollPane;

	private JLabel deleteLabel;

	private JList deleteList;
	private DefaultListModel listModel;

	private DeleteCompetitor deleteCompetitor;
	private ArrayList<Competitor> competitorList;
	
	
	
	private Competitor competitor;

	public DeleteCompetitorWindow() {
		super();
		setSize(640,220);
		setTitle("USUWANIE ZAWODNIKA");
		setVisible(true);
		
	}

	public void initUI() {
		
		deleteCompetitor = new DeleteCompetitor();
		competitorList = deleteCompetitor.getCompetitorList();
//		selectedCompetitors = new ArrayList();

		contentPane = new Container();
		contentPane = getContentPane();

		// mainPanel
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		contentPane.add(mainPanel, BorderLayout.NORTH);

		// deletePanel
		deletePanel = new JPanel();
		deletePanel.setLayout(new GridLayout(1, 2));
		deleteLabel = new JLabel("Wybierz zawodnika");
		deleteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		listModel = new DefaultListModel();
		for(int i=0; i < competitorList.size(); i++){
			listModel.addElement(competitorList.get(i).getName() + " " +
								 competitorList.get(i).getSurname() + " " +
								 competitorList.get(i).getDate());
		}	
		deleteList = new JList(listModel);
		deleteScrollPane = new JScrollPane();
		deleteScrollPane.setViewportView(deleteList);
		
		deletePanel.add(deleteLabel);
		deletePanel.add(deleteScrollPane);
		mainPanel.add(deletePanel);
		
		// deleteButton
		confirmButton = new JButton("OK");
		confirmButton.setHorizontalAlignment(SwingConstants.CENTER);
		confirmButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				
				
				deleteCompetitor.delete(deleteList);
				dispose();
			}
		});
		
		mainPanel.add(confirmButton);
		
		
		
		
		
		
		
		
		
		
		

	}

}
