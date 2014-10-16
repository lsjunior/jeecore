package br.net.woodstock.jeecore.web.security;

import java.io.Serializable;
import java.security.Principal;

import br.net.woodstock.jeecore.model.UserSupport;
import br.net.woodstock.jeecore.util.Version;

public class UserPrincipal implements Principal, Serializable {

	private static final long	serialVersionUID	= Version.VERSION;

	private UserSupport			user;

	private String				authorization;

	private String				token;

	public UserPrincipal(final UserSupport user) {
		super();
		this.user = user;
	}

	public UserPrincipal(final UserSupport user, final String authorization, final String token) {
		super();
		this.user = user;
		this.authorization = authorization;
		this.token = token;
	}

	@Override
	public String getName() {
		return this.user.getName();
	}

	public UserSupport getUser() {
		return this.user;
	}

	public String getAuthorization() {
		return this.authorization;
	}

	public String getToken() {
		return this.token;
	}

	@Override
	public String toString() {
		return this.getName();
	}

}
