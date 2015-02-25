package gui.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class Select extends DatabaseConnection {

    public static String getCompetitionId() {
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

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (rowId == 0){
            return "1";
        }else{
            return Integer.toString(rowId + 1);
        }

    }

    private static Map<String, String> competitionHashMap (ResultSet rs) {
        Map <String, String> competition = new HashMap<String, String>();

        try {
            competition.put("compId", Integer.toString(rs.getInt(1)));
            competition.put("compName", rs.getString(2));
            competition.put("compPlace", rs.getString(3));
            competition.put("compDate", rs.getString(4));
            competition.put("compLaps", rs.getString(5));
            competition.put("compStartType", Integer.toString(rs.getInt(6)));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return competition;

    }

    public static Map getCompetitionById(int competitionId){
        System.out.println("TRYING TO GET COMPETITION BY ID");
        Map<String, String> competitionMap = new HashMap<String, String>();
        ResultSet rs = null;


        try {
            Connection connection = getConnection();
            PreparedStatement getCompetitionStm = connection.prepareStatement(
                    "SELECT id, name, place, date, laps, start_type " +
                            "FROM Contest " +
                            "WHERE id=?");

            getCompetitionStm.setInt(1, competitionId);
            rs = getCompetitionStm.executeQuery();
            rs.next();

            competitionMap = competitionHashMap(rs);
            System.out.println("DONE");

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return competitionMap;

    }

    public static Map getAllCompetitions() {
        System.out.println("TRYING TO GET ALL COMPETITIONS");

        ResultSet rs = null;
        Map <Integer, Map> allCompetitions = new HashMap<Integer, Map>();

        try {
            Connection connection = getConnection();
            PreparedStatement getCompetitionStm = connection.prepareStatement(
                    "SELECT id, name, place, date, laps, start_type " +
                            "FROM Contest");

            rs = getCompetitionStm.executeQuery();
            connection.close();

            while (rs.next()) {
                allCompetitions.put(rs.getInt(1), competitionHashMap(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allCompetitions;

    }

    private static Map userHashMap(ResultSet rs) {
        Map<String, String> userMap = new HashMap<String, String>();

        try {
            userMap.put("userId", Integer.toString(rs.getInt(1)));
            userMap.put("userName", rs.getString(2));
            userMap.put("userSurname", rs.getString(3));
            userMap.put("userBirth", rs.getString(4));
            userMap.put("userCity", rs.getString(5));
            userMap.put("userDistrict", rs.getString(6));
            userMap.put("userTeam", Integer.toString(rs.getInt(7)));
            userMap.put("userWeight", rs.getString(8));
            userMap.put("userHeight", rs.getString(9));
            userMap.put("userCategory", Integer.toString(rs.getInt(10)));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userMap;
    }

    public static Map getUsers() {
        System.out.println("TRYING TO GET USERS");
        HashMap<Integer, Map> usersMap = new HashMap<Integer, Map>();
        ResultSet rs = null;

        try {
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT id, name, surname, birt, city, district, team, weight, hieght, category " +
                            "FROM Participant");
            rs = statement.executeQuery();
            connection.close();

            while (rs.next()){
                usersMap.put(rs.getInt(1), userHashMap(rs));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("GOT USERS... RETURNING DATA");

        return usersMap;
    }

    public static Map getUserById(String participantId) {
        System.out.println("TRYING TO GET USER FROM ID");
        Map<String, String> userMap = new HashMap<String, String>();
        ResultSet rs = null;

        try {
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT id, name, surname, birt, city, district, team, weight, hieght, category " +
                            "FROM Participant" +
                            "WHERE id=?");
            statement.setInt(1, Integer.parseInt(participantId));
            rs = statement.executeQuery();
            connection.close();

            rs.next();

            userMap = userHashMap(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("GOT USERS... RETURNING DATA");

        return userMap;

    }

    public static HashMap getCategoryAll() {
        System.out.println("TRYING TO GET ALL CATOGORIES");

        ResultSet rs = null;
        HashMap<Integer, String> allCategories = new HashMap<Integer, String>();


        try {
            Connection connection = getConnection();
            PreparedStatement getAllCategories = connection.prepareStatement(
                    "SELECT id, name FROM Category");
            rs = getAllCategories.executeQuery();

            while (rs.next()) {
                allCategories.put(rs.getInt(1), rs.getString(2));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allCategories;

    }

    public static void hashTableTest(Map table){
        Set set = table.entrySet();
        Iterator i = set.iterator();

        while(i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next();
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }

    }


}


