package br.net.woodstock.jee7core.web;

import javax.enterprise.context.Conversation;
import javax.inject.Inject;

import br.net.woodstock.jee7core.util.Log;
import br.net.woodstock.jee7core.util.Version;

public class AbstractMenuAction extends JEE7CoreAction {

	private static final long	serialVersionUID		= Version.VERSION;

	private static final String	FACES_REDIRECT_SUFFIX	= "?faces-redirect=true";

	@Inject
	private Conversation		conversation;

	public AbstractMenuAction() {
		super();
	}

	private void endConversation() {
		if (this.conversation != null) {
			if (!this.conversation.isTransient()) {
				Log.getLog().info("Ending conversation " + this.conversation.getId());
				this.conversation.end();
			}
		}
	}

	protected String changePage(final String page) {
		Log.getLog().info("Page: " + page);
		this.endConversation();
		return page + AbstractMenuAction.FACES_REDIRECT_SUFFIX;
	}

}
