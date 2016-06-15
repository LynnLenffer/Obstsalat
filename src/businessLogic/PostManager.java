package businessLogic;

import model.Post;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class PostManager {


    public boolean createPost(){

        return true;
    }

    public boolean updatePost(){

        return true;
    }

    public Post getPost(){

        return null;
    }

    public List<Post> getPosts(){

        Date date = new Date();

        List<Post> test = new LinkedList<>();
        Post test1 = new Post();
        test1.setPost_message("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.");
        test1.setUser_image("profilbild_1.jpg");
        test1.setPost_creation_date(new Timestamp(date.getTime()));
        test1.setPost_rating_positive(23);
        test1.setPost_rating_negative(12);

        Post test2 = new Post();
        test2.setPost_message("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.");
        test2.setUser_image("profilbild_1.jpg");
        test2.setPost_creation_date(new Timestamp(date.getTime()));
        test2.setPost_rating_positive(15);
        test2.setPost_rating_negative(8);

        test.add(test1);
        test.add(test2);

        return test;
    }

    public boolean deletePost(){

        return true;
    }

    public boolean setRating(){

        return true;
    }

    public boolean getRating(){

        return true;
    }


}
