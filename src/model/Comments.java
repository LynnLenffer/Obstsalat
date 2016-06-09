package model;

import java.sql.Timestamp;

public class Comments {

    // IV
    private int comment_id;
    private int post_id;
    private int user_id;
    private String comment_message;
    private Timestamp comment_creation_date;



    // Getter
    public int getComment_id() {
        return comment_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getPostId() {
        return post_id;
    }

    public String getCommentMessage() {
        return comment_message;
    }

    public Timestamp getCommentDate() {return comment_creation_date;}


    // Setter
    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public void setCommentMessage(String message) {
        this.comment_message = message;
    }

    public void setCommentDate(Timestamp post_date) {
        this.comment_creation_date = post_date;
    }


}
