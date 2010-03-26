package com.simonbosman.salvationz.client.mvp.views;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.HasMouseOverHandlers;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.simonbosman.salvationz.client.mvp.presenters.WestMenuPresenter;

public class WestMenuView extends Composite implements
		WestMenuPresenter.Display {

	final AbsolutePanel westPanel;
	final Button homeButton;
	final Button locatieButton;
	final Button djButton;
	final Button contactButton;
	final Button ticketsButton;
	final Button salvationzButton;
	final Button partnersButton;
	final Button photosButton = null;
	final Button moviesButton = null;
	final Button aboutButton = null;

	public WestMenuView() {

		westPanel = new AbsolutePanel();
		westPanel.setPixelSize(125, 170);

		homeButton = new Button();
		homeButton.addStyleDependentName("West-Home");
		westPanel.add(homeButton, 0, 10);

		salvationzButton = new Button();
		salvationzButton.addStyleDependentName("West-Salvationz");
		westPanel.add(salvationzButton, 0, 32);

		djButton = new Button();
		djButton.addStyleDependentName("West-Dj");
		westPanel.add(djButton, 0, 54);

		ticketsButton = new Button();
		ticketsButton.addStyleDependentName("West-Tickets");
		westPanel.add(ticketsButton, 0, 76);

		locatieButton = new Button();
		locatieButton.addStyleDependentName("West-Location");
		westPanel.add(locatieButton, 0, 98);

		partnersButton = new Button();
		partnersButton.addStyleDependentName("West-Partners");
		westPanel.add(partnersButton, 0, 120);

		contactButton = new Button();
		contactButton.addStyleDependentName("West-Contact");
		westPanel.add(contactButton, 0, 142);

		/*
		 * photosButton = new Button();
		 * photosButton.addStyleDependentName("West");
		 * photosButton.setText("photos"); westPanel.add(photosButton, 0, 120);
		 *
		 * moviesButton = new Button();
		 * moviesButton.addStyleDependentName("West");
		 * moviesButton.setText("movies"); westPanel.add(moviesButton, 0, 140);
		 *
		 * aboutButton = new Button();
		 * aboutButton.addStyleDependentName("West");
		 * aboutButton.setText("about"); westPanel.add(aboutButton, 0, 120);
		 */
		initWidget(westPanel);
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
	public HasClickHandlers getContactClick() {
		return contactButton;
	}

	@Override
	public HasClickHandlers getDjClick() {
		return djButton;
	}

	@Override
	public HasClickHandlers getHomeClick() {
		return homeButton;
	}

	@Override
	public HasClickHandlers getLocatieClick() {
		return locatieButton;
	}

	@Override
	public HasClickHandlers getTicketsClick() {
		return ticketsButton;
	}

	@Override
	public HasClickHandlers getSalvationzClick() {
		return salvationzButton;
	}

	@Override
	public HasMouseOverHandlers getHomeMouseOver() {
		return homeButton;
	}

	@Override
	public HasMouseOverHandlers getContactMouseOver() {
		return contactButton;
	}

	@Override
	public HasMouseOverHandlers getDjMouseOver() {
		return djButton;
	}

	@Override
	public HasMouseOverHandlers getLocatieMouseOver() {
		return locatieButton;
	}

	@Override
	public HasMouseOverHandlers getSalvationzMouseOver() {
		return salvationzButton;
	}

	@Override
	public HasClickHandlers getPartnersClick() {
		return partnersButton;
	}

}
