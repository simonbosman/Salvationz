package com.simonbosman.salvationz.shared.rpc;

import net.customware.gwt.dispatch.shared.Action;

/**
 * @author ubuntu
 *
 */
public class AddToFreeTickets implements Action<VoidResult>{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String email;

	/**
	 *
	 */
	public AddToFreeTickets(){

	}

	/**
	 * @param email
	 */
	public AddToFreeTickets(final String email){
		setEmail(email);
	}

	/**
	 * @param email
	 */
	public void setEmail(final String email) {
		this.email = email;
	}

	/**
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
}
