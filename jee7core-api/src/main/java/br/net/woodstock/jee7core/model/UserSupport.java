package br.net.woodstock.jee7core.model;

public interface UserSupport {

	Integer getId();

	String getLogin();

	String getName();

	String getEmail();

	String getTheme();

	String[] getRoles();

}
