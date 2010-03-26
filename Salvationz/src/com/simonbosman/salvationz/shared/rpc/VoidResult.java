package com.simonbosman.salvationz.shared.rpc;

import net.customware.gwt.dispatch.shared.Result;

/**
 * Void result type - use for when a server call does not have a result.
 *
 * @author lowec
 *
 */
public class VoidResult implements Result {

	private static final long serialVersionUID = 1L;

	/**
	 * indicates that dispatch command has no return value
	 */
	public static VoidResult VOID = new VoidResult();

	private VoidResult() {
	}

}