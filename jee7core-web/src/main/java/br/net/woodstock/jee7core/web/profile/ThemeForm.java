package br.net.woodstock.jee7core.web.profile;

import java.util.List;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import br.net.woodstock.jee7core.util.Version;
import br.net.woodstock.jee7core.web.JEE7CoreForm;

@Named("themeForm")
@ConversationScoped
public class ThemeForm extends JEE7CoreForm {

	private static final long	serialVersionUID	= Version.VERSION;

	private ThemeType			theme;

	private List<SelectItem>	themeList;

	@Inject
	private Conversation		conversation;

	public ThemeForm() {
		super();
	}

	@Override
	public Conversation getConversation() {
		return this.conversation;
	}

	@Override
	public void reset() {
		this.setTheme(null);
		this.setThemeList(null);
	}

	public ThemeType getTheme() {
		return this.theme;
	}

	public void setTheme(final ThemeType theme) {
		this.theme = theme;
	}

	public List<SelectItem> getThemeList() {
		return this.themeList;
	}

	public void setThemeList(final List<SelectItem> themeList) {
		this.themeList = themeList;
	}

}
