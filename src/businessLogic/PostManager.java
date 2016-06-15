package businessLogic;

import model.Post;

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

        List<Post> test = new LinkedList<>();
        Post test1 = new Post();
        test1.setPost_message("test1");

        Post test2 = new Post();
        test2.setPost_message("test2");

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
