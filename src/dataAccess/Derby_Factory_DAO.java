package dataAccess;

import java.sql.*;


public class Derby_Factory_DAO extends DAO_Factory{
    public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    public static final String DBURL = "jdbc:derby:C:/Users/LynnInAFaerie/MyDB2;create=true";

    public User_DAO getDAO(){

        return new Derby_User_DAO();
    }

    public static Connection createConnection() {

        Connection connection = null;
        try {
            Class.forName(DRIVER).newInstance();
            connection = DriverManager.getConnection("jdbc:derby:C:/Users/LynnInAFaerie/MyDB2;create=true", "LynnLenffer", "test");
            System.out.println("Connected to database");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;

    }


    @Override
    public User_DAO getUserDAO() {
        // TODO Auto-generated method stub
        return new Derby_User_DAO();
    }


    public void shutdown() {

        final String SHUTDOWN_CODE = "XJ015";
        System.out.println("Shutting down Derby");
        try {
            DriverManager.getConnection("jdbc:derby:;shutdown=true");
        } catch (SQLException e) {
            if (!SHUTDOWN_CODE.equals(e.getSQLState())) {
                e.printStackTrace();
            }
        }
    }

}


