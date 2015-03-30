package gui.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert extends DatabaseConnection {
    public static boolean insertCompetition(String name,
                                            String place,
                                            String date,
                                            String laps,
                                            Integer startType)
    {
        System.out.println("ADDING COMPETITION");

        try {
            Connection connection = getConnection();
            int competition_id = Select.getCompetitionId();
            PreparedStatement insertEvent = connection.prepareStatement("INSERT INTO Contest(id, name, place, date, laps, start_type) VALUES (?, ?, ?, ?, ?, ?)");

            insertEvent.setInt(1, competition_id);
            insertEvent.setString(2, name);
            insertEvent.setString(3, place);
            insertEvent.setString(4, date);
            insertEvent.setString(5, laps);
            insertEvent.setInt(6, startType);

            insertEvent.executeUpdate();
            connection.commit();
            connection.close();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
	}
    
    public static boolean insertCompetitor(	String name,
    									   	String surname,
    									   	String birt,
    									   	String city,
    									   	String district,
    									   	Integer team,
    									   	String weight,
    									   	String height,
    									   	Integer category){
    	
    	System.out.println("ADDING COMPETITOR");
    	
    	try{
    		Connection connection = getConnection();
    		int competitior_id = Select.getCompetitorId();
    		PreparedStatement insertEvent = connection.prepareStatement("INSERT INTO Participant(name, surname, birt, id, city, district, team, weight, height, category) VALUES (?,?,?,?,?,?,?,?,?,?)");
    		
    		insertEvent.setString(1, name);
    		insertEvent.setString(2, surname);
    		insertEvent.setString(3, birt);
    		insertEvent.setInt(4, competitior_id);
    		insertEvent.setString(5, city);
    		insertEvent.setString(6, district);
    		insertEvent.setInt(7, team);
    		insertEvent.setString(8, weight);
    		insertEvent.setString(9, height);
    		insertEvent.setInt(10, category);
    		insertEvent.executeUpdate();
    		
    		connection.commit();
    		connection.close();
    		
    		return true;
    		
    		
    	} catch (SQLException e){
    		e.printStackTrace();
    	}
    	return false;
    	
    }
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

