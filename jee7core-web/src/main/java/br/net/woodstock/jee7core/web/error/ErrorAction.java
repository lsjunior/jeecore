package br.net.woodstock.jee7core.web.error;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.net.woodstock.jee7core.util.Version;
import br.net.woodstock.jee7core.web.JEE7CoreAction;

@Named("errorAction")
@SessionScoped
public class ErrorAction extends JEE7CoreAction {

	private static final long	serialVersionUID	= Version.VERSION;

	public ErrorAction() {
		super();
	}

	public String getMessage() {
		Exception e = this.getException();
		if (e != null) {
			return e.getMessage();
		}
		return null;
	}

	public String getStackTrace() {
		Exception e = this.getException();
		if (e != null) {
			StringWriter stringWriter = new StringWriter();
			PrintWriter printWriter = new PrintWriter(stringWriter);
			e.printStackTrace(printWriter);
			return stringWriter.getBuffer().toString();
		}
		return null;
	}

	private Exception getException() {
		// TODO
		return null;
	}

}
