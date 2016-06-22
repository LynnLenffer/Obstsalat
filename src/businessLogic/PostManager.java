package businessLogic;

import dataAccess.DAOFactory;
import dataAccess.PostDAO;
import dataAccess.UserDAO;
import model.Post;

import java.sql.Timestamp;
import java.util.*;

public class PostManager {

    // IV
    private DAOFactory factory;
    private PostDAO dao;


    // Constructor
    public PostManager() {
        this.factory = DAOFactory.getDAOFactory("MySQL");
        this.dao = factory.getPostDAO();
    }

    public boolean createPost(Post post) {

        return this.dao.addPost(post);

    }


    public List<Post> getPosts(){

        List<Post> posts = this.dao.getPosts();

        if(posts == null) {
            posts = new ArrayList<>();
        }

        return posts;
    }

    public List<Post> getPosts(String filter){

        List<Post> posts = this.dao.getPosts(filter);

        if(posts == null) {
            posts = new ArrayList<>();
        }

        return posts;

    }



}
