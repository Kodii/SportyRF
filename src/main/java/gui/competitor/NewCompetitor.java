package gui.competitor;

import gui.database.Insert;
import gui.database.Select;

public class NewCompetitor extends Competitor{
	
	private NewCompetitorWindow competitorWindow;
	
	public NewCompetitor(NewCompetitorWindow newCompetitorWindow){
		competitorWindow = newCompetitorWindow;
		
		databaseInsert();
		
		competitorWindow.dispose();
	}
	
	private void databaseInsert(){
		
	}

}
