package controller;

import businessLogic.RatingManager;
import model.Rating;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean(name="ratingBean")
@SessionScoped
public class RatingBean implements Serializable {

    // IV
    private Rating rating;
    private RatingManager ratingManager;


    @PostConstruct
    void init() {
        this.ratingManager = new RatingManager();
        this.rating = new Rating();
    }


    // Getter
    public Rating getRating() {
        return rating;
    }


    // Setter
    public void setRating(Rating rating) {
        this.rating = rating;
    }


    // IM

}
