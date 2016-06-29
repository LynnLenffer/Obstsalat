package dataAccess;

import model.Post;
import model.User;

import java.util.ArrayList;
import java.util.List;

public interface UserDAO {

    public boolean addUser(User user);
    public boolean deleteUser(User user);
    public User getUser(String user_email);
    public User getUser(int user_id);

}
