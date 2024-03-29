package br.net.woodstock.jeecore.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Log {

	private static final String	LOG_NAME	= "br.net.woodstock.jeecore";

	private static final Logger	LOGGER		= LoggerFactory.getLogger(Log.LOG_NAME);

	private Log() {
		super();
	}

	public static Logger getLog() {
		return Log.LOGGER;
	}

}
