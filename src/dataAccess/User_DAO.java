package dataAccess;

import model.Post;
import model.User;

import java.util.ArrayList;
import java.util.List;

public interface User_DAO {

    public boolean addUser(User user);
    public User getUser(String name, String passwort);
    public ArrayList<User> getUsers();
    public List<User> getUsers(String name);
    public List<Post> getByIdPosts(int user_id);
    public List<Post> getPosts();
    public boolean updateUser(User user);
    public User getUserById(int id);
    public User getExistingUser(String name);


}
