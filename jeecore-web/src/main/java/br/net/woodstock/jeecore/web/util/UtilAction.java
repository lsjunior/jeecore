package br.net.woodstock.jeecore.web.util;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import br.net.woodstock.jeecore.util.Version;
import br.net.woodstock.jeecore.web.Action;
import br.net.woodstock.rockframework.web.common.utils.HttpServletRequests;
import br.net.woodstock.rockframework.web.faces.utils.FacesContexts;

@Named("utilAction")
@ApplicationScoped
public class UtilAction extends Action {

	private static final long	serialVersionUID	= Version.VERSION;

	public UtilAction() {
		super();
	}

	public String getApplicationPath() {
		return HttpServletRequests.getApplicationUrl(FacesContexts.getRequest());
	}

	public String getContextPath() {
		return FacesContexts.getRequest().getContextPath();
	}

}
