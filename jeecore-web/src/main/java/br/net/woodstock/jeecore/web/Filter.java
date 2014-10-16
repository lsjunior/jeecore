package br.net.woodstock.jeecore.web;

import java.io.Serializable;

import br.net.woodstock.jeecore.util.Version;
import br.net.woodstock.rockframework.core.util.Identifiable;
import br.net.woodstock.rockframework.web.faces.primefaces.PrimeFacesDataModel;

public class Filter<T extends Identifiable<K>, K extends Serializable> extends WebObject {

	public static final int				PAGE_SIZE			= 10;

	private static final long			serialVersionUID	= Version.VERSION;

	private String						filter;

	private K							selectedId;

	private PrimeFacesDataModel<T, K>	dataModel;

	public Filter() {
		super();
	}

	public void reset() {
		this.setFilter(null);
		this.setSelectedId(null);
		this.setDataModel(null);
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

	public PrimeFacesDataModel<T, K> getDataModel() {
		return this.dataModel;
	}

	public void setDataModel(final PrimeFacesDataModel<T, K> dataModel) {
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
		return Filter.PAGE_SIZE;
	}

}
