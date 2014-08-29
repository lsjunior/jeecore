package br.net.woodstock.jee7core.web;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;

import br.net.woodstock.jee7core.util.Log;
import br.net.woodstock.jee7core.util.Version;

public abstract class JEE7CoreWebObject implements Serializable {

	private static final long	serialVersionUID	= Version.VERSION;

	public JEE7CoreWebObject() {
		super();
	}

	@PostConstruct
	public void defaultCDIPostConstruct() {
		Log.getLog().info("CDI PostConstruct " + this.getClass().getName() + "...");
		Conversation conversation = this.getConversation();
		if (conversation != null) {
			if (conversation.isTransient()) {
				conversation.begin();
				Log.getLog().info("Conversation begin: " + conversation.getId());
			} else {
				Log.getLog().info("Conversation exist: " + conversation.getId());
			}
		} else {
			Log.getLog().info("Conversation not found for: " + this.getClass().getCanonicalName());
		}
	}

	public Conversation getConversation() {
		return null;
	}

}
