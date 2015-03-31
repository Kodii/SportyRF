package gui.competitor.delete;

import gui.competitor.Competitor;
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
			
			competitor.setId(Integer.parseInt((String) Select.getCompetitor(i).get("competitorID")));
			competitor.setName((String) Select.getCompetitor(i).get("competitorName"));
			competitor.setSurname((String) Select.getCompetitor(i).get("competitorSurname"));
			competitor.setGender(Integer.parseInt((String) Select.getCompetitor(i).get("competitorGender")));
			competitor.setDate((String) Select.getCompetitor(i).get("competitorBirth"));
			competitor.setCity((String) Select.getCompetitor(i).get("competitorCity"));
			competitor.setDistrict((String) Select.getCompetitor(i).get("competitorDistrict"));
			competitor.setTeam(Integer.parseInt((String) Select.getCompetitor(i).get("competitorTeam")));
			competitor.setWeight((String) Select.getCompetitor(i).get("competitorWeight"));
			competitor.setHeight((String) Select.getCompetitor(i).get("competitorHeight"));
			competitor.setCategory(Integer.parseInt((String) Select.getCompetitor(i).get("competitorCategory")));
			competitor.setStartNumber(Integer.parseInt((String) Select.getCompetitor(i).get("competitorStartNumber")));
			competitor.setText(competitor.getName() + " " + competitor.getSurname() + " " + competitor.getDate());
			
			competitorList.add(competitor);
		}
	}
	
	public void printAllCompetitorsToConsole(){
		
		for(int i=0; i < competitorList.size(); i++){
			competitor = competitorList.get(i);
			
			System.out.printf("\nCompetitor: %d ",competitor.getId());
			System.out.printf("\n\tName: %s ",competitor.getName());
			System.out.printf("\n\tSurname: %s ",competitor.getSurname());
			System.out.printf("\n\tGender: %s ",competitor.getGender());
			System.out.printf("\n\tBirth: %s ",competitor.getDate());
			System.out.printf("\n\tCity: %s ",competitor.getCity());
			System.out.printf("\n\tDistrict: %s ",competitor.getDistrict());
			System.out.printf("\n\tTeam: %s ",competitor.getTeam());
			System.out.printf("\n\tWeight: %s ",competitor.getWeight());
			System.out.printf("\n\tHeight: %s ",competitor.getHeight());
			System.out.printf("\n\tCategory: %s ",competitor.getCategory());
			System.out.printf("\n\tStart Number: %s \n",competitor.getStartNumber());
		}
	}
	
	public ArrayList<Competitor> getCompetitorList() {
		return competitorList;
	}

	public void setCompetitorList(ArrayList<Competitor> competitorList) {
		this.competitorList = competitorList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
