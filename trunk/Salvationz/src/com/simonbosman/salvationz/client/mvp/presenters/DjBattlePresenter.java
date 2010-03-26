package com.simonbosman.salvationz.client.mvp.presenters;

import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;
import net.customware.gwt.presenter.client.place.PlaceRequest;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.inject.Inject;
import com.simonbosman.salvationz.shared.events.FlashEnum;
import com.simonbosman.salvationz.shared.events.FlashEvent;

public class DjBattlePresenter extends
		WidgetPresenter<DjBattlePresenter.Display> {

	@Inject
	public DjBattlePresenter(final Display display, final EventBus eventBus) {
		super(display, eventBus);
		// TODO Auto-generated constructor stub

	}

	public interface Display extends WidgetDisplay {
		public void show();
		public void hide();
		public HasClickHandlers getCloseButton();
	}

	@Override
	public Place getPlace() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void onBind() {
		display.getCloseButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				eventBus.fireEvent(new FlashEvent(FlashEnum.SHOW));

			}
		});
		display.show();
		//Fonts.setFont("#djBattleHeader", Constants.salvationz.fontBemboInfant());

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

	}

}
