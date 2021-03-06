package com.simonbosman.salvationz.client.mvp.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.simonbosman.salvationz.client.mvp.presenters.HomePresenter;

public class HomeView extends Composite implements HomePresenter.Display {

	interface HomeUiBinder extends UiBinder<Widget, HomeView> {
	};

	private static HomeUiBinder homeUiBinder = GWT.create(HomeUiBinder.class);

	final private Widget homeUiWidget;

	public HomeView() {
		homeUiWidget = homeUiBinder.createAndBindUi(this);

		initWidget(homeUiWidget);

	}

	@Override
	public Widget asWidget() {
		return this;
	}

	@Override
	public void startProcessing() {
		// TODO Auto-generated method stub

	}

	@Override
	public void stopProcessing() {
		// TODO Auto-generated method stub

	}

}
