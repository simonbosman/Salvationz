package com.simonbosman.salvationz.client.mvp.views;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.simonbosman.salvationz.client.mvp.presenters.FreeTicketsPresenter;

/**
 * @author ubuntu
 *
 */
public class FreeTicketsView implements FreeTicketsPresenter.Display {

	final private DialogBox modal;
	final private AbsolutePanel inner;
	final private FlowPanel footer;
	final private Button closeButton;
	final private Button sendButton;
	final private TextBox emailTextBox;

	/**
	 *
	 */
	public FreeTicketsView() {

		modal = new DialogBox();
		modal.setAnimationEnabled(true);
		modal.setGlassEnabled(true);

		inner = new AbsolutePanel();
		final HTML inhoud = new HTML("");

		inhoud.addStyleName("freeTickets");
		inner.add(inhoud);

		emailTextBox = new TextBox();
		emailTextBox.setText("Emailadress");
		emailTextBox.setWidth("170px");
		inner.add(emailTextBox, 130, 325);

		sendButton = new Button();
		sendButton.setSize("75px", "25px");
		sendButton.addStyleDependentName("sendButton");

		inner.add(sendButton, 120, 362);

		footer = new FlowPanel();
		closeButton = new Button("Close", new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				modal.hide();

			}
		});
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
	}

	@Override
	public HasClickHandlers getCloseButton() {
		return closeButton;
	}

	@Override
	public HasClickHandlers getSendButton() {
		return sendButton;
	}

	@Override
	public TextBox getEmailTextBox() {
		return emailTextBox;
	}
}
