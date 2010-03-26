package com.simonbosman.salvationz.client.mvp.views;

import pl.rmalinowski.gwt2swf.client.ui.SWFWidget;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FocusPanel;
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
//	private final Image bannerTop;
	private final FocusPanel clickPanel;

	/**
	 * @author simon
	 *
	 */
	public HeaderView() {

		aPanel = new AbsolutePanel();

		final Image logoSalvationz = new Image();
		logoSalvationz.setUrl(Constants.salvationz.logoSalvationz());

//		bannerTop = new Image();
//		bannerTop.setUrl(Constants.salvationz.bannerHeader());

		swfWidget = new SWFWidget(Constants.salvationz.flashBanner(), "790px", "125px");

		clickPanel = new FocusPanel();
		clickPanel.setStyleName("clickPanel");
		clickPanel.add(swfWidget);

		aPanel.add(logoSalvationz);
//		aPanel.add(bannerTop);

//		class LogoAnimation extends Animation {
//
//			double x = 2200;
//			boolean virgin = true;
//
//			@Override
//			protected void onComplete() {
//				super.onComplete();
//				aPanel.setWidgetPosition(bannerTop, 190, 0);
//			}
//
//			@Override
//			protected void onUpdate(final double progress) {
//
//				if ((x < 190) || (!virgin)) {
//					virgin = false;
//					x += progress * 27;
//				} else {
//					x -= progress * 27;
//				}
//
//				aPanel.setWidgetPosition(bannerTop, (int) x, 0);
//			}
//
//		}

		initWidget(aPanel);

		/*final LogoAnimation aPanelAnimation = new LogoAnimation();
		aPanelAnimation.run(4000);

		final Timer timer = new Timer() {

			@Override
			public void run() {
				aPanel.add(clickPanel);
				aPanel.setWidgetPosition(clickPanel, 190,0);
			}
		};

		timer.schedule(6000);*/
		aPanel.add(clickPanel);
		aPanel.setWidgetPosition(clickPanel, 190, 0);
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
		return clickPanel;
	}

}
