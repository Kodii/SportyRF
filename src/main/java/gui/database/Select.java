package gui.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class Select extends DatabaseConnection {

    public static int getCompetitionId() {
        int rowId = -1;
        ResultSet rs = null;

        System.out.println("TRYING TO GET LAST COMPETITION ID");

        try {
            Connection connection = getConnection();
            PreparedStatement getLastId = connection.prepareStatement("SELECT MAX(id) from Contest");
            rs = getLastId.executeQuery();
            rs.next();
            rowId = rs.getInt(1);
            connection.close();

            if (rowId == 0){
                return 1;
            }else{
                return rowId + 1;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowId;
    }
    
    public static int getCompetitorId() {
        int rowId = -1;
        ResultSet rs = null;

        System.out.println("TRYING TO GET LAST COMPETITOR ID");

        try {
            Connection connection = getConnection();
            PreparedStatement getLastId = connection.prepareStatement("SELECT MAX(id) from Participant");
            rs = getLastId.executeQuery();
            rs.next();
            rowId = rs.getInt(1);
            connection.close();

            if (rowId == 0){
                return 1;
            }else{
                return rowId + 1;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowId;
    }


    public static ResultSet getUsers() {
        System.out.println("TRYING TO GET USERS");
        ResultSet rs = null;

        try {
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT id, name, surname, gender, birt, city, district, team, weight, height, category, startnumber FROM Participant");
            rs = statement.executeQuery();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("GOT USERS... RETURNING DATA");
       
        return rs;
    }

    public static HashMap getCompetition(int competitionId){
        System.out.println("TRYING TO GET COMPETITION BY ID");

        ResultSet rs = null;
        HashMap <String, String> competition = new HashMap<String, String>();

        try {
            Connection connection = getConnection();
            PreparedStatement getCompetitionStm = connection.prepareStatement("SELECT id, name, place, date, laps, start_type FROM Contest WHERE id=?");
            getCompetitionStm.setInt(1, competitionId);
            rs = getCompetitionStm.executeQuery();
            rs.next();

            competition.put("compId", Integer.toString(rs.getInt(1)));
            competition.put("compName", rs.getString(2));
            competition.put("compPlace", rs.getString(3));
            competition.put("compDate", rs.getString(4));
            competition.put("compLaps", rs.getString(5));
            competition.put("compStartType", Integer.toString(rs.getInt(6)));

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return competition;

    }
    
    public static HashMap getCompetitor(int competitorID){
    	System.out.println("TRYING TO GET COMPETITOR BY ID");
    	
    	ResultSet rs = null;
    	HashMap<String, String> competitor = new HashMap<String, String>();
    	
    	try{
    		Connection connection = getConnection();
    		PreparedStatement getCompetitorStm = connection.prepareStatement("SELECT id, name, surname, gender, birt, city, district, team, weight, height, category, startnumber FROM Participant WHERE id=?");
    		getCompetitorStm.setInt(1, competitorID);
    		rs = getCompetitorStm.executeQuery();
    		rs.next();
    		
    		competitor.put("competitorID", Integer.toString(rs.getInt(1)));
    		competitor.put("competitorName", rs.getString(2));
    		competitor.put("competitorSurname", rs.getString(3));
    		competitor.put("competitorGender", Integer.toString(rs.getInt(4)));
    		competitor.put("competitorBirth", rs.getString(5));
    		competitor.put("competitorCity", rs.getString(6));
    		competitor.put("competitorDistrict", rs.getString(7));
    		competitor.put("competitorTeam", Integer.toString(rs.getInt(8)));
    		competitor.put("competitorWeight", rs.getString(9));
    		competitor.put("competitorHeight", rs.getString(10));
    		competitor.put("competitorCategory", Integer.toString(rs.getInt(11)));
    		competitor.put("competitorStartNumber", Integer.toString(rs.getInt(12)));

    		
    		connection.close();
    	}catch (SQLException e){
    		e.printStackTrace();
    	}
    	
    	return competitor;
    }

    public static void hashTableTest(HashMap table){
        Set set = table.entrySet();
        Iterator i = set.iterator();

        while(i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next();
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }

    }
    
}
