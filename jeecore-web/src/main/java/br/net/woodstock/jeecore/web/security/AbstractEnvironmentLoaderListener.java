package br.net.woodstock.jeecore.web.security;

import javax.servlet.ServletContext;

import org.apache.shiro.mgt.AuthorizingSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.web.env.EnvironmentLoaderListener;
import org.apache.shiro.web.env.WebEnvironment;

public abstract class AbstractEnvironmentLoaderListener extends EnvironmentLoaderListener {

	public AbstractEnvironmentLoaderListener() {
		super();
	}

	@Override
	protected WebEnvironment createEnvironment(final ServletContext sc) {
		WebEnvironment environment = super.createEnvironment(sc);
		AuthorizingSecurityManager securityManager = (AuthorizingSecurityManager) environment.getSecurityManager();
		securityManager.getRealms().add(this.getRealm());
		return environment;
	}

	public abstract Realm getRealm();

}
