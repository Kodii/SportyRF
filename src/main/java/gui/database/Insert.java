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
            int competition_id = Integer.parseInt(Select.getCompetitionId());
            PreparedStatement insertEvent = connection.prepareStatement(
                    "INSERT INTO Contest(id, name, place, date, laps, start_type) " +
                            "VALUES (?, ?, ?, ?, ?, ?)");

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
}
