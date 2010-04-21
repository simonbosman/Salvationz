package com.simonbosman.salvationz.client.mvp.views;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.simonbosman.salvationz.client.mvp.presenters.TicketsPresenter;

public class TicketsView implements TicketsPresenter.Display {

	final private DialogBox modal;
	final private FlowPanel inner;
	final private FlowPanel footer;
	final private HTML paylogic;
	final private Button closeButton;

	public TicketsView() {

		modal = new DialogBox();
		modal.setAnimationEnabled(true);
		modal.setGlassEnabled(true);
		modal.setText("Buy your tickets...");

		inner = new FlowPanel();
		footer = new FlowPanel();
		paylogic = new HTML();

		closeButton = new Button("Close", new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				modal.hide();
				paylogic
						.setHTML("<iframe frameborder = 0 height = 525px width = 450px src = https://v1.paylogic.nl/frontoffice/?command=paymentMenu&merchantModuleID=26961 "
								+ "scrolling = NO marginheight = 0 marginwidth = 0 name = paymentMenu></iframe>");
			}
		});

		footer.add(closeButton);
		footer.setStyleName("dialogFooter");

		paylogic
				.setHTML("<iframe frameborder = 0 height = 525px width = 450px src = https://v1.paylogic.nl/frontoffice/?command=paymentMenu&merchantModuleID=26961 "
						+ "scrolling = NO marginheight = 0 marginwidth = 0 name = paymentMenu></iframe>");

		inner.add(paylogic);
		inner.add(footer);

		modal.add(inner);
	}

	@Override
	public void hide() {
		modal.hide();

	}

	@Override
	public void show() {
		modal.show();
		modal.center();
		// final int left = modal.getAbsoluteLeft();
		// modal.setPopupPosition(left - 180, modal.getAbsoluteTop());
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
	public HasClickHandlers getCloseButton() {
		return closeButton;
	}

	@Override
	public HTML getPaylogic() {
		return paylogic;
	}

}
