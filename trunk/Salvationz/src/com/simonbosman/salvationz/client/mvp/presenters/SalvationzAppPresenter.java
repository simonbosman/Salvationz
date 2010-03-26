package com.simonbosman.salvationz.client.mvp.presenters;

import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.inject.Inject;

/**
 * Application presenter - put application initialisation here.
 *
 * @author simon
 *
 */
public class SalvationzAppPresenter {

	private final StartPanelPresenter startPanelPresenter;

	/**
	 *
	 * @param startPanelPresenter
	 *            required so we can get the place id of the first page to show
	 */
	@Inject
	public SalvationzAppPresenter(final StartPanelPresenter startPanelPresenter) {
		this.startPanelPresenter = startPanelPresenter;
	}

	/**
	 * Perform pre-app initialisation
	 */
	public void init() {

		// Put the main presenter in the root
		RootLayoutPanel.get().add(startPanelPresenter.getDisplay().asWidget());

		// Ensure that a history token is set in order for a presenter
		// to handle its onPlaceEvent and show the first panel.
		if ("".equals(History.getToken())) {
			History.newItem(startPanelPresenter.getPlace().getId(), false);
		}

	}

}
