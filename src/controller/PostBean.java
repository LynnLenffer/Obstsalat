package controller;

import businessLogic.PostManager;
import model.Post;
import model.User;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;


@ManagedBean(name="postBean")
@RequestScoped
public class PostBean implements Serializable {

    // IV
    private Post post;
    private List<Post> posts;
    private List<Post> userPosts;
    private PostManager postManager;
    private String filter;
    @ManagedProperty(value="#{userBean}")
    UserBean userBean;


    @PostConstruct
    void init() {
        this.postManager = new PostManager();
        this.posts = this.postManager.getPosts();
        this.userPosts = this.postManager.getUserPosts(userBean.getUser().getUser_id());
        this.post = new Post();
        this.filter = "";
    }


    // Getter
    public Post getPost() {
        return post;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public String getFilter() {
        return filter;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public List<Post> getUserPosts() {
        return userPosts;
    }

    public PostManager getPostManager() {
        return postManager;
    }



    // Setter
    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public void setUserPosts(List<Post> userPosts) {
        this.userPosts = userPosts;
    }

    public void setPostManager(PostManager postManager) {
        this.postManager = postManager;
    }



    // IM
    public String writePost() {
        System.out.println("write post");
        this.post.setUser_id(userBean.getUser().getUser_id());

        boolean success = this.postManager.createPost(this.post);

        if(success) {
            //this.getAllPosts();
            return "true";
        }
        else {
            return "false";
        }

    }

    public String getAllPosts() {
        System.out.println("get posts");

        this.posts = this.postManager.getPosts();

        if(this.posts != null) {
            return "true";
        }
        else {
            return "false";
        }

    }

    public String getAllUserPosts() {
        System.out.println("get User posts");

        this.userPosts = this.postManager.getUserPosts(userBean.getUser().getUser_id());

        if(this.posts != null) {
            return "true";
        }
        else {
            return "false";
        }

    }


    public String searchPost() {
        System.out.println("search posts");

        this.posts = this.postManager.getPosts(this.filter);

        if(this.posts != null) {
            return "true";
        }
        else {
            return "false";
        }

    }


    public void searchListener(AjaxBehaviorEvent e) {

        this.searchPost();

    }



}
