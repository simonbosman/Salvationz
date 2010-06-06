package com.simonbosman.salvationz.client.mvp.views;

import pl.rmalinowski.gwt2swf.client.ui.SWFWidget;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.simonbosman.salvationz.client.consts.Constants;
import com.simonbosman.salvationz.client.mvp.presenters.StartPanelPresenter;

/**
 * @author simon
 *
 */
public class StartPanelView extends Composite implements
		StartPanelPresenter.Display {

	final private ScrollPanel scrollPanel;
	final private DockLayoutPanel layoutPanel;
	final private FlowPanel northPanel;
	final private FlowPanel westPanel;
	final private FlowPanel eastPanel;
	final private HorizontalPanel southPanel;
	final private FlowPanel south2Panel;
	final private FlowPanel centerPanel;

	/**
	 * @param nView
	 *
	 */
	@Inject
	public StartPanelView(final HeaderView nView) {

		scrollPanel = new ScrollPanel();
		northPanel = new FlowPanel();
		westPanel = new FlowPanel();
		scrollPanel.add(westPanel);
		eastPanel = new FlowPanel();
		southPanel = new HorizontalPanel();
		south2Panel = new FlowPanel();
		centerPanel = new FlowPanel();

		layoutPanel = new DockLayoutPanel(Unit.PX);
		layoutPanel.setStyleName("mainPanel");

		layoutPanel.addNorth(northPanel, 130);
		layoutPanel.addSouth(south2Panel, 5);
		layoutPanel.addSouth(southPanel, 100);
		layoutPanel.addWest(scrollPanel, 785);
		layoutPanel.addEast(eastPanel, 190);
		layoutPanel.add(centerPanel);

		scrollPanel.setHeight("465px");
		layoutPanel.setWidth("980px");
		layoutPanel.addStyleName("mainPanel");
		layoutPanel.animate(2000);

		initWidget(layoutPanel);

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
	public FlowPanel setPanelEast() {
		final int lpIndex = layoutPanel.getWidgetIndex(eastPanel);
		final FlowPanel fp = (FlowPanel) layoutPanel.getWidget(lpIndex);
		fp.addStyleName("eastPanel");
		return fp;
	}

	@Override
	public FlowPanel setPanelWest() {
		final int lpIndex = layoutPanel.getWidgetIndex(scrollPanel);
		final ScrollPanel sp = (ScrollPanel) layoutPanel.getWidget(lpIndex);
		final FlowPanel fp = (FlowPanel) sp.getWidget();
		fp.addStyleName("westPanel");
		return fp;
	}

	public void setPanelCenter(){

	}

	@Override
	public FlowPanel setPanelNorth() {
		final int lpIndex = layoutPanel.getWidgetIndex(northPanel);
		final FlowPanel fp = (FlowPanel) layoutPanel.getWidget(lpIndex);
		fp.addStyleName("backgroundHeader");
		return fp;
	}

	@Override
	public void setPanelSouth() {
		final int lpIndex = layoutPanel.getWidgetIndex(southPanel);
		final HorizontalPanel vp = (HorizontalPanel) layoutPanel.getWidget(lpIndex);
		vp.setStyleName("southPanel");
		final SWFWidget countdown = new SWFWidget(Constants.salvationz.footer(),300, 100);
		countdown.addFlashVar("milsec", "1276300800000");
		countdown.addFlashVar("festival_op", "(282010,5,12,0,0,0)");
		vp.setSpacing(10);
		vp.add(countdown);
		vp.add(new HTML("<a class=southPanel href=\"/salvationz/img/Algemene_Voorwaarden_Salvationz_02.pdf\"><img src=/salvationz/img/18plus.png>&nbsp;&nbsp;algemene voorwaarden</a>"));

	}

	@Override
	public void addWidget(final Widget widget) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeWidget(final Widget widget) {
		// TODO Auto-generated method stub

	}

	@Override
	public void showWidget(final Widget widget) {
		// TODO Auto-generated method stub

	}

}
