package model;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Fedor on 17.04.2016.
 */
public class DbConnection {

    private static final String PATH_TO_DB =
            "db//users.db";

    public  static          Connection   connection;
    private static volatile DbConnection instance;


    private DbConnection() {

    }

    public static DbConnection getInstance() {
        DbConnection localInstance = instance;
        if (localInstance == null) {
            synchronized (DbConnection.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DbConnection();
                }
            }
        }
        return localInstance;
    }

    public void connectToDb() {
        connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + PATH_TO_DB);
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
}