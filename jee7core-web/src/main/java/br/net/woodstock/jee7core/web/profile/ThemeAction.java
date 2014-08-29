package br.net.woodstock.jee7core.web.profile;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.net.woodstock.jee7core.util.Version;
import br.net.woodstock.jee7core.web.JEE7CoreAction;
import br.net.woodstock.rockframework.core.utils.Conditions;
import br.net.woodstock.rockframework.web.faces.utils.FacesContexts;

@Named("themeAction")
@ApplicationScoped
public class ThemeAction extends JEE7CoreAction {

	private static final long		serialVersionUID	= Version.VERSION;

	private static final String		THEME_ATTRIBUTE		= ThemeAction.class.getCanonicalName() + ".THEME";

	private static final ThemeType	DEFAULT_THEME		= ThemeType.ARISTO;

	public ThemeAction() {
		super();
	}

	public void onPreRenderView(final ThemeForm form) {
		if (!FacesContext.getCurrentInstance().isPostback()) {
			form.setTheme(ThemeType.typeOf(this.getCurrentTheme()));
			form.setThemeList(this.getThemeList());
		}
	}

	public String getCurrentTheme() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		String theme = (String) session.getAttribute(ThemeAction.THEME_ATTRIBUTE);
		if (Conditions.isEmpty(theme)) {
			Cookie[] cookies = request.getCookies();
			if (Conditions.isNotEmpty(cookies)) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals(ThemeAction.THEME_ATTRIBUTE)) {
						theme = cookie.getValue();
						break;
					}
				}
			}
			if (Conditions.isEmpty(theme)) {
				theme = ThemeAction.DEFAULT_THEME.getType();
			}
			session.setAttribute(ThemeAction.THEME_ATTRIBUTE, theme);
		}
		return theme;
	}

	public void save(final ThemeForm form) {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
		HttpSession session = request.getSession();
		Cookie cookie = new Cookie(ThemeAction.THEME_ATTRIBUTE, form.getTheme().getType());
		response.addCookie(cookie);
		cookie.setMaxAge(-1);
		session.setAttribute(ThemeAction.THEME_ATTRIBUTE, form.getTheme().getType());
	}

	private List<SelectItem> getThemeList() {
		return FacesContexts.getItemsFromEnum(ThemeType.class);
	}

}
