package businessLogic;

import dataAccess.DAOFactory;
import dataAccess.UserDAO;
import model.User;

import java.util.List;

public class UserManager {

    // IV
    private DAOFactory factory;
    private UserDAO dao;


    // Constructor
    public UserManager() {
        this.factory = DAOFactory.getDAOFactory("MySQL");
        this.dao = factory.getUserDAO();
    }

    public boolean createUser(){
        return true;
    }

    public boolean updateUser(){
        return true;
    }


    public User getUser(int user_id){
        return this.dao.getUser(user_id);
    }


    public List<User> getUsers(){
        return null;
    }

    public boolean deleteUser(User user){

        return this.dao.deleteUser(user);

    }


    public User checkCredentials (User _user){

        User user = this.dao.getUser(_user.getUser_email());

        if(_user.getUser_password().equals(user.getUser_password())) {
            return user;
        }

        return null;

    }


    public boolean registerUser(User user) {

        return this.dao.addUser(user);

    }

}
