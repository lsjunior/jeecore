package br.net.woodstock.jeecore.web.security;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import br.net.woodstock.jeecore.util.Version;
import br.net.woodstock.jeecore.web.Action;

@Named("sessionAction")
@ApplicationScoped
public class SessionAction extends Action {

	private static final long	serialVersionUID	= Version.VERSION;

	public SessionAction() {
		super();
	}

	public boolean isLoggedIn() {
		return SecurityUtils.isLoggedIn();
	}

	public boolean isUserInRole(final String role) {
		return SecurityUtils.isUserInRole(role);
	}

	public Integer getCurrentUserId() {
		return SecurityUtils.getCurrentUserId();
	}

	public String getCurrentUserLogin() {
		return SecurityUtils.getCurrentUserLogin();
	}

	public String getCurrentUserEmail() {
		return SecurityUtils.getCurrentUserEmail();
	}

	public String getCurrentUserName() {
		return SecurityUtils.getCurrentUserName();
	}

}
