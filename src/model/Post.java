package model;

import java.sql.Timestamp;

public class Post {

    // IV
    private int post_id;
    private int user_id;
    private String post_message;
    private Timestamp post_creation_date;



    // Getter
    public int getUser_id() {
        return user_id;
    }

    public int getPostId() {
        return post_id;
    }

    public String getPostMessage() {
        return post_message;
    }

    public Timestamp getPostDate() {return post_creation_date;}


    // Setter
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public void setPostMessage(String message) {
        this.post_message = message;
    }

    public void setPostDate(Timestamp post_date) {
        this.post_creation_date = post_date;
    }


}
