package dataAccess;


import model.Post;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Derby_User_DAO implements User_DAO {

    @Override
    public boolean addUser(User user) {

        Connection con = Derby_Factory_DAO.createConnection();


        return true;

    }

    @Override
    public User getExistingUser(String name) {

        Connection con = Derby_Factory_DAO.createConnection();

        return null;
    }

    @Override
    public User getUser(String name, String passwort) {

        return null;

    }

    @Override
    public ArrayList<User> getUsers() {

        Connection con = Derby_Factory_DAO.createConnection();

        return null;
    }

    @Override
    public boolean updateUser(User user) {

        Connection con = Derby_Factory_DAO.createConnection();


        return true;

    }

    @Override
    public User getUserById(int id) {

        Connection con = Derby_Factory_DAO.createConnection();

        return null;
    }

    @Override
    public List<User> getUsers(String name) {

        Connection con = Derby_Factory_DAO.createConnection();

        /*List<User> nutzer = new ArrayList<>();

        //SQL-Statement
        String statement = "SELECT * FROM webeng.Users WHERE name LIKE ?";

        try{
            // Prepared Statement erzeugen
            PreparedStatement stmt = con.prepareStatement(statement);
            stmt.setString(1, "%" + name + "%");

            // Statement ausführen
            ResultSet rs = stmt.executeQuery();

            // Inhalte auslesen
            while (rs.next()) {

                User user = new User();

                user.setId(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setPasswort(rs.getString("password"));
                user.setLastLogin(rs.getTimestamp("last_login"));
                user.setEmail(rs.getString("email"));
                user.setNumberLogins(rs.getInt("login_count"));
                user.setSession_ID(rs.getString("session_id"));
                user.setCreationDate(rs.getTimestamp("creationtime"));
                user.setPunkte(userPoints(rs.getInt("login_count")));

                nutzer.add(user);

            }

            stmt.close();

            return nutzer;


        } catch (SQLException e) {

            e.printStackTrace();
            return null;

        } */

        return null;


    }


    @Override
    public List<Post> getByIdPosts(int user_id) {
        return null;
    }

    @Override
    public List<Post> getPosts() {

        Connection con = Derby_Factory_DAO.createConnection();
        List<Post> post = new ArrayList<>();

        //SQL-Statement
        String statement = "SELECT * FROM obstsalat.Post";

        try {
            // Prepared Statement erzeugen
            PreparedStatement stmt = con.prepareStatement(statement);

            // Statement ausführen
            ResultSet rs = stmt.executeQuery();

            System.out.print("im Resultset");
            // Inhalte auslesen
            while (rs.next()) {

                Post postN = new Post();

                postN.setPost_id(rs.getInt("post_id"));
                postN.setPost_message(rs.getString("post_message"));
                postN.setPost_creation_date(rs.getTimestamp("post_creation_date"));
                postN.setPost_rating_positive(15);
                postN.setPost_rating_negative(8);


                post.add(postN);

            }

            stmt.close();



        } catch (SQLException e) {

            e.printStackTrace();


        }

        return post;
    }
}