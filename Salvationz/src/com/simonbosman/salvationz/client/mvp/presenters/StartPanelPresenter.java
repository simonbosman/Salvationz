package com.simonbosman.salvationz.client.mvp.presenters;

import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;
import net.customware.gwt.presenter.client.place.PlaceRequest;
import net.customware.gwt.presenter.client.widget.WidgetContainerDisplay;
import net.customware.gwt.presenter.client.widget.WidgetContainerPresenter;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.inject.Inject;

/**
 * @author simon
 *
 */
public class StartPanelPresenter extends
		WidgetContainerPresenter<StartPanelPresenter.Display> {

	/**
	 * History token id for the page represented by this presenter
	 */
	public static final Place PLACE = new Place("Salvationz");

	private final DispatchAsync dispatcher;
	private final HeaderPresenter headerPresenter;
	private final MainContentPresenter mainContentPresenter;
	private final EastMenuPresenter eastMenuPresenter;

	/**
	 * @param display
	 * @param eventBus
	 * @param dispatcher
	 */
	@Inject
	public StartPanelPresenter(final Display display, final EventBus eventBus,
			final DispatchAsync dispatcher,
			final HeaderPresenter headerPresenter,
			final MainContentPresenter mainContentPresenter,
			final EastMenuPresenter eastMenuPresenter) {
		super(display, eventBus);
		this.dispatcher = dispatcher;
		this.headerPresenter = headerPresenter;
		this.mainContentPresenter = mainContentPresenter;
		this.eastMenuPresenter = eastMenuPresenter;
		Log.debug("StartPanelPresenter(): Start Panel Presenter");
		bind();
	}

	/**
 *
 */
	protected void loadPanelContent() {

		final Timer northTimer = new Timer() {

			@Override
			public void run() {

				display.setPanelNorth().add(
						headerPresenter.getDisplay().asWidget());
				headerPresenter.bind();
			}
		};

		final Timer eastTimer = new Timer() {

			@Override
			public void run() {
				display.setPanelEast().add(
						eastMenuPresenter.getDisplay().asWidget());
				eastMenuPresenter.bind();
			}
		};

		final Timer westTimer = new Timer() {

			@Override
			public void run() {
				display.setPanelWest().add(
						mainContentPresenter.getDisplay().asWidget());
				mainContentPresenter.bind();
			}
		};

		eastTimer.schedule(10);
		westTimer.schedule(10);
		northTimer.schedule(3000);

		display.setPanelSouth();
	}

	/**
	 * @author simon
	 *
	 */
	public interface Display extends WidgetContainerDisplay {

		public FlowPanel setPanelNorth();

		public FlowPanel setPanelWest();

		public void setPanelSouth();

		public FlowPanel setPanelEast();

		public void setPanelCenter();

	}

	@Override
	public Place getPlace() {
		return PLACE;
	}

	@Override
	public void refreshDisplay() {
		Log.debug("refreshDisplay(): Start Panel Page");
	}

	@Override
	public void revealDisplay() {
		loadPanelContent();
		super.revealDisplay();
		refreshDisplay();
	}

	@Override
	protected void onBind() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onPlaceRequest(final PlaceRequest request) {

		refreshDisplay();

	}

	@Override
	protected void onUnbind() {
		// TODO Auto-generated method stub

	}

}
