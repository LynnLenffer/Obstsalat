package model;

import java.sql.Timestamp;

public class Post {

    // IV
    private int post_id;
    private int user_id;
    private String post_message;
    private Timestamp post_creation_date;
    private String user_image;
    private int post_rating_positive;
    private int post_rating_negative;


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

    public String getUser_image() { return user_image; }

    public int getPost_rating_positive() { return post_rating_positive; }

    public int getPost_rating_negative() { return post_rating_negative; }


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

    public void setUser_image(String user_image) { this.user_image = user_image; }

    public void setPost_rating_positive(int post_rating_positive) { this.post_rating_positive = post_rating_positive; }

    public void setPost_rating_negative(int post_rating_negative) { this.post_rating_negative = post_rating_negative; }

}
