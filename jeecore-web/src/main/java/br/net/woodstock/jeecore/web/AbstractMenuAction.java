package br.net.woodstock.jeecore.web;

import javax.enterprise.context.Conversation;
import javax.inject.Inject;

import br.net.woodstock.jeecore.util.Log;
import br.net.woodstock.jeecore.util.Version;

public class AbstractMenuAction extends Action {

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
				Log.getLog().debug("Ending conversation " + this.conversation.getId());
				this.conversation.end();
			}
		}
	}

	protected String changePage(final String page) {
		Log.getLog().debug("Page: " + page);
		this.endConversation();
		return page + AbstractMenuAction.FACES_REDIRECT_SUFFIX;
	}

}
