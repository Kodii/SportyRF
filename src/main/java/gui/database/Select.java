package gui.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select extends DatabaseConnection {

    public static ResultSet getUsers() {
        System.out.println("TRYING TO GET USERS");
        ResultSet rs = null;
        Connection connection = getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Participant");
            rs = statement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("GOT USERS... RETURNING DATA");

        return rs;
    }
}
