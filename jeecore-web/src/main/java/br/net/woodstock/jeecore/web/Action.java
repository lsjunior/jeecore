package br.net.woodstock.jeecore.web;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;

import br.net.woodstock.jeecore.util.Log;
import br.net.woodstock.jeecore.util.Version;
import br.net.woodstock.rockframework.web.faces.utils.FacesContexts;

public abstract class Action extends WebObject {

	public static final String	KEY_ATTRIBUTE		= "key";

	public static final String	FILTER_ATTRIBUTE	= "filter";

	public static final String	FORM_ATTRIBUTE		= "form";

	public static final String	VIEW_ATTRIBUTE		= "view";

	private static final long	serialVersionUID	= Version.VERSION;

	public Action() {
		super();
	}

	public void addMessage(final String message) {
		FacesContexts.addMessage(message);
	}

	public void addError(final String message) {
		FacesContexts.addMessage(FacesMessage.SEVERITY_ERROR, message, message);
	}

	public void addError(final Throwable t) {
		Log.getLog().error(t.getMessage(), t);

		StringWriter writer = new StringWriter();
		t.printStackTrace(new PrintWriter(writer));

		List<Throwable> list = new ArrayList<>();
		list.add(t);

		String rootCause = this.getRootCause(t, list);

		FacesContexts.addMessage(FacesMessage.SEVERITY_ERROR, rootCause, writer.toString());
	}

	private String getRootCause(final Throwable t, final List<Throwable> list) {
		Throwable cause = t.getCause();
		if ((cause != null) && (!list.contains(cause))) {
			list.add(cause);
			return this.getRootCause(cause, list);
		}

		if (t instanceof SQLException) {
			SQLException sqle = (SQLException) t;
			Exception next = sqle.getNextException();
			if (next != null) {
				return this.getRootCause(sqle.getNextException(), list);
			}
		}

		return t.getMessage();
	}

}
