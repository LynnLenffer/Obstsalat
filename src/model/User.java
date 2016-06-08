package model;

import java.sql.Timestamp;

public class User {

    // IV
    private int user_id;
    private String user_name;
    private String user_email;
    private String user_password;
    private Timestamp user_last_login;
    private String user_avatar;
    private Timestamp user_creation_date;


    // Getter
    public int getUser_id() {
        return user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public Timestamp getUser_last_login() {
        return user_last_login;
    }

    public String getUser_avatar() {
        return user_avatar;
    }

    public Timestamp getUser_creation_date() {
        return user_creation_date;
    }


    // Setter
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public void setUser_last_login(Timestamp user_last_login) {
        this.user_last_login = user_last_login;
    }

    public void setUser_avatar(String user_avatar) {
        this.user_avatar = user_avatar;
    }

    public void setUser_creation_date(Timestamp user_creation_date) {
        this.user_creation_date = user_creation_date;
    }

}
