package com.simonbosman.salvationz.client.mvp.views;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.maps.client.InfoWindowContent;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.control.LargeMapControl3D;
import com.google.gwt.maps.client.geom.LatLng;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.simonbosman.salvationz.client.mvp.presenters.DjBattlePresenter;

/**
 * @author simon
 *
 */
public class DjBattleView implements DjBattlePresenter.Display {

	final private DialogBox modal;
	final private FlowPanel inner;
	final private FlowPanel footer;
	final private MapWidget map;
	final private Button closeButton;

	public DjBattleView() {

		modal = new DialogBox();
		modal.setAnimationEnabled(true);
		modal.setGlassEnabled(true);
		modal.setText("Dj contest...");
		modal.setWidth("500px");

		inner = new FlowPanel();
		footer = new FlowPanel();

		final LatLng wildeMan = LatLng.newInstance(51.439196, 5.479077);
		map = new MapWidget(wildeMan, 13);

		inner
				.add(new HTML(
						"<span id=djBattleHeader>Wildeman Thursday dance night</span><hr>"
								+ "<p class=tittle>Heb jij zin om het weekend lekker in te luiden?</p>"
								+ "<p>Kom dan donderdag avond naar de Wildeman in Eindhoven!!</p>"
								+ "<p>Hier zal een mix van DJ talent en gerenommeerde DJ's het dak eraf draaien."
								+ "Club en house zullen uit de speakers knallen.</p>"
								+ "<p>Start: 4 March<br>"
								+ "From: 23:00<br>"
								+ "Till: 02:00<br>"
								+ "" + "entrance: free</p>"));

		closeButton = new Button("Close", new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				modal.hide();

			}
		});
		map.setSize("500px", "295px");
		map.addControl(new LargeMapControl3D());
		map
				.getInfoWindow()
				.open(
						wildeMan,
						new InfoWindowContent(
								"Grandcafe de Wildeman<br>" +
								"Markt 10 Eindhoven<br>" +
								"website: <a href=http://www.cafedewildeman.nl target=_blank>Grandcafe de Wildeman</a><br>"));
		map.panBy(-50, -100);

		inner.add(map);

		footer.add(closeButton);
		footer.setStyleName("dialogFooter");

		inner.add(footer);
		modal.add(inner);

	}

	@Override
	public Widget asWidget() {
		return modal;
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
	public void hide() {
		modal.hide();

	}

	@Override
	public void show() {
		modal.show();
		modal.center();
		//final int left = modal.getAbsoluteLeft();
		//modal.setPopupPosition(left - 180, modal.getAbsoluteTop());
	}

	@Override
	public HasClickHandlers getCloseButton() {
		return closeButton;
	}

}
