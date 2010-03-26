package com.simonbosman.salvationz.shared.rpc;

import net.customware.gwt.dispatch.shared.Action;

/**
 * @author ubuntu
 *
 */
public class AddToNewsLetter implements Action<VoidResult>{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String email;

	@SuppressWarnings("unused")
	private AddToNewsLetter(){
	}
	/**
	 * @param name
	 * @param email
	 *
	 */
	public AddToNewsLetter(final String name, final String email){
		this.name = name;
		this.email = email;
	}

	/**
	 * @return name
	 */
	public String getName(){
		return name;
	}

	/**
	 * @return email
	 */
	public String getEmail(){
		return email;
	}
}
