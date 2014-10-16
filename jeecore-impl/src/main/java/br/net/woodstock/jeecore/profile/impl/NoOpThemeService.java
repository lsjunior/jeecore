package br.net.woodstock.jeecore.profile.impl;

import br.net.woodstock.jeecore.api.ThemeService;
import br.net.woodstock.jeecore.util.Log;
import br.net.woodstock.jeecore.util.Version;

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
