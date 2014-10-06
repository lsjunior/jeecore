package br.net.woodstock.jee7core.web.profile;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.net.woodstock.jee7core.api.ThemeService;
import br.net.woodstock.jee7core.util.Version;
import br.net.woodstock.jee7core.web.JEE7CoreAction;
import br.net.woodstock.jee7core.web.security.SecurityUtils;
import br.net.woodstock.rockframework.core.utils.Conditions;
import br.net.woodstock.rockframework.web.faces.utils.FacesContexts;

@Named("themeAction")
@ApplicationScoped
public class ThemeAction extends JEE7CoreAction {

	private static final long		serialVersionUID	= Version.VERSION;

	private static final String		THEME_ATTRIBUTE		= ThemeAction.class.getCanonicalName() + ".THEME";

	private static final ThemeType	DEFAULT_THEME		= ThemeType.ARISTO;

	@EJB
	private ThemeService			themeService;

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
			theme = SecurityUtils.getCurrentUserTheme();
			if (Conditions.isEmpty(theme)) {
				theme = ThemeAction.DEFAULT_THEME.getType();

				Integer userId = SecurityUtils.getCurrentUserId();
				if (userId != null) {
					this.themeService.save(userId, theme);
					session.setAttribute(ThemeAction.THEME_ATTRIBUTE, theme);
				}
			}
		}
		return theme;
	}

	public void save(final ThemeForm form) {
		String theme = form.getTheme().getType();
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		Integer userId = SecurityUtils.getCurrentUserId();
		this.themeService.save(userId, theme);
		session.setAttribute(ThemeAction.THEME_ATTRIBUTE, theme);
	}

	private List<SelectItem> getThemeList() {
		return FacesContexts.getItemsFromEnum(ThemeType.class);
	}

}
