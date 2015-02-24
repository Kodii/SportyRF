package gui.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select extends DatabaseConnection {

    public static int getCompetitionId() {
        int row_id = -1;
        ResultSet rs = null;

        Connection connection = getConnection();

        try {
            PreparedStatement get_last_id_stm = connection.prepareStatement("SELECT MAX(id) from Contest");
            rs = get_last_id_stm.executeQuery();
            rs.next();
            row_id = rs.getInt(1);

            if (row_id == 0){
                return 1;
            }else{
                return row_id;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return row_id;
    }



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
