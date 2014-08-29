package br.net.woodstock.jee7core.web.security;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import br.net.woodstock.jee7core.util.Version;
import br.net.woodstock.jee7core.web.JEE7CoreAction;

@Named("sessionAction")
@ApplicationScoped
public class SessionAction extends JEE7CoreAction {

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

	public String getCurrentUserEmail() {
		return SecurityUtils.getCurrentUserEmail();
	}

	public String getCurrentUserName() {
		return SecurityUtils.getCurrentUserName();
	}

}
