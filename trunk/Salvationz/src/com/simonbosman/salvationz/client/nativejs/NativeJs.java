package com.simonbosman.salvationz.client.nativejs;

/**
 * @author simon
 *
 */
public class NativeJs {

	/**
	 */
	public static native void exportDoTickets()/*-{
		$wnd.betaallink =
		$entry(@com.simonbosman.salvationz.client.Container::doTickets());
	}-*/;
}
