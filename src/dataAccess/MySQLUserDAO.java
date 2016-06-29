package dataAccess;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLUserDAO implements UserDAO {


    @Override
    public boolean addUser(User user) {

        boolean success = false;

        Connection connection = MySQLDAOFactory.createConnection();

        String statement = "INSERT INTO Users (user_name, user_email, user_password, user_last_login, user_avatar) VALUES (?, ?, ?, ?, ?)";

        try {

            PreparedStatement stmt = connection.prepareStatement(statement);

            stmt.setString(1, user.getUser_name());
            stmt.setString(2, user.getUser_email());
            stmt.setString(3, user.getUser_password());
            stmt.setTimestamp(4, null);
            stmt.setString(5, user.getUser_avatar());

            stmt.execute();
            stmt.close();

            success = true;

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return success;

    }

    @Override
    public User getUser(String email) {

        User user = new User();

        Connection connection = MySQLDAOFactory.createConnection();

        String statement = "SELECT * FROM Users WHERE user_email = ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(statement);

            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                user.setUser_id( rs.getInt("user_id") );
                user.setUser_name( rs.getString("user_name") );
                user.setUser_email( rs.getString("user_email") );
                user.setUser_password( rs.getString("user_password") );
                user.setUser_last_login( rs.getTimestamp("user_last_login") );
                user.setUser_avatar( rs.getString("user_avatar") );
                user.setUser_creation_date( rs.getTimestamp("user_creation_date") );

            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return user;
    }

    @Override
    public User getUser(int user_id) {

        User user = new User();

        Connection connection = MySQLDAOFactory.createConnection();

        String statement = "SELECT * FROM Users WHERE user_id = ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(statement);

            stmt.setInt(1, user_id);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                user.setUser_id( rs.getInt("user_id") );
                user.setUser_name( rs.getString("user_name") );
                user.setUser_email( rs.getString("user_email") );
                user.setUser_password( rs.getString("user_password") );
                user.setUser_last_login( rs.getTimestamp("user_last_login") );
                user.setUser_avatar( rs.getString("user_avatar") );
                user.setUser_creation_date( rs.getTimestamp("user_creation_date") );

            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return user;

    }

    @Override
    public boolean deleteUser(User user) {

        boolean success = false;

        Connection connection = MySQLDAOFactory.createConnection();

        String statement = "DELETE FROM Users WHERE user_id = ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(statement);

            stmt.setInt(1, user.getUser_id());

            stmt.execute();
            stmt.close();

            success = true;

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return success;

    }


}
