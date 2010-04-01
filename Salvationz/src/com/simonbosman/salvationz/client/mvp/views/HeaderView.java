package com.simonbosman.salvationz.client.mvp.views;

import pl.rmalinowski.gwt2swf.client.ui.SWFWidget;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;
import com.simonbosman.salvationz.client.consts.Constants;
import com.simonbosman.salvationz.client.mvp.presenters.HeaderPresenter;

/**
 * @author simon
 *
 */
public class HeaderView extends Composite implements HeaderPresenter.Display {

	// private final HorizontalPanel hPanel;
	private final AbsolutePanel aPanel;
	private final SWFWidget swfWidget;

	/**
	 * @author simon
	 *
	 */
	public HeaderView() {

		aPanel = new AbsolutePanel();

		final Image logoSalvationz = new Image();
		logoSalvationz.setUrl(Constants.salvationz.logoSalvationz());

		final Image bannerTop = new Image();
		bannerTop.setUrl(Constants.salvationz.bannerHeader());

		swfWidget = new SWFWidget(Constants.salvationz.flashBanner(), 788, 122);

		aPanel.add(swfWidget);
		aPanel.add(bannerTop);

		aPanel.add(logoSalvationz);

		initWidget(aPanel);

		aPanel.setWidgetPosition(swfWidget, 190, -3);
		aPanel.setWidgetPosition(bannerTop, 190, 0);
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

	@Override
	public SWFWidget getFlash() {
		return swfWidget;
	}

	@Override
	public HasClickHandlers getClickPanel() {
		return null;
	}

}
