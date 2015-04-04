package gui.competitor;


public class Competitor {
	
	private int id;
	private String name;
	private String surname;
	private String date;
	private String city;
	private String district;
	private int category; // int
	private int gender; // int
	private String weight;
	private String height;
	private int team; // int
	private int startNumber;

	private String text;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getDate() {
		return date;
	}

	public String getCity() {
		return city;
	}

	public String getDistrict() {
		return district;
	}

	public int getCategory() {
		return category;
	}

	public int getGender() {
		return gender;
	}

	public String getWeight() {
		return weight;
	}

	public String getHeight() {
		return height;
	}

	public int getTeam() {
		return team;
	}

	public int getStartNumber() {
		return startNumber;
	}

	public String getText() {
		return text;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public void setTeam(int team) {
		this.team = team;
	}

	public void setStartNumber(int startNumber) {
		this.startNumber = startNumber;
	}

	public void setText(String text) {
		this.text = text;
	}

}
