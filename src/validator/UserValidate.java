package validator;

import businessLogic.UserManager;
import controller.UserBean;
import model.User;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.ValidatorException;

@FacesValidator("userValidator")

public class UserValidate implements javax.faces.validator.Validator {

    UserBean userbean = new UserBean();

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {

        if(!userbean.checkLogin()){

            throw new ValidatorException(new FacesMessage("Der angegebene User existiert nicht in der Datenbank! Bitte registrieren sie sich!"));

        };

    }
}
