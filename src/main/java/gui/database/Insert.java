package gui.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import gui.database.Select;

public class Insert extends DatabaseConnection {
    public static boolean insertCompetition(String name,
                                            String place,
                                            String date,
                                            String laps,
                                            Integer start_type)
    {
        System.out.println("ADDING COMPETITION");
        Connection connection = getConnection();

        try {
            int competition_id = gui.database.Select.getCompetitionId();
            PreparedStatement insert_event = connection.prepareStatement("INSERT INTO Contest(id, name, place, date, laps, start_type) VALUES (%d)");
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
