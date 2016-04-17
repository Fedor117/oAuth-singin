package controller.operations;

import model.DbConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Fedor on 16.04.2016.
 */
public class UpdateOperator implements DbOperation {

    private Statement statement;

    public String requestToDb(String name, String definition) {
        Connection connection = DbConnection.connection;
        try {
            statement = connection.createStatement();
            String sql = "UPDATE local_nets SET definition = '" +
                    definition + "' WHERE name='" + name + "';";
            statement.executeUpdate(sql);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return MESSAGE_UPDATE;
    }
}
