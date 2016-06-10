package model;

public class Rating {

    // IV
    private int rating_id;
    private int rating_value;
    private int user_id;
    private int post_id;


    // Getter
    public int getRating_id() {
        return rating_id;
    }

    public int getRating_value() {
        return rating_value;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getPost_id() {
        return post_id;
    }


    // Setter
    public void setRating_id(int rating_id) {
        this.rating_id = rating_id;
    }

    public void setRating_value(int rating_value) {
        this.rating_value = rating_value;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

}
