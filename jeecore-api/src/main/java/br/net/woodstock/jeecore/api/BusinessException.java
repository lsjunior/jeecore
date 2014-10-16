package br.net.woodstock.jeecore.api;

import br.net.woodstock.jeecore.util.Version;

public class BusinessException extends RuntimeException {

	private static final long	serialVersionUID	= Version.VERSION;

	public static final int		UNSPECIFIED_CODE	= -1;

	private int					code				= BusinessException.UNSPECIFIED_CODE;

	// Superclass
	public BusinessException(final String message) {
		super(message);
	}

	public BusinessException(final Throwable cause) {
		super(cause);
	}

	// Local
	public BusinessException(final int code, final String message) {
		super(message);
		this.code = code;
	}

	public BusinessException(final int code, final Throwable cause) {
		super(cause);
		this.code = code;
	}

	public int getCode() {
		return this.code;
	}

}
