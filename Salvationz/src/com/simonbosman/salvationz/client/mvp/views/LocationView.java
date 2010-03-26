package com.simonbosman.salvationz.client.mvp.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;
import com.simonbosman.salvationz.client.consts.Constants;
import com.simonbosman.salvationz.client.mvp.presenters.LocationPresenter;

public class LocationView extends Composite implements
		LocationPresenter.Display {

	@UiTemplate("LocationView.ui.xml")
	interface LocationUiBinder extends UiBinder<Widget, LocationView> {
	}

	private static LocationUiBinder locationUiBinder = GWT
			.create(LocationUiBinder.class);

	@UiTemplate("RouteView.ui.xml")
	interface RouteUiBinder extends UiBinder<Widget, LocationView> {
	}

	private static RouteUiBinder routUitBinder = GWT
			.create(RouteUiBinder.class);

	final private DecoratedTabPanel tabPanel;
	final private Widget locationUiWidget;
	final private Widget routeUiWidget;
	final private FlowPanel locationContent;
	final private FlowPanel routeContent;
	final private ScrollPanel mapContent;
	final private MapWidget map;
	@UiField
	Image e3Img;

	/**
	 *
	 */
	public LocationView() {

		tabPanel = new DecoratedTabPanel();
		tabPanel.setWidth("725px");
		tabPanel.addStyleDependentName("Location");

		routeUiWidget = routUitBinder.createAndBindUi(this);
		locationUiWidget = locationUiBinder.createAndBindUi(this);

		locationContent = new FlowPanel();
		locationContent.add(locationUiWidget);
		tabPanel.add(locationContent, "Location");

		routeContent = new FlowPanel();
		routeContent.add(routeUiWidget);
		tabPanel.add(routeContent, "Route");

		//final LatLng e3 = LatLng.newInstance(51.380433, 5.332768);

		map = null;
		mapContent = null;
		/*
		 * map = new MapWidget(e3, 8); map.setSize("703px", "480px");
		 * map.addControl(new LargeMapControl()); map .getInfoWindow() .open(
		 * e3, new InfoWindowContent(
		 * "Salvationz<br>E3 Strand Eersel<br>Enjoy earth like heaven"));
		 *
		 * mapContent = new ScrollPanel(); mapContent.add(map);
		 * tabPanel.add(mapContent, "Map");
		 */


		tabPanel.selectTab(0);

		initWidget(tabPanel);

		e3Img.setUrl(Constants.salvationz.e3Strand());
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
	public DecoratedTabPanel getLocTab() {
		return tabPanel;
	}

}
