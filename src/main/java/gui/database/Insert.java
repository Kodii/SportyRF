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
            
            insertEvent = connection.prepareStatement("INSERT INTO START_TYPE(id, name) VALUES(?,?)");
            insertEvent.setInt(1, competition_id);
            if(startType == 1){
            	insertEvent.setString(2, "WSPOLNY");
            }
            if(startType == 2){
            	insertEvent.setString(2, "INDYWIDUALNY");
            }
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
    									   	Integer gender,
    									   	String birt,
    									   	String city,
    									   	String district,
    									   	Integer team,
    									   	String weight,
    									   	String height,
    									   	Integer category,
    									   	Integer startNumber){
    	
    	System.out.println("ADDING COMPETITOR");
    	
    	try{
    		Connection connection = getConnection();
    		int competitior_id = Select.getCompetitorId();
    		PreparedStatement insertEvent = connection.prepareStatement("INSERT INTO Participant(name, surname,gender, birt, id, city, district, team, weight, height, category, startnumber) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
    		
    		insertEvent.setString(1, name);
    		insertEvent.setString(2, surname);
    		insertEvent.setInt(3, gender);
    		insertEvent.setString(4, birt);
    		insertEvent.setInt(5, competitior_id);
    		insertEvent.setString(6, city);
    		insertEvent.setString(7, district);
    		insertEvent.setInt(8, team);
    		insertEvent.setString(9, weight);
    		insertEvent.setString(10, height);
    		insertEvent.setInt(11, category);
    		insertEvent.setInt(12, startNumber);
    		insertEvent.executeUpdate();
    		
    		// adding gender
    		insertEvent = connection.prepareStatement("INSERT INTO Gender(id, gender) VALUES(?,?)");
    		insertEvent.setInt(1, competitior_id);
    		if(gender == 1){
    			insertEvent.setString(2, "MEZCZYZNA");
    		}
    		if(gender == 2){
    			insertEvent.setString(2, "KOBIETA");
    		}
    		insertEvent.executeUpdate();
    		
    		// adding team
    		insertEvent = connection.prepareStatement("INSERT INTO Teams(id, name) VALUES(?,?)");
    		insertEvent.setInt(1, competitior_id);
    		if(team == 1){
    			insertEvent.setString(2, "CZERWONI");
    		}
    		if(team == 2){
    			insertEvent.setString(2, "NIEBIESCY");
    		}
    		if(team == 3){
    			insertEvent.setString(2, "ZIELONI");
    		}
    		insertEvent.executeUpdate();
    		
    		// adding category
    		insertEvent = connection.prepareStatement("INSERT INTO Category(id, name) VALUES(?,?)");
    		insertEvent.setInt(1, competitior_id);
    		if(category == 1){
    			insertEvent.setString(2, "DO 25");
    		}
    		if(category == 2){
    			insertEvent.setString(2, "DO 35");
    		}
    		if(category == 3){
    			insertEvent.setString(2, "DO 45");
    		}
    		if(category == 4){
    			insertEvent.setString(2, "DO 55");
    		}
    		if(category == 5){
    			insertEvent.setString(2, "ELITA");
    		}
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

