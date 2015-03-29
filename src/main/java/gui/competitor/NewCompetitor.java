package gui.competitor;

public class NewCompetitor {
	
	private NewCompetitorWindow competitorWindow;
	
	public NewCompetitor(NewCompetitorWindow newCompetitorWindow){
		competitorWindow = newCompetitorWindow;
		
		databaseInsert();
		
		competitorWindow.dispose();
	}
	
	private void databaseInsert(){
		
	}

}
