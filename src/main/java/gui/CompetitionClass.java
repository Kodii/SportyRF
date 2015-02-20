package gui;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CompetitionClass {
	
	private String title, date, place, startType, laps;

	public CompetitionClass() {
		
	}
	
	public void printText(){
		System.out.println("\nNew competition:");
		System.out.println("\tTitle: "+ getTitle());
		System.out.println("\tDate: " + getDate());
		System.out.println("\tPlace: " + getPlace());
		System.out.println("\tLaps: " + getLaps());
		System.out.println("\tStartType: " + getStartType());
	}
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getStartType() {
		return startType;
	}

	public void setStartType(String startType) {
		this.startType = startType;
	}

	public String getLaps() {
		return laps;
	}

	public void setLaps(String laps) {
		this.laps = laps;
	}

}
