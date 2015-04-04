package gui.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Delete extends DatabaseConnection{
	
	public static boolean deleteCompetitorByID(Integer competitorID){
		
		System.out.println("DELETING COMPETITOR");
		
		try{
			Connection connection = getConnection();
			PreparedStatement deleteEvent = connection.prepareStatement("DELETE FROM PARTICIPANT WHERE id=?");
			deleteEvent.setInt(1, competitorID);
			deleteEvent.executeUpdate();
			
			connection.commit();
			connection.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
		return false;
	}
}
