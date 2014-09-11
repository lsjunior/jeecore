package br.net.woodstock.jee7core.web.security;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;

import br.net.woodstock.jee7core.model.UserSupport;
import br.net.woodstock.rockframework.core.utils.Conditions;

public abstract class AbstractAuthorizingRealm extends AbstractAuthorizer implements Realm {

	public AbstractAuthorizingRealm() {
		super();
	}

	@Override
	public AuthenticationInfo getAuthenticationInfo(final AuthenticationToken authenticationToken) {
		if (authenticationToken instanceof UsernamePasswordToken) {
			UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
			String username = usernamePasswordToken.getUsername();
			char[] password = usernamePasswordToken.getPassword();

			if ((Conditions.isNotEmpty(username)) && (Conditions.isNotEmpty(password))) {
				return this.getAuthenticationInfoByUsernamePassword(username, new String(password));
			}
		} else if (authenticationToken instanceof CertificateToken) {
			CertificateToken certificateToken = (CertificateToken) authenticationToken;
			String key = certificateToken.getKey();
			String signature = certificateToken.getSignature();

			if ((Conditions.isNotEmpty(key)) && (Conditions.isNotEmpty(signature))) {
				return this.getAuthenticationInfoByCertificate(key, new String(signature));
			}
		}

		return null;
	}

	protected abstract AuthenticationInfo getAuthenticationInfoByUsernamePassword(final String username, final String password);

	protected abstract AuthenticationInfo getAuthenticationInfoByCertificate(final String key, final String signature);

	@Override
	public boolean supports(final AuthenticationToken token) {
		if ((token instanceof UsernamePasswordToken) || (token instanceof CertificateToken)) {
			return true;
		}
		return false;
	}

	@Override
	public void checkRole(final PrincipalCollection principals, final String roleIdentifier) {
		if (!this.hasRole(principals, roleIdentifier)) {
			throw new UnauthorizedException("Subject does not have role [" + roleIdentifier + "]");
		}
	}

	@Override
	public boolean hasRole(final PrincipalCollection principals, final String roleIdentifier) {
		UserPrincipal principal = (UserPrincipal) principals.getPrimaryPrincipal();
		if (principal != null) {
			UserSupport user = principal.getUser();
			String[] roles = user.getRoles();
			if (Conditions.isNotEmpty(roles)) {
				for (String role : roles) {
					if (role.equalsIgnoreCase(roleIdentifier)) {
						return true;
					}
				}
			}
		}
		return false;
	}

}