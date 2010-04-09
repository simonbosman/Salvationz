package com.simonbosman.salvationz.client.mvp.presenters;

import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.presenter.client.DisplayCallback;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;
import net.customware.gwt.presenter.client.place.PlaceRequest;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.TextBox;
import com.google.inject.Inject;
import com.simonbosman.salvationz.shared.events.FlashEnum;
import com.simonbosman.salvationz.shared.events.FlashEvent;
import com.simonbosman.salvationz.shared.rpc.AddToFreeTickets;
import com.simonbosman.salvationz.shared.rpc.VoidResult;

/**
 * @author ubuntu
 *
 */
public class FreeTicketsPresenter extends
		WidgetPresenter<FreeTicketsPresenter.Display> {

	final private DispatchAsync dispatcher;
	boolean firstTime;

	/**
	 * @param display
	 * @param eventBus
	 * @param dispatcher
	 */
	@Inject
	public FreeTicketsPresenter(final Display display, final EventBus eventBus,
			final DispatchAsync dispatcher) {
		super(display, eventBus);
		this.dispatcher = dispatcher;
		this.firstTime = true;
	}

	/**
	 * @author ubuntu
	 *
	 */
	public interface Display extends WidgetDisplay {
		/**
		 *
		 */
		public void show();

		/**
		 *
		 */
		public void hide();

		/**
		 * @return closeButton
		 */
		public HasClickHandlers getCloseButton();

		/**
		 * @return sendButton
		 */
		public HasClickHandlers getSendButton();

		/**
		 * @return emailadress
		 */
		public TextBox getEmailTextBox();

	}

	@Override
	public Place getPlace() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void onBind() {

		if(!firstTime){
			display.show();
			return;
		}

		display.getCloseButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				eventBus.fireEvent(new FlashEvent(FlashEnum.SHOW));

			}
		});

		display.getSendButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent arg0) {

				if (display.getEmailTextBox().getValue().equalsIgnoreCase("Emailadress")) {
					Window.alert("Pls fill in you're emailadress...");
					return;
				}

				dispatcher.execute(new AddToFreeTickets(display
						.getEmailTextBox().getValue()),
						new AddToFeeTicketsCallback(display));

			}
		});

		firstTime = false;
		display.show();

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

	class AddToFeeTicketsCallback extends DisplayCallback<VoidResult> {

		public AddToFeeTicketsCallback(final Display display) {
			super(display);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected void handleFailure(final Throwable e) {
			Window.alert("Something went wrong " + e);

		}

		@Override
		protected void handleSuccess(final VoidResult value) {
			Window.alert("Thanx...we'll let you know if you won an Ferry Corsten merchandise kit.");
			display.getEmailTextBox().setValue("Emailadress");
		}

	}

}
