package br.net.woodstock.jeecore.web.index;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import br.net.woodstock.jeecore.util.Version;
import br.net.woodstock.jeecore.web.Action;

@Named("indexAction")
@ApplicationScoped
public class IndexAction extends Action {

	private static final long	serialVersionUID	= Version.VERSION;

	public IndexAction() {
		super();
	}

}
