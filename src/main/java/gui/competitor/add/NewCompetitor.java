package gui.competitor.add;

import gui.competitor.Competitor;
import gui.competitor.add.window.NewCompetitorWindow;
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

		setName(competitorWindow.getNameTextField().getText());
		setSurname(competitorWindow.getSurnameTextField().getText());
		setDate(competitorWindow.getDateTextField().getText());
		setCity(competitorWindow.getCityTextField().getText());
		setDistrict(competitorWindow.getDistrictTextField().getText());
		setCategory(competitorWindow.getCategoryComboBox().getSelectedIndex() + 1);
		setGender(competitorWindow.getGenderComboBox().getSelectedIndex() + 1);
		setWeight(competitorWindow.getWeightTextField().getText());
		setHeight(competitorWindow.getHeightTextField().getText());
		setTeam(competitorWindow.getTeamComboBox().getSelectedIndex() + 1);
		setStartNumber(Integer.parseInt(competitorWindow
				.getStartNumberTextField().getText()));

		Insert.insertCompetitor(getName(), getSurname(), getGender(),
				getDate(), getCity(), getDistrict(), getTeam(), getWeight(),
				getHeight(), getCategory(), getStartNumber());

		System.out.println("Inserted:"
				+ Select.getCompetitor(Select.getCompetitorId() - 1));

		// for(int i = 1; i < Select.getCompetitorId(); i++){
		// System.out.println(Select.getCompetitor(i));
		// }

	}

}
