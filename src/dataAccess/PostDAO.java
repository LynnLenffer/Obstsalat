package dataAccess;


import model.Post;

import java.util.List;

public interface PostDAO {

    public List<Post> getPosts();
    public List<Post> getPosts(String filter);
    public boolean addPost(Post post);

}
