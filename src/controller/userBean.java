package controller;

import businessLogic.UserManager;
import model.User;
import validator.UserValidate;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

import static com.sun.tools.doclint.Entity.gt;

@ManagedBean(name="userBean")
@SessionScoped
public class UserBean implements Serializable {

    // IV
    private User user;
    private UserManager userManager;
    private UserValidate userValidate;
    private Part file;


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
    public Part getFile() {
        return file;
    }

    // Setter
    public void setUser(User user) {
        this.user = user;
    }
    public void setUserManager(UserManager userManager) { this.userManager = userManager; }
    public void setUserValidate(UserValidate userValidate) { this.userValidate = userValidate; }

    public void setFile(Part file) {
        this.file = file;
    }


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

        System.out.println("Check User Avatar");

        String filename = this.getFilename(this.file);
        System.out.println("Filename: " + filename);

        if(filename != null && !filename.equals("")) {
            boolean fileUploaded = this.uploadFile();
            if(fileUploaded) {
                this.user.setUser_avatar(filename);
            }
            else {
                System.out.println("Take default Image");
                this.user.setUser_avatar("platzhalter.png");
            }
        }
        else {
            System.out.println("Take default Image");
            this.user.setUser_avatar("platzhalter.png");
        }

        boolean registered = this.userManager.registerUser(this.user);

        if(registered) {

            facesContext.responseComplete();

            return "true";

        }
        else {

            facesContext.responseComplete();

            return "false";

        }
    }



    private boolean uploadFile() {

        boolean success = false;

        FacesContext context = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext)context.getExternalContext().getContext();
        String path = servletContext.getRealPath("");
        OutputStream outputStream = null;
        InputStream inputStream = null;

        if(this.file.getSize() > 0) {

            try {

                String fileName = this.getFilename(this.file);
                /**
                 * destination where the file will be uploaded
                 */
                File outputFile = new File("/Users/moritzkippenberg/Documents/Eigenes/HSD/module/16ss/WebEng/praktikum/praktikum07/Obstsalat/web" + File.separator + "img" + File.separator + "profile" + File.separator + fileName);
                inputStream = this.file.getInputStream();
                outputStream = new FileOutputStream(outputFile);
                byte[] buffer = new byte[1024];
                int bytesRead = 0;

                while((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }

                success = true;

            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }

        return success;

    }



    private String getFilename(Part part) {

        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }

        return "platzhalter.png";
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

    public String reset() {
        return "/pages/register.jsf";
    }


}

