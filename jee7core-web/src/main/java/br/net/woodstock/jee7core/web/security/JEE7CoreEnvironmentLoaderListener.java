package br.net.woodstock.jee7core.web.security;

import javax.ejb.EJB;
import javax.servlet.ServletContext;

import org.apache.shiro.mgt.AuthorizingSecurityManager;
import org.apache.shiro.web.env.EnvironmentLoaderListener;
import org.apache.shiro.web.env.WebEnvironment;

public class JEE7CoreEnvironmentLoaderListener extends EnvironmentLoaderListener {

	@EJB
	private AbstractAuthorizingRealm	realm;

	public JEE7CoreEnvironmentLoaderListener() {
		super();
	}

	@Override
	protected WebEnvironment createEnvironment(final ServletContext sc) {
		WebEnvironment environment = super.createEnvironment(sc);
		AuthorizingSecurityManager securityManager = (AuthorizingSecurityManager) environment.getSecurityManager();
		securityManager.getRealms().add(this.realm);
		return environment;
	}

}
