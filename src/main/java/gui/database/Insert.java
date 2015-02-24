package gui.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert extends DatabaseConnection {
    public static boolean insertCompetition(String name,
                                            String place,
                                            String date,
                                            String laps,
                                            Integer start_type)
    {
        System.out.println("ADDING COMPETITION");

        try {
            Connection connection = getConnection();
            int competition_id = Select.getCompetitionId();
            PreparedStatement insert_event = connection.prepareStatement("INSERT INTO Contest(id, name, place, date, laps, start_type) VALUES (?, ?, ?, ?, ?, ?)");

            insert_event.setInt(1, competition_id);
            insert_event.setString(2, name);
            insert_event.setString(3, place);
            insert_event.setString(4, date);
            insert_event.setString(5, laps);
            insert_event.setInt(6, start_type);

            insert_event.executeUpdate();
            connection.commit();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
