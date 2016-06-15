package controller;

import businessLogic.PostManager;
import model.Post;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;


@ManagedBean(name="postBean")
@SessionScoped
public class PostBean implements Serializable {

    // IV
    private List<Post> post;
    private PostManager postManager;


    @PostConstruct
    void init() {
        this.postManager = new PostManager();
        this.post = this.postManager.getPosts();
    }


    // Getter
    public List<Post> getPosts() {
        return post;
    }

    // IM
    public String writePost() {
        System.out.println("write post");

        return "true";
    }

    public String searchPost() {
        System.out.println("search post");

        return "true";
    }


}
