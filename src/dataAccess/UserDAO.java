package dataAccess;

import model.Post;
import model.User;

import java.util.ArrayList;
import java.util.List;

public interface UserDAO {

    public boolean addUser(User user);
    public User getUser(String name);
    public boolean deleteUser(User user);

}
