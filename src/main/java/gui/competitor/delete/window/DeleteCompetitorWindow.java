package gui.competitor.delete.window;

import gui.competitor.Competitor;
import gui.competitor.delete.DeleteCompetitor;
import gui.intefaces.NewWindow;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class DeleteCompetitorWindow extends NewWindow {
	
	private JPanel mainPanel, deletePanel;

	private JLabel deleteLabel;

	private JList deleteList;
	private DefaultListModel listModel;

	protected DeleteCompetitor deleteCompetitor;
	protected ArrayList<Competitor> competitorList;
	private Competitor competitor;

	public DeleteCompetitorWindow() {
		super();
		setTitle("USUWANIE ZAWODNIKA");
		
	}

	public void initUI() {
		
		deleteCompetitor = new DeleteCompetitor();
		competitorList = deleteCompetitor.getCompetitorList();

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
			listModel.addElement(competitorList.get(i).getName());

		}
		
		deleteList = new JList(listModel);
		deletePanel.add(deleteLabel);
		deletePanel.add(deleteList);
		mainPanel.add(deletePanel);

	}

}
