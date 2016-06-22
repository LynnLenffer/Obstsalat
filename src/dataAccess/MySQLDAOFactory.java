package dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDAOFactory extends DAOFactory {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/obstsalat";
    private static final String USER = "root";
    private static final String PASSWORD = "root";


    @Override
    public UserDAO getUserDAO() {
        return new MySQLUserDAO();
    }

    @Override
    public PostDAO getPostDAO() {
        return new MySQLPostDAO();
    }

    @Override
    public void shutdown() {}



    public static Connection createConnection() {

        Connection connection = null;

        try {

            Class.forName(DRIVER).newInstance();
            System.out.println("Driver was registered.");

            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Connected to database");

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;

    }


}
