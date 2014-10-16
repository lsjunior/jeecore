package br.net.woodstock.jeecore.web;

import java.io.Serializable;

import br.net.woodstock.jeecore.util.Version;
import br.net.woodstock.rockframework.core.util.Identifiable;

public abstract class View<T extends Identifiable<K>, K extends Serializable> extends WebObject {

	private static final long	serialVersionUID	= Version.VERSION;

	private T					selected;

	public View() {
		super();
	}

	public void reset() {
		this.setSelected(null);
	}

	public T getSelected() {
		return this.selected;
	}

	public void setSelected(final T selected) {
		this.selected = selected;
	}

}
