package gui.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Select extends DatabaseConnection {

    public static ResultSet getUsers() {
        ResultSet rs = null;

        Select con = new Select();
        Connection connection = con.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users");
            rs = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }
}
