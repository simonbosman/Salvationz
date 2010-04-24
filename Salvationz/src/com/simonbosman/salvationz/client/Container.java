package com.simonbosman.salvationz.client;

import java.util.TreeMap;

import com.allen_sauer.gwt.log.client.Log;
import com.simonbosman.salvationz.client.mvp.presenters.EastMenuPresenter;

/**
 * @author ubuntu
 *
 */
public class Container {

	private static TreeMap<String, Object> objectContainer = new TreeMap<String, Object>();

	/**
	 * @param presenterName
	 * @param o
	 */
	public static void addPresenter(final String presenterName, final Object o) {
		try {
			objectContainer.put(presenterName, o);
		} catch (final Exception ex) {
			Log.error("Could not put presenter in container.", ex);
		}
	}

	/**
	 * @param presenterName
	 * @return presenter
	 */
	public static Object getPresenter(final String presenterName) {
		try {
			return objectContainer.get(presenterName);
		} catch (final Exception ex) {
			Log.error("Could not get presenter in container", ex);
			return null;
		}
	}

	/**
	 *
	 */
	public static void doTickets() {
		final EastMenuPresenter presenter;
		try {
			presenter = (EastMenuPresenter) objectContainer
					.get("eastMenuPresenter");
			presenter.doTickets(false);
		} catch (final Exception ex) {
			Log.error("doTickets failed", ex);
		}
	}

}
