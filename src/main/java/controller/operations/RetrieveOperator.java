package controller.operations;

import model.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Fedor on 16.04.2016.
 */
public class RetrieveOperator implements DbOperation {

    private Statement statement;

    public String requestToDb(String name, String definition) {
        Connection connection = DbConnection.connection;
        ResultSet resultSet;
        try {
            statement = connection.createStatement();
            String sql = "SELECT * FROM local_nets WHERE name='" + name + "';";
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                definition = resultSet.getString("definition");
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return definition;
    }
}
