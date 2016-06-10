package controller;

import businessLogic.PostManager;
import model.Post;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean(name="postBean")
@SessionScoped
public class PostBean implements Serializable {

    // IV
    private Post post;
    private PostManager postManager;


    @PostConstruct
    void init() {
        this.postManager = new PostManager();
        this.post = new Post();
    }


    // Getter
    public Post getPost() {
        return post;
    }


    // Setter
    public void setPost(Post post) {
        this.post = post;
    }


    // IM
    public boolean writePost() {
        System.out.println("write post");
        return true;
    }

    public boolean searchPost() {
        System.out.println("search post");
        return true;
    }


}
