package com.simonbosman.salvationz.client.mvp.presenters;

import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;
import net.customware.gwt.presenter.client.place.PlaceRequest;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;
import pl.rmalinowski.gwt2swf.client.ui.SWFWidget;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.inject.Inject;
import com.simonbosman.salvationz.shared.events.FlashEnum;
import com.simonbosman.salvationz.shared.events.FlashEvent;
import com.simonbosman.salvationz.shared.events.FlashEventHandler;

/**
 * @author simon
 *
 */
public class HeaderPresenter extends WidgetPresenter<HeaderPresenter.Display> {

	final private TicketsPresenter ticketsPresenter;

	/**
	 * @param display
	 * @param eventBus
	 */
	@Inject
	public HeaderPresenter(final Display display, final EventBus eventBus,
			final TicketsPresenter ticketsPresenter) {
		super(display, eventBus);

		this.ticketsPresenter = ticketsPresenter;

	}

	/**
	 * @author simon
	 *
	 */
	public interface Display extends WidgetDisplay {
		public SWFWidget getFlash();
		public HasClickHandlers getClickPanel();
	}

	@Override
	public Place getPlace() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void onBind() {

		eventBus.addHandler(FlashEvent.TYPE, new FlashEventHandler() {

			@Override
			public void onFlashEvent(final FlashEvent event) {

				switch (event.getFlashOption()) {

				case HIDE:
					display.getFlash().setVisible(false);
					break;

				case SHOW:
					display.getFlash().setVisible(true);
					break;
				}
			}
		});

		display.getClickPanel().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				eventBus.fireEvent(new FlashEvent(FlashEnum.HIDE));
				ticketsPresenter.bind();
			}
		});
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
		// TODO Auto-generated method stub

	}

}
