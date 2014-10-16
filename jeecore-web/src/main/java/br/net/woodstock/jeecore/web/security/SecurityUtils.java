package br.net.woodstock.jeecore.web.security;

import br.net.woodstock.jeecore.model.UserSupport;
import br.net.woodstock.rockframework.core.utils.Conditions;

public abstract class SecurityUtils {

	private SecurityUtils() {
		//
	}

	private static UserPrincipal getCurrentPrincipal() {
		UserPrincipal principal = (UserPrincipal) org.apache.shiro.SecurityUtils.getSubject().getPrincipal();
		return principal;
	}

	private static UserSupport getCurrentUser() {
		UserPrincipal principal = SecurityUtils.getCurrentPrincipal();
		if (principal != null) {
			return principal.getUser();
		}
		return null;
	}

	public static Integer getCurrentUserId() {
		UserSupport user = SecurityUtils.getCurrentUser();
		if (user != null) {
			return user.getId();
		}
		return null;
	}

	public static String getCurrentUserLogin() {
		UserSupport user = SecurityUtils.getCurrentUser();
		if (user != null) {
			return user.getLogin();
		}
		return null;
	}

	public static String getCurrentUserEmail() {
		UserSupport user = SecurityUtils.getCurrentUser();
		if (user != null) {
			return user.getEmail();
		}
		return null;
	}

	public static String getCurrentUserName() {
		UserSupport user = SecurityUtils.getCurrentUser();
		if (user != null) {
			return user.getName();
		}
		return null;
	}

	public static String getCurrentUserTheme() {
		UserSupport user = SecurityUtils.getCurrentUser();
		if (user != null) {
			return user.getTheme();
		}
		return null;
	}

	public static String getCurrentUserRole() {
		UserSupport user = SecurityUtils.getCurrentUser();
		if (user != null) {
			String[] roles = user.getRoles();
			if (Conditions.isNotEmpty(roles)) {
				return roles[0];
			}
		}
		return null;
	}

	public static String getCurrentUserAuthorization() {
		UserPrincipal principal = SecurityUtils.getCurrentPrincipal();
		if (principal != null) {
			return principal.getAuthorization();
		}
		return null;
	}

	public static String getCurrentUserToken() {
		UserPrincipal principal = SecurityUtils.getCurrentPrincipal();
		if (principal != null) {
			return principal.getToken();
		}
		return null;
	}

	public static boolean isLoggedIn() {
		Integer id = SecurityUtils.getCurrentUserId();
		if (id != null) {
			return true;
		}
		return false;
	}

	public static boolean isUserInRole(final String role) {
		UserSupport user = SecurityUtils.getCurrentUser();
		if (user != null) {
			String[] roles = user.getRoles();
			if (Conditions.isNotEmpty(roles)) {
				for (String r : roles) {
					if (r.equalsIgnoreCase(role)) {
						return true;
					}
				}
			}
		}
		return false;
	}

}
