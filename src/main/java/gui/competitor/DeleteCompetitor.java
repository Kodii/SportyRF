package gui.competitor;

import gui.database.Select;

import java.util.ArrayList;

public class DeleteCompetitor extends Competitor {

	private ArrayList<Competitor> competitorList;
	private Competitor competitor;

	public DeleteCompetitor() {
		
		competitorList = new ArrayList<Competitor>();
		
		fillCompetitorList();

//		printAllCompetitorsToConsole();
	}
	
	private void fillCompetitorList(){
		
		for (int i = 1; i < Select.getCompetitorId(); i++) {
			competitor = new Competitor();
			
			competitor.id = Integer.parseInt((String) Select.getCompetitor(i).get("competitorID"));
			competitor.name = (String) Select.getCompetitor(i).get("competitorName");
			competitor.surname = (String) Select.getCompetitor(i).get("competitorSurname");
			competitor.gender = Integer.parseInt((String) Select.getCompetitor(i).get("competitorGender"));
			competitor.date = (String) Select.getCompetitor(i).get("competitorBirth");
			competitor.city = (String) Select.getCompetitor(i).get("competitorCity");
			competitor.district = (String) Select.getCompetitor(i).get("competitorDistrict");
			competitor.team = Integer.parseInt((String) Select.getCompetitor(i).get("competitorTeam"));
			competitor.weight = (String) Select.getCompetitor(i).get("competitorWeight");
			competitor.height = (String) Select.getCompetitor(i).get("competitorHeight");
			competitor.category = Integer.parseInt((String) Select.getCompetitor(i).get("competitorCategory"));
			competitor.startNumber = Integer.parseInt((String) Select.getCompetitor(i).get("competitorStartNumber"));
			competitor.text = competitor.name + " " + competitor.surname + " " + competitor.date;
			
			competitorList.add(competitor);
		}
	}
	
	public void printAllCompetitorsToConsole(){
		
		for(int i=0; i < competitorList.size(); i++){
			competitor = competitorList.get(i);
			
			System.out.printf("\nCompetitor: %d ",competitor.id);
			System.out.printf("\n\tName: %s ",competitor.name);
			System.out.printf("\n\tSurname: %s ",competitor.surname);
			System.out.printf("\n\tGender: %s ",competitor.gender);
			System.out.printf("\n\tBirth: %s ",competitor.date);
			System.out.printf("\n\tCity: %s ",competitor.city);
			System.out.printf("\n\tDistrict: %s ",competitor.district);
			System.out.printf("\n\tTeam: %s ",competitor.team);
			System.out.printf("\n\tWeight: %s ",competitor.weight);
			System.out.printf("\n\tHeight: %s ",competitor.height);
			System.out.printf("\n\tCategory: %s ",competitor.category);
			System.out.printf("\n\tStart Number: %s \n",competitor.startNumber);
		}
	}
	
	public ArrayList<Competitor> getCompetitorList() {
		return competitorList;
	}

	public void setCompetitorList(ArrayList<Competitor> competitorList) {
		this.competitorList = competitorList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
