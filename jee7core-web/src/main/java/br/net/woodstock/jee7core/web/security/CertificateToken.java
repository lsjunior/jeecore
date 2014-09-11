package br.net.woodstock.jee7core.web.security;

import org.apache.shiro.authc.AuthenticationToken;

import br.net.woodstock.jee7core.util.Version;

public class CertificateToken implements AuthenticationToken {

	private static final long	serialVersionUID	= Version.VERSION;

	private String				key;

	private String				signature;

	public CertificateToken() {
		super();
	}

	public CertificateToken(final String key, final String signature) {
		super();
		this.key = key;
		this.signature = signature;
	}

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getSignature() {
		return this.signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	// Token
	@Override
	public Object getCredentials() {
		return this.getSignature();
	}

	@Override
	public Object getPrincipal() {
		return this.getKey();
	}

}
