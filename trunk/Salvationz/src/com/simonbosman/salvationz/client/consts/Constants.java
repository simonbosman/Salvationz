package com.simonbosman.salvationz.client.consts;


import com.google.gwt.core.client.GWT;

/**
 * Singleton for application constants.
 *
 * @author lowec
 *
 */
public class Constants {

		/**
	 *
	 */
	public static final SalvationzConstants salvationz;

	static {
		salvationz = GWT.create(SalvationzConstants.class);
	}

}
