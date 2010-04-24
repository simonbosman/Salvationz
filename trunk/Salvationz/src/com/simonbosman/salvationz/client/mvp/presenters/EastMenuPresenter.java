package com.simonbosman.salvationz.client.mvp.presenters;

import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.presenter.client.DisplayCallback;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;
import net.customware.gwt.presenter.client.place.PlaceRequest;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.DecoratedPopupPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.simonbosman.salvationz.client.Container;
import com.simonbosman.salvationz.client.consts.Constants;
import com.simonbosman.salvationz.client.nativejs.NativeJs;
import com.simonbosman.salvationz.shared.events.FlashEnum;
import com.simonbosman.salvationz.shared.events.FlashEvent;
import com.simonbosman.salvationz.shared.rpc.AddToNewsLetter;
import com.simonbosman.salvationz.shared.rpc.VoidResult;

public class EastMenuPresenter extends
		WidgetPresenter<EastMenuPresenter.Display> {

	final private FreeTicketsPresenter freeTicketsPresenter;
	final private TicketsPresenter ticketsPresenter;
	final private DispatchAsync dispatcher;
	final private String windowFeatures;

	@Inject
	public EastMenuPresenter(final Display display, final EventBus eventBus,
			final DispatchAsync dispatcher,
			final FreeTicketsPresenter freeTicketsPresenter,
			final TicketsPresenter ticketsPresenter) {
		super(display, eventBus);
		this.dispatcher = dispatcher;
		this.freeTicketsPresenter = freeTicketsPresenter;
		this.ticketsPresenter = ticketsPresenter;
		windowFeatures = "menubar=yes, location=yes, resizable=yes, scrollbars=yes, status=yes";
	}

	public interface Display extends WidgetDisplay {

		public HasClickHandlers getTicketsClick();

		public HasClickHandlers getDjBattleClick();

		public HasClickHandlers getTwitterClick();

		public HasClickHandlers getHyvesClick();

		public HasClickHandlers getFacebookClick();

		public HasClickHandlers getPartyflockClick();

		public HasClickHandlers getYoutubeClick();

		public HasClickHandlers getNieuwsBriefClick();

		public TextBox getNameTextBox();

		public TextBox getEmailTextBox();

		public DecoratedPopupPanel getPopup();

		public HTML getPopupContent();

	}

	public void doTickets(final Boolean discount) {
		// eventBus.fireEvent(new WestMenuEvent(WestMenuEnum.TICKETS));
		eventBus.fireEvent(new FlashEvent(FlashEnum.HIDE));
		ticketsPresenter.bind();
		if (discount) {
			ticketsPresenter.setDiscount();
		}
	}

	private void doDjBattle() {
		eventBus.fireEvent(new FlashEvent(FlashEnum.HIDE));
		freeTicketsPresenter.bind();
	}

	private void doTwitter() {
		Window
				.open(Constants.salvationz.twitterUrl(), "_blank",
						windowFeatures);
	}

	private void doHyves() {
		Window.open(Constants.salvationz.hyvesUrl(), "_blank", windowFeatures);
	}

	private void doFacebook() {
		Window.open(Constants.salvationz.facebookUrl(), "_blank",
				windowFeatures);
	}

	private void doPartyflock() {
		Window.open(Constants.salvationz.partyflockUrl(), "_blank",
				windowFeatures);
	}

	private void doYoutube() {
		Window
				.open(Constants.salvationz.youtubeUrl(), "_blank",
						windowFeatures);
	}

	private void doNieuwsBrief() {
		dispatcher.execute(new AddToNewsLetter(display.getNameTextBox()
				.getValue(), display.getEmailTextBox().getValue()),
				new AddToNewsLetterCallback(display));
	}

	@Override
	public void revealDisplay() {
		revealDisplay();
	}

	@Override
	public Place getPlace() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void onBind() {

		registerHandler(display.getDjBattleClick().addClickHandler(
				new ClickHandler() {

					@Override
					public void onClick(final ClickEvent event) {
						doDjBattle();

					}
				}));

		registerHandler(display.getTicketsClick().addClickHandler(
				new ClickHandler() {

					@Override
					public void onClick(final ClickEvent event) {
						doTickets(true);

					}
				}));

		registerHandler(display.getTwitterClick().addClickHandler(
				new ClickHandler() {

					@Override
					public void onClick(final ClickEvent event) {
						doTwitter();
					}
				}));

		registerHandler(display.getHyvesClick().addClickHandler(
				new ClickHandler() {

					@Override
					public void onClick(final ClickEvent event) {
						doHyves();
					}
				}));
		registerHandler(display.getFacebookClick().addClickHandler(
				new ClickHandler() {

					@Override
					public void onClick(final ClickEvent event) {
						doFacebook();
					}
				}));
		registerHandler(display.getPartyflockClick().addClickHandler(
				new ClickHandler() {

					@Override
					public void onClick(final ClickEvent event) {
						doPartyflock();
					}
				}));
		registerHandler(display.getYoutubeClick().addClickHandler(
				new ClickHandler() {

					@Override
					public void onClick(final ClickEvent event) {
						doYoutube();
					}
				}));
		registerHandler(display.getNieuwsBriefClick().addClickHandler(
				new ClickHandler() {

					@Override
					public void onClick(final ClickEvent event) {
						doNieuwsBrief();
					}
				}));

		Container.addPresenter("eastMenuPresenter", this);
		NativeJs.exportDoTickets();
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

	class AddToNewsLetterCallback extends DisplayCallback<VoidResult> {

		public AddToNewsLetterCallback(final Display display) {
			super(display);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected void handleFailure(final Throwable e) {
			Log.error("", e);

			final DecoratedPopupPanel popup = display.getPopup();
			final Widget nieuwsbriefBox = (Widget) display
					.getNieuwsBriefClick();

			final int left = nieuwsbriefBox.getAbsoluteLeft() + 2;
			final int top = nieuwsbriefBox.getAbsoluteTop() + 85;
			popup.setPopupPosition(left, top);
			popup.show();

			final Timer popupTimer = new Timer() {

				@Override
				public void run() {
					popup.hide();
					display.getNameTextBox().setValue("Name");
					display.getEmailTextBox().setValue("Emailadress");
				}
			};

			popupTimer.schedule(5000);
		}

		@Override
		protected void handleSuccess(final VoidResult value) {

			Log.debug("OK sending email and name " + value);

			display
					.getPopupContent()
					.setHTML(
							"<p class=\"sub\">Thanx...</p><p class=\"tittle\">"
									+ display.getNameTextBox().getValue()
									+ "</p><p class=\"sub\">We'll keep you updated at<p><p class=\"tittle\">"
									+ display.getEmailTextBox().getValue()
									+ "</p>");

			final DecoratedPopupPanel popup = display.getPopup();
			final Widget nieuwsbriefBox = (Widget) display
					.getNieuwsBriefClick();

			final int left = nieuwsbriefBox.getAbsoluteLeft() + 2;
			final int top = nieuwsbriefBox.getAbsoluteTop() + 85;

			popup.setPopupPosition(left, top);

			if (!display.getEmailTextBox().getValue().equalsIgnoreCase(
					"Emailadress")) {
				popup.show();
			}

			final Timer popupTimer = new Timer() {

				@Override
				public void run() {
					popup.hide();
					display.getNameTextBox().setValue("Name");
					display.getEmailTextBox().setValue("Emailadress");
				}
			};

			popupTimer.schedule(5000);
		}
	}
}
