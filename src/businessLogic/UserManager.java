package businessLogic;

import model.User;

import java.util.List;

public class UserManager {

    public boolean createUser(){
        return true;
    }

    /**
     * Überprüft die übermittelten User-Credentials
     * @param _u User
     * @return Test, ob die User-Credentials richtig oder falsch sind
     */
    public boolean checkCredentials(User _u){

        return (_u.getUser_name().equals("test") && _u.getUser_password().equals("test"));
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

}
