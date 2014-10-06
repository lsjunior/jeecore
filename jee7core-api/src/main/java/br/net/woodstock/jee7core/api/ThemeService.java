package br.net.woodstock.jee7core.api;

import br.net.woodstock.rockframework.domain.Service;

public interface ThemeService extends Service {

	void save(Integer userId, String theme);

}
