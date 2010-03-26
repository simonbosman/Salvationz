package com.simonbosman.salvationz.client.mvp.presenters;

import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;
import net.customware.gwt.presenter.client.place.PlaceRequest;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.HasMouseOverHandlers;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.simonbosman.salvationz.shared.events.FlashEnum;
import com.simonbosman.salvationz.shared.events.FlashEvent;
import com.simonbosman.salvationz.shared.events.WestMenuEnum;
import com.simonbosman.salvationz.shared.events.WestMenuEvent;

public class WestMenuPresenter extends
		WidgetPresenter<WestMenuPresenter.Display> {

	final private TicketsPresenter ticketsPresenter;

	@Inject
	public WestMenuPresenter(final Display display, final EventBus eventBus,
			final TicketsPresenter ticketsPresenter) {
		super(display, eventBus);
		this.ticketsPresenter = ticketsPresenter;
	}

	public interface Display extends WidgetDisplay {

		public HasClickHandlers getHomeClick();

		public HasMouseOverHandlers getHomeMouseOver();

		public HasClickHandlers getLocatieClick();

		public HasMouseOverHandlers getLocatieMouseOver();

		public HasClickHandlers getDjClick();

		public HasMouseOverHandlers getDjMouseOver();

		public HasClickHandlers getContactClick();

		public HasMouseOverHandlers getContactMouseOver();

		public HasClickHandlers getSalvationzClick();

		public HasMouseOverHandlers getSalvationzMouseOver();

		public HasClickHandlers getTicketsClick();

		public HasClickHandlers getPartnersClick();

	}

	@Override
	public Place getPlace() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void onBind() {

		display.getSalvationzClick().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				eventBus.fireEvent(new WestMenuEvent(WestMenuEnum.SALVATIONZ));
			}
		});

		/*display.getSalvationzMouseOver().addMouseOverHandler(
				new MouseOverHandler() {

					@Override
					public void onMouseOver(final MouseOverEvent event) {
						eventBus.fireEvent(new WestMenuEvent(
								WestMenuEnum.SALVATIONZ));
					}
				});*/

		display.getContactClick().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				eventBus.fireEvent(new WestMenuEvent(WestMenuEnum.CONTACT));

			}
		});

/*		display.getContactMouseOver().addMouseOverHandler(
				new MouseOverHandler() {

					@Override
					public void onMouseOver(final MouseOverEvent event) {
						eventBus.fireEvent(new WestMenuEvent(
								WestMenuEnum.CONTACT));
					}
				});

*/		display.getDjClick().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				eventBus.fireEvent(new WestMenuEvent(WestMenuEnum.DJ));

			}
		});

/*		display.getDjMouseOver().addMouseOverHandler(new MouseOverHandler() {

			@Override
			public void onMouseOver(final MouseOverEvent event) {
				eventBus.fireEvent(new WestMenuEvent(WestMenuEnum.DJ));
			}
		});
*/
		display.getHomeClick().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				eventBus.fireEvent(new WestMenuEvent(WestMenuEnum.HOME));

			}
		});

/*		display.getHomeMouseOver().addMouseOverHandler(new MouseOverHandler() {

			@Override
			public void onMouseOver(final MouseOverEvent event) {
				eventBus.fireEvent(new WestMenuEvent(WestMenuEnum.HOME));
			}
		});
*/
		display.getLocatieClick().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				eventBus.fireEvent(new WestMenuEvent(WestMenuEnum.LOCATION));

			}
		});

		/*display.getLocatieMouseOver().addMouseOverHandler(
				new MouseOverHandler() {

					@Override
					public void onMouseOver(final MouseOverEvent event) {
						eventBus.fireEvent(new WestMenuEvent(
								WestMenuEnum.LOCATION));
					}
				});
*/
		display.getTicketsClick().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				// eventBus.fireEvent(new WestMenuEvent(WestMenuEnum.TICKETS));
				eventBus.fireEvent(new FlashEvent(FlashEnum.HIDE));
				ticketsPresenter.bind();
			}
		});

		display.getPartnersClick().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				eventBus.fireEvent(new WestMenuEvent(WestMenuEnum.PARTNERS));

			}
		});

		/*
		 * display.getMoviesClick().addClickHandler(new ClickHandler() {
		 *
		 * @Override public void onClick(final ClickEvent event) {
		 * eventBus.fireEvent(new WestMenuEvent(WestMenuEnum.MOVIES));
		 *
		 * } }); display.getPhotosClick().addClickHandler(new ClickHandler() {
		 *
		 * @Override public void onClick(final ClickEvent event) {
		 * eventBus.fireEvent(new WestMenuEvent(WestMenuEnum.PHOTOS));
		 *
		 * } });
		 */
	}

	@Override
	protected void onPlaceRequest(final PlaceRequest request) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onUnbind() {
	}

	@Override
	public void refreshDisplay() {
		// TODO Auto-generated method stub

	}

	class DebugClickHandler implements ClickHandler {

		@Override
		public void onClick(final ClickEvent event) {
			Window.alert(event.toDebugString() + event.getSource().toString());
		}

	}
}
