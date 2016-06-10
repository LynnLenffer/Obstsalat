package businessLogic;

import model.User;

public class UserManager {


    /**
     * Überprüft die übermittelten User-Credentials
     * @param _u User
     * @return Test, ob die User-Credentials richtig oder falsch sind
     */
    public boolean checkCredentials(User _u){

        return (_u.getUser_name().equals("test") && _u.getUser_password().equals("test"));
    }



}
