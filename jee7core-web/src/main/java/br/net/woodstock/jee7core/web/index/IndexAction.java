package br.net.woodstock.jee7core.web.index;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import br.net.woodstock.jee7core.util.Version;
import br.net.woodstock.jee7core.web.JEE7CoreAction;

@Named("indexAction")
@ApplicationScoped
public class IndexAction extends JEE7CoreAction {

	private static final long	serialVersionUID	= Version.VERSION;

	public IndexAction() {
		super();
	}

}
