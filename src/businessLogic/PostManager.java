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
    private UserManager userManager;


    // Constructor
    public PostManager() {
        this.factory = DAOFactory.getDAOFactory("MySQL");
        this.dao = factory.getPostDAO();
        this.userManager = new UserManager();
    }

    public boolean createPost(Post post) {

        return this.dao.addPost(post);

    }


    public List<Post> getPosts(){

        List<Post> posts = this.dao.getPosts();

        if(posts == null) {
            posts = new ArrayList<>();
        }
        else {
            for(Post post : posts) {
                post.setUser_avatar(this.userManager.getUser(post.getUser_id()).getUser_avatar());
            }
        }

        return posts;
    }


    public List<Post> getUserPosts(int user_id){

        List<Post> posts = this.dao.getUserPosts(user_id);

        if(posts == null) {
            posts = new ArrayList<>();
        }
        else {
            for(Post post : posts) {
                post.setUser_avatar(this.userManager.getUser(post.getUser_id()).getUser_avatar());
            }
        }

        return posts;
    }


    public List<Post> getPosts(String filter){

        List<Post> posts = this.dao.getPosts(filter);

        if(posts == null) {
            posts = new ArrayList<>();
        }
        else {
            for(Post post : posts) {
                post.setUser_avatar(this.userManager.getUser(post.getUser_id()).getUser_avatar());
            }
        }

        return posts;

    }



}
