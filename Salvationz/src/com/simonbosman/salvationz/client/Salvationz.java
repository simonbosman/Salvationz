package com.simonbosman.salvationz.client;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import com.reveregroup.gwt.imagepreloader.ImageLoadEvent;
import com.reveregroup.gwt.imagepreloader.ImageLoadHandler;
import com.reveregroup.gwt.imagepreloader.ImagePreloader;
import com.simonbosman.salvationz.client.consts.Constants;
import com.simonbosman.salvationz.client.gin.WizardGinjector;
import com.simonbosman.salvationz.client.mvp.presenters.SalvationzAppPresenter;

/**
 * An example implementation of a Wizard using MVP.
 *
 * @author lowec
 *
 */
public class Salvationz implements EntryPoint {

	private final WizardGinjector injector = GWT.create(WizardGinjector.class);

	/**
	 *
	 */
	public void continueLoading() {

		final Element skipMovie = DOM.getElementById("skipMovie");
		final Element flashIntro = DOM.getElementById("flashIntro");

		DOM.removeChild(RootPanel.getBodyElement(), skipMovie);
		DOM.removeChild(RootPanel.getBodyElement(), flashIntro);

		final Element body = RootPanel.getBodyElement();
		body.removeClassName("bodyIntro");
		body.addClassName("bodyMain");

		final SalvationzAppPresenter salvationzPresenter = injector
				.getSalvationzPresenter();
		salvationzPresenter.init();
		injector.getPlaceManager().fireCurrentPlace();

	}

	public void loadFlash(final HTML flashHtml) {

		final Element loading = DOM.getElementById("loading");

		DOM.removeChild(RootPanel.getBodyElement(), loading);
		final Element body = RootPanel.getBodyElement();
		body.addClassName("bodyIntro");
		RootPanel.get("flashIntro").add(flashHtml);
	}

	public void onModuleLoad() {

		try {
			ImagePreloader.load("/salvationz/img/Knoppen_Salvationz-01.png",
					null);
			ImagePreloader.load("/salvationz/img/Knoppen_Salvationz-02.png",
					null);
			ImagePreloader.load("/salvationz/img/Knoppen_Salvationz-03.png",
					null);
			ImagePreloader.load("/salvationz/img/Knoppen_Salvationz-04.png",
					null);
			ImagePreloader.load("/salvationz/img/Knoppen_Salvationz-05.png",
					null);
			ImagePreloader.load("/salvationz/img/Knoppen_Salvationz-06.png",
					null);
			ImagePreloader.load("/salvationz/img/Knoppen_Salvationz-07.png",
					null);

			ImagePreloader.load(
					"/salvationz/img/Titels_Website_350x100_Home.png", null);
			ImagePreloader.load(
					"/salvationz/img/Titels_Website_350x100_Salvationz.png",
					null);
			ImagePreloader.load(
					"/salvationz/img/Titels_Website_350x100_DJ.png", null);
			ImagePreloader
					.load(
							"/salvationz/img/Titels_Website_350x100_Location.png",
							null);
			ImagePreloader.load(
					"/salvationz/img/Titels_Website_350x100_Contact.png", null);
			ImagePreloader
					.load(
							"/salvationz/img/Titels_Website_350x100_Partners.png",
							null);
		} catch (final Exception ex) {
			Log.error("Could not preload the menu buttons", ex);
		}

		final Element skipMovie = DOM.createDiv();
		skipMovie.setId("skipMovie");
		DOM.appendChild(RootPanel.getBodyElement(), skipMovie);

		final Button skipButton = new Button();
		skipButton.setSize("180px", "22px");
		skipButton.addStyleDependentName("skipButton");

		skipButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent arg0) {
				continueLoading();
			}
		});

		RootPanel.get("skipMovie").add(skipButton);

		final Element flashIntro = DOM.createDiv();
		flashIntro.setId("flashIntro");
		DOM.appendChild(RootPanel.getBodyElement(), flashIntro);

		final HTML flashHtml = new HTML(
				"<object width=\"640\" height=\"385\">"
						+ "<param name=\"movie\" value=\"http://www.youtube.com/v/uIt7LqnKn9c&hl=en_US&fs=1&rel=0&color1=0x006699&color2=0x54abd6\">"
						+ "</param><param name=\"allowFullScreen\" value=\"true\"></param><param name=\"allowscriptaccess\" "
						+ "value=\"always\"></param>"
						+ "<embed src=\"http://www.youtube.com/v/FGfr_StxajE&hl=en_US&fs=1&rel=0&color1=0x006699&color2=0x54abd6&autoplay=1\" "
						+ "type=\"application/x-shockwave-flash\" allowscriptaccess=\"always\" allowfullscreen=\"true\" "
						+ "width=\"640\" height=\"385\"></embed></object>");

		final Element loading = DOM.createDiv();
		loading.setId("loading");
		DOM.appendChild(RootPanel.getBodyElement(), loading);

		final HorizontalPanel panel = new HorizontalPanel();

		final Image loadImg = new Image(Constants.salvationz.loader());
		panel.add(loadImg);

		final HTML text = new HTML("<h2> Loading...</h2>");
		panel.add(text);

		RootPanel.get("loading").add(panel);

		ImagePreloader.load(Constants.salvationz.backgroundFlash(),
				new ImageLoadHandler() {

					@Override
					public void imageLoaded(final ImageLoadEvent event) {

						ImagePreloader.load(Constants.salvationz.background(),
								new ImageLoadHandler() {

									@Override
									public void imageLoaded(
											final ImageLoadEvent event) {
									}
								});

						loadFlash(flashHtml);

						final Timer timer = new Timer() {

							@Override
							public void run() {

								continueLoading();
							}
						};

						timer.schedule(90000);

					}
				});

	}
}
