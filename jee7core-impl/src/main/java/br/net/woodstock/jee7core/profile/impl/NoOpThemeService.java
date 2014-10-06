package br.net.woodstock.jee7core.profile.impl;

import br.net.woodstock.jee7core.api.ThemeService;
import br.net.woodstock.jee7core.util.Log;
import br.net.woodstock.jee7core.util.Version;

public class NoOpThemeService implements ThemeService {

	private static final long	serialVersionUID	= Version.VERSION;

	public NoOpThemeService() {
		super();
	}

	@Override
	public void save(final Integer userId, final String theme) {
		Log.getLog().warn("User id: " + userId + " Theme " + theme);
	}

}
