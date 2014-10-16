package br.net.woodstock.jeecore.web;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;

import br.net.woodstock.jeecore.util.Log;
import br.net.woodstock.jeecore.util.Version;

public abstract class WebObject implements Serializable {

	private static final long	serialVersionUID	= Version.VERSION;

	public WebObject() {
		super();
	}

	@PostConstruct
	public void defaultCDIPostConstruct() {
		Log.getLog().debug("CDI PostConstruct " + this.getClass().getName() + "...");
		Conversation conversation = this.getConversation();
		if (conversation != null) {
			if (conversation.isTransient()) {
				conversation.begin();
				Log.getLog().debug("Conversation begin: " + conversation.getId());
			} else {
				Log.getLog().debug("Conversation exist: " + conversation.getId());
			}
		} else {
			Log.getLog().debug("Conversation not found for: " + this.getClass().getCanonicalName());
		}
	}

	public Conversation getConversation() {
		return null;
	}

}
