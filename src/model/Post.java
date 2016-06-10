package model;

import java.sql.Timestamp;

public class Post {

    // IV
    private int post_id;
    private int user_id;
    private String post_message;
    private Timestamp post_creation_date;


    // Getter
    public int getPost_id() {
        return post_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getPost_message() {
        return post_message;
    }

    public Timestamp getPost_creation_date() {
        return post_creation_date;
    }


    // Setter
    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setPost_message(String post_message) {
        this.post_message = post_message;
    }

    public void setPost_creation_date(Timestamp post_creation_date) {
        this.post_creation_date = post_creation_date;
    }
}
