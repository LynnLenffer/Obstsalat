package dataAccess;

import model.Post;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLPostDAO implements PostDAO {

    @Override
    public List<Post> getPosts() {

        List<Post> posts = new ArrayList<>();

        Connection connection = MySQLDAOFactory.createConnection();

        String statement = "SELECT * FROM Posts";

        try {

            PreparedStatement stmt = connection.prepareStatement(statement);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Post post = new Post();

                post.setPost_id( rs.getInt("post_id") );
                post.setUser_id( rs.getInt("user_id") );
                post.setPost_message( rs.getString("post_message") );
                post.setPost_creation_date( rs.getTimestamp("post_creation_date") );

                posts.add(post);

            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return posts;

    }

    @Override
    public List<Post> getPosts(String filter) {

        List<Post> posts = new ArrayList<>();

        Connection connection = MySQLDAOFactory.createConnection();

        String statement = "SELECT * FROM Posts WHERE post_message Like ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(statement);
            stmt.setString(1, "%" + filter + "%");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Post post = new Post();

                post.setPost_id( rs.getInt("post_id") );
                post.setUser_id( rs.getInt("user_id") );
                post.setPost_message( rs.getString("post_message") );
                post.setPost_creation_date( rs.getTimestamp("post_creation_date") );

                posts.add(post);

            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return posts;

    }


    @Override
    public boolean addPost(Post post) {

        boolean success = false;

        Connection connection = MySQLDAOFactory.createConnection();

        String statement = "INSERT INTO Posts (user_id, post_message) VALUES (?, ?)";

        try {

            PreparedStatement stmt = connection.prepareStatement(statement);

            stmt.setInt(1, post.getUser_id());
            stmt.setString(2, post.getPost_message());

            stmt.execute();
            stmt.close();

            success = true;

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return success;

    }

}
