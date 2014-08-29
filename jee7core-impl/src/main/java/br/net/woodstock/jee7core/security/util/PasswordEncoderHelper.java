package br.net.woodstock.jee7core.security.util;

import br.net.woodstock.rockframework.security.digest.PasswordEncoder;
import br.net.woodstock.rockframework.security.digest.util.PasswordEncoders;

public abstract class PasswordEncoderHelper {

	private static final PasswordEncoder	ENCODER	= PasswordEncoders.SHA1_BASE64;

	private PasswordEncoderHelper() {
		//
	}

	public static PasswordEncoder getEncoder() {
		return PasswordEncoderHelper.ENCODER;
	}

}
