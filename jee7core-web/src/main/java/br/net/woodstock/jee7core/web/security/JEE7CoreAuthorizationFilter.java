package br.net.woodstock.jee7core.web.security;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;

public class JEE7CoreAuthorizationFilter extends RolesAuthorizationFilter {

	public JEE7CoreAuthorizationFilter() {
		super();
	}

	@Override
	public boolean isAccessAllowed(final ServletRequest request, final ServletResponse response, final Object mappedValue) throws IOException {
		// FacesContext context = FacesContexts.getFacesContext();
		// UIViewRoot view = context.getViewRoot();
		// String viewId = view.getViewId();
		return super.isAccessAllowed(request, response, mappedValue);
	}

}
