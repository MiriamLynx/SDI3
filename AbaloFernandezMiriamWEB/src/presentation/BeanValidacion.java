package presentation;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 * Bean para las acciones realizadas sobre validacion.
 * 
 * @author UO217345.
 * 
 */
@ManagedBean(name = "controllerValidacion")
@SessionScoped
public class BeanValidacion {

	public void validateNumber(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
		isNumeric(arg2);
	}

	private static boolean isNumeric(Object obj) {
		if (obj instanceof Integer) {
			return true;
		}
		return false;
	}

}
