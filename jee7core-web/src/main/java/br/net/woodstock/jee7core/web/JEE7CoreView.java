package br.net.woodstock.jee7core.web;

import java.io.Serializable;

import br.net.woodstock.jee7core.util.Version;
import br.net.woodstock.rockframework.core.util.Identifiable;

public abstract class JEE7CoreView<T extends Identifiable<K>, K extends Serializable> extends JEE7CoreWebObject {

	private static final long	serialVersionUID	= Version.VERSION;

	private T					selected;

	public JEE7CoreView() {
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
