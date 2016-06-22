package controller;

import businessLogic.UserManager;
import model.User;
import validator.UserValidate;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;

@ManagedBean(name="userBean")
@SessionScoped
public class UserBean implements Serializable {

    // IV
    private User user;
    private UserManager userManager;
    private UserValidate userValidate;


    @PostConstruct
    void init() {
        this.userManager = new UserManager();
        this.user = new User();
        this.userValidate = new UserValidate();
    }


    // Getter
    public User getUser() {
        return user;
    }
    public UserValidate getUserValidate() { return userValidate; }
    public UserManager getUserManager() { return userManager; }


    // Setter
    public void setUser(User user) {
        this.user = user;
    }
    public void setUserManager(UserManager userManager) { this.userManager = userManager; }
    public void setUserValidate(UserValidate userValidate) { this.userValidate = userValidate; }


    // IM
    public String checkLogin() {
        System.out.println("check Login");

        String result = "false";

        FacesContext facesContext = FacesContext.getCurrentInstance();

        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);

        this.user = this.userManager.checkCredentials(this.user);

        if(this.user != null) {
            session.setAttribute("loggedin", "true");
            result = "true";
        }
        else {
            this.user = new User();
            session.setAttribute("loginErrorMessage", "Benutzername oder Passwort waren nicht korrekt!");
        }

        facesContext.responseComplete();

        return result;

    }

    public String logout() {


        FacesContext facesContext = FacesContext.getCurrentInstance();

        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);

        session.invalidate();

        facesContext.responseComplete();

        return "true";

    }

    public String register() {

        System.out.println("register");

        FacesContext facesContext = FacesContext.getCurrentInstance();

        boolean registered = this.userManager.registerUser(this.user);

        if(registered) {
            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
            session.setAttribute("loggedin", "true");

            facesContext.responseComplete();

            return "true";

        }
        else {

            facesContext.responseComplete();

            return "false";

        }
    }

    public String deleteUser() {

        System.out.println("delete User");

        boolean deleted = this.userManager.deleteUser(this.user);

        if(deleted) {
            logout();
            return "true";
        }
        else {
            return "false";
        }

    }


}

