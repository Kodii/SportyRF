package gui.competitor;

import java.awt.Container;

public abstract class Competitor {
	private String name;
	private String surname;
	private String date;
	private String city;
	private String district;
	private String category;
	private String gender;
	private String weight;
	private String height;
	private String team;
	private int startNumber;

	protected Container contentPane = new Container();

	private void initUI() {
	}
}
