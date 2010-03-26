package com.simonbosman.salvationz.client.mvp.presenters;

import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;
import net.customware.gwt.presenter.client.place.PlaceRequest;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;

import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.inject.Inject;

public class LocationPresenter extends WidgetPresenter<LocationPresenter.Display>{

	final SleepingPresenter sleepingPresenter;

	@Inject
	public LocationPresenter(final Display display, final EventBus eventBus,
			final SleepingPresenter sleepingPresenter) {
		super(display, eventBus);
		this.sleepingPresenter = sleepingPresenter;
	}

	public interface Display extends WidgetDisplay{
		public DecoratedTabPanel getLocTab();
	}

	@Override
	public Place getPlace() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void onBind() {
		display.getLocTab().add(sleepingPresenter.getDisplay().asWidget(), "Sleeping");
		sleepingPresenter.bind();
		display.getLocTab().selectTab(0);
	}

	@Override
	protected void onPlaceRequest(final PlaceRequest request) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onUnbind() {
		// TODO Auto-generated method stub

	}

	@Override
	public void refreshDisplay() {
		// TODO Auto-generated method stub

	}

}
