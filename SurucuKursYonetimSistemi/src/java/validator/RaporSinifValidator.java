package validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("raporsinifValidator")
public class RaporSinifValidator implements Validator{

    @Override
    public void validate(FacesContext fc, UIComponent uıc, Object o) throws ValidatorException {
        String str = o.toString();
		if((str.length()<1)){
			
			FacesMessage msg = 
				new FacesMessage("Rapor Sınıf validation failed.", 
						"Invalid Length string format.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);

		}

    }
    }
    