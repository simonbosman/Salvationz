package com.simonbosman.salvationz.client.mvp.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.simonbosman.salvationz.client.mvp.presenters.SalvationzPresenter;

public class SalvationzView extends Composite implements
		SalvationzPresenter.Display {

	interface SalvationzUiBinder extends UiBinder<Widget, SalvationzView> {
	};

	private static SalvationzUiBinder salvationzUiBinder = GWT
			.create(SalvationzUiBinder.class);

	private final Widget salvationzUiWidget;

	public SalvationzView() {
		salvationzUiWidget = salvationzUiBinder.createAndBindUi(this);
		initWidget(salvationzUiWidget);
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
