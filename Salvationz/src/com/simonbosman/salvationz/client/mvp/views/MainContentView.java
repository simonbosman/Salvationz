package com.simonbosman.salvationz.client.mvp.views;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.simonbosman.salvationz.client.mvp.presenters.MainContentPresenter;

public class MainContentView extends Composite implements MainContentPresenter.Display{

	final private FlowPanel mainContainer;
	final private HorizontalPanel aligner;
	final private FlowPanel westMenu;
	final private FlowPanel headerContent;
	final private FlowPanel mainContent;

	public MainContentView(){

		mainContainer = new FlowPanel();
		aligner = new HorizontalPanel();

		westMenu = new FlowPanel();
		westMenu.addStyleName("westMenu");
		aligner.add(westMenu);

		headerContent = new FlowPanel();
		headerContent.addStyleName("headerContent");
		aligner.add(headerContent);

		mainContent = new FlowPanel();
		mainContent.addStyleName("mainContent");

		mainContainer.add(aligner);
		mainContainer.add(mainContent);

		initWidget(mainContainer);

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
	public FlowPanel getHeaderContent() {
		return headerContent;
	}

	@Override
	public FlowPanel getMainContent() {
		return mainContent;
	}

	@Override
	public FlowPanel getWestMenu() {
		return westMenu;
	}

	@Override
	public FlowPanel getMainConainter() {
		return mainContainer;
	}

}
