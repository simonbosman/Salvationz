package com.simonbosman.salvationz.client.mvp.presenters;

import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;
import net.customware.gwt.presenter.client.place.PlaceRequest;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;

import com.google.inject.Inject;

public class SalvationzPresenter extends
		WidgetPresenter<SalvationzPresenter.Display> {

	@Inject
	public SalvationzPresenter(final Display display, final EventBus eventBus) {
		super(display, eventBus);
		// TODO Auto-generated constructor stub
	}

	public interface Display extends WidgetDisplay {

	}

	@Override
	public Place getPlace() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void onBind() {
		// TODO Auto-generated method stub

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
