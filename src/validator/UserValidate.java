package validator;

import businessLogic.UserManager;
import controller.UserBean;
import model.User;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.ValidatorException;

@FacesValidator("userValidate")
public class UserValidate implements javax.faces.validator.Validator {

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {

        String strValue = (String)value;
        if(strValue.indexOf('@') < 1) {
            throw new ValidatorException(new FacesMessage("Keine gültige E-Mail Adresse!"));
        }

    }
}
