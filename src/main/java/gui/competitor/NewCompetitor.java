package gui.competitor;

import gui.database.Insert;
import gui.database.Select;

public class NewCompetitor extends Competitor {

	private NewCompetitorWindow competitorWindow;
	private int num;

	public NewCompetitor(NewCompetitorWindow newCompetitorWindow) {
		competitorWindow = newCompetitorWindow;

		databaseInsert();

		competitorWindow.dispose();
	}

	private void databaseInsert() {

		name = competitorWindow.getNameTextField().getText();
		surname = competitorWindow.getSurnameTextField().getText();
		date = competitorWindow.getDateTextField().getText();
		city = competitorWindow.getCityTextField().getText();
		district = competitorWindow.getDistrictTextField().getText();
		category = competitorWindow.getCategoryComboBox().getSelectedIndex() + 1;
		gender = competitorWindow.getGenderComboBox().getSelectedIndex() + 1;
		weight = competitorWindow.getWeightTextField().getText();
		height = competitorWindow.getHeightTextField().getText();
		team = competitorWindow.getTeamComboBox().getSelectedIndex() + 1;
		startNumber = Integer.parseInt(competitorWindow
				.getStartNumberTextField().getText());

		Insert.insertCompetitor(name, surname, gender, date, city, district,
				team, weight, height, category, startNumber);

		System.out.println("Inserted:"
				+ Select.getCompetitor(Select.getCompetitorId() - 1));
		
//		for(int i = 1; i < Select.getCompetitorId(); i++){
//			System.out.println(Select.getCompetitor(i));
//		}

	}

}
