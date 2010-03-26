package com.simonbosman.salvationz.client.mvp.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;
import com.simonbosman.salvationz.client.consts.Constants;
import com.simonbosman.salvationz.client.mvp.presenters.SleepingPresenter;

public class SleepingView extends Composite implements SleepingPresenter.Display{

	interface SleepingUiBinder extends UiBinder<Widget, SleepingView>{}
	private static SleepingUiBinder sleepingUiBinder = GWT.create(SleepingUiBinder.class);

	final private Widget sleepingUiWidget;
	final private FlowPanel sleepingContent;
	@UiField Image nhHotel;
	@UiField Anchor bookNow;

	public SleepingView(){

		sleepingUiWidget = sleepingUiBinder.createAndBindUi(this);
		sleepingContent = new FlowPanel();
		sleepingContent.add(sleepingUiWidget);

		nhHotel.setUrl(Constants.salvationz.nhHotel());

		bookNow.setHref("http://www.nh-hotels.nl/nh/nl/hotels/nederland/veldhoven/nh-conf.-centre-koningshof.html?action=search&stype=default&fini=12/6/2010&fout=13/6/2010&nadults1=2&nchilds1=0&services=&maxPrice=&searchLauncher=home&stext=");
		bookNow.setText("Enjoy earth like heaven at NH Koningshof and book here");
		bookNow.setTarget("_blank");

		initWidget(sleepingContent);

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
