package gui.competition;

public abstract class Competition {
	
	private String title;
	private String date;
	private String place;
	private String laps;
	private int startType;
	public String getTitle() {
		return title;
	}
	public String getDate() {
		return date;
	}
	public String getPlace() {
		return place;
	}
	public String getLaps() {
		return laps;
	}
	public int getStartType() {
		return startType;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public void setLaps(String laps) {
		this.laps = laps;
	}
	public void setStartType(int startType) {
		this.startType = startType;
	}
}
