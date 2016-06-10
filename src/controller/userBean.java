package controller;

import businessLogic.UserManager;
import model.User;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;

@ManagedBean(name="userBean")
@SessionScoped
public class UserBean implements Serializable {

    // IV
    private User user;
    private UserManager userManager;


    @PostConstruct
    void init() {
        this.userManager = new UserManager();
        this.user = new User();
    }


    // Getter
    public User getUser() {
        return user;
    }


    // Setter
    public void setUser(User user) {
        this.user = user;
    }


    // IM
    public boolean checkLogin() {
        System.out.println("Test");
        return this.userManager.checkCredentials(this.user);
    }

    public boolean logout() {
        System.out.println("logout");
        return true;
    }

    public boolean register() {
        System.out.println("register");
        return true;
    }

    public boolean deleteUser() {
        System.out.println("delete User");
        return true;
    }



}
