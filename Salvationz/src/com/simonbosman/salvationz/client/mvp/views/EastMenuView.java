package com.simonbosman.salvationz.client.mvp.views;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratedPopupPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.simonbosman.salvationz.client.consts.Constants;
import com.simonbosman.salvationz.client.mvp.presenters.EastMenuPresenter;

public class EastMenuView extends Composite implements
		EastMenuPresenter.Display {

	private final AbsolutePanel eastPanel;
	private final Image bannerTickets;
	private final Image bannerDjBattle;
	private final Image twitterImg;
	private final Image hyvesImg;
	private final Image facebookImg;
	private final Image partyflockImg;
	private final Image youtubeImg;
	private final Image nieuwsBriefImg;
	private final DecoratedPopupPanel popup;
	private final TextBox nameTextBox;
	private final TextBox emailTextBox;
	private final HTML popupContent;

	public EastMenuView() {

		eastPanel = new AbsolutePanel();
		eastPanel.setPixelSize(190, 500);

		hyvesImg = new Image(Constants.salvationz.hyvesImg());
		hyvesImg.addStyleDependentName("East");
		eastPanel.add(hyvesImg, 10, 0);

		facebookImg = new Image(Constants.salvationz.facebookImg());
		facebookImg.addStyleDependentName("East");
		eastPanel.add(facebookImg, 46, 0);

		partyflockImg = new Image(Constants.salvationz.partyflockImg());
		partyflockImg.addStyleDependentName("East");
		eastPanel.add(partyflockImg, 82, 0);

		youtubeImg = new Image(Constants.salvationz.youtubeImg());
		youtubeImg.addStyleDependentName("East");
		eastPanel.add(youtubeImg, 118, 0);

		twitterImg = new Image(Constants.salvationz.twitterImg());
		twitterImg.addStyleDependentName("East");
		eastPanel.add(twitterImg, 154, 0);

		bannerTickets = new Image(Constants.salvationz.bannerTickets());
		bannerTickets.addStyleDependentName("East");
		eastPanel.add(bannerTickets, 10, 38);

		bannerDjBattle = new Image(Constants.salvationz.bannerDjBattle());
		bannerDjBattle.addStyleDependentName("East");
		eastPanel.add(bannerDjBattle, 10, 142);

		nieuwsBriefImg = new Image(Constants.salvationz
				.nieuwsBriefButton());
		nieuwsBriefImg.addStyleDependentName("East");
		eastPanel.add(nieuwsBriefImg, 10, 247);

		nameTextBox = new TextBox();
		nameTextBox.setText("Name");
		nameTextBox.setWidth("170px");
		eastPanel.add(nameTextBox, 10, 267);

		emailTextBox = new TextBox();
		emailTextBox.setText("Emailadress");
		emailTextBox.setWidth("170px");
		eastPanel.add(emailTextBox, 10, 296);

		popupContent = new HTML("Oops, something went wrong. <br>Pls send an email to techniek@salvationz.nl");
		popup = new DecoratedPopupPanel(true);
		popup.setAnimationEnabled(true);
		popup.add(popupContent);

		initWidget(eastPanel);
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
	public HasClickHandlers getTwitterClick() {
		return twitterImg;
	}

	@Override
	public HasClickHandlers getFacebookClick() {
		return facebookImg;
	}

	@Override
	public HasClickHandlers getHyvesClick() {
		return hyvesImg;
	}

	@Override
	public HasClickHandlers getPartyflockClick() {
		return partyflockImg;
	}

	@Override
	public HasClickHandlers getYoutubeClick() {
		return youtubeImg;
	}

	@Override
	public HasClickHandlers getDjBattleClick() {
		return bannerDjBattle;
	}

	@Override
	public HasClickHandlers getTicketsClick() {
		return bannerTickets;
	}

	@Override
	public HasClickHandlers getNieuwsBriefClick() {
		return nieuwsBriefImg;
	}

	@Override
	public DecoratedPopupPanel getPopup() {
		return popup;
	}

	@Override
	public TextBox getEmailTextBox() {
		return emailTextBox;
	}

	@Override
	public TextBox getNameTextBox() {
		return nameTextBox;
	}

	@Override
	public HTML getPopupContent() {
		return popupContent;
	}

}
