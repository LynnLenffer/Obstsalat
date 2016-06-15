package businessLogic;

import model.User;

import java.util.List;

public class UserManager {

    public boolean createUser(){
        return true;
    }

    public boolean updateUser(){
        return true;
    }

    public User getUser(){
        return null;
    }

    public List<User> getUsers(){
        return null;
    }

    public boolean deleteUser(){
        return true;
    }


    public boolean checkCredentials (User user){
        return (user.getUser_email().equals("test@test.de") && user.getUser_password().equals("test"));
    }

}
