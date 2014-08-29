package br.net.woodstock.jee7core.web;

import java.io.Serializable;

import br.net.woodstock.jee7core.util.Version;
import br.net.woodstock.rockframework.core.util.Identifiable;
import br.net.woodstock.rockframework.web.faces.primefaces.PrimeFacesDataModel;

public class JEE7CoreFilter<T extends Identifiable<K>, K extends Serializable> extends JEE7CoreWebObject {

	public static final int			PAGE_SIZE			= 10;

	private static final long		serialVersionUID	= Version.VERSION;

	private String					filter;

	private K						selectedId;

	private PrimeFacesDataModel<T>	dataModel;

	public JEE7CoreFilter() {
		super();
	}

	public String getFilter() {
		return this.filter;
	}

	public void setFilter(final String filter) {
		this.filter = filter;
	}

	public K getSelectedId() {
		return this.selectedId;
	}

	public void setSelectedId(final K selectedId) {
		this.selectedId = selectedId;
	}

	public PrimeFacesDataModel<T> getDataModel() {
		return this.dataModel;
	}

	public void setDataModel(final PrimeFacesDataModel<T> dataModel) {
		this.dataModel = dataModel;
	}

	// Aux
	public int getFirstRow() {
		if ((this.dataModel == null) || (this.dataModel.getRowIndex() < 0)) {
			return 0;
		}
		int rowIndex = this.dataModel.getRowIndex();
		int selectedIndex = (rowIndex / this.getPageSize()) * this.getPageSize();
		return selectedIndex;
	}

	public int getPageSize() {
		return JEE7CoreFilter.PAGE_SIZE;
	}

}
