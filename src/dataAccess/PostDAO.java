package dataAccess;


import model.Post;

import java.util.List;

public interface PostDAO {

    public List<Post> getPosts();
    public List<Post> getPosts(String filter);
    public List<Post> getUserPosts(int user_id);
    public boolean addPost(Post post);


}
