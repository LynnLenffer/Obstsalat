package controller;

import businessLogic.CommentManager;
import model.Comments;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean(name="commentBean")
@SessionScoped
public class CommentBean implements Serializable {

    // IV
    private Comments comments;
    private CommentManager commentManager;


    @PostConstruct
    void init() {
        this.commentManager = new CommentManager();
        this.comments = new Comments();
    }


    // Getter
    public Comments getComments() {
        return comments;
    }


    // Setter
    public void setPost(Comments comments) {
        this.comments = comments;
    }


    // IM


}
