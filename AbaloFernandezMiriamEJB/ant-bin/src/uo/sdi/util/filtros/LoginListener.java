package uo.sdi.util.filtros;

import java.util.Map;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class LoginListener implements PhaseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginListener() {

	}

	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

	public void beforePhase(PhaseEvent event) {
	}

	public void afterPhase(PhaseEvent event) {
		FacesContext fc = event.getFacesContext();
		String view = fc.getViewRoot().getViewId();
		if (view.contains("index") || view.contains("listado")
				|| view.contains("registro") || view.contains("error")) {
			return;
		}
		if (!IsValidAuth()) {
			NavigationHandler nh = fc.getApplication().getNavigationHandler();
			nh.handleNavigation(fc, null, "/denegado.xhtml");
			return;
		}
		return;
	}

	private boolean IsValidAuth() {
		Map<String, Object> session = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		return (session.get("USUARIO_LOGUEADO") != null);
	}
}
