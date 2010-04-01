package com.simonbosman.salvationz.client.mvp.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.simonbosman.salvationz.client.mvp.presenters.PartnersPresenter;

/**
 * @author ubuntu
 *
 */
public class PartnersView extends Composite implements
		PartnersPresenter.Display {

	private static PartnersViewUiBinder uiBinder = GWT
			.create(PartnersViewUiBinder.class);

	interface PartnersViewUiBinder extends UiBinder<Widget, PartnersView> {
	}

	final private Widget partnersUiWidget;

	/*@UiField
	Image bavariaImg;
	@UiField
	Image nhImg;
	@UiField
	Image paylogicImg;
	@UiField
	Image primeraImg;
	@UiField
	Image ffImg;
	@UiField
	Image partnersImg;
*/
	/**
	 *
	 */
	public PartnersView() {

		partnersUiWidget = uiBinder.createAndBindUi(this);

		/*
		 * bavariaImg.setUrl(Constants.salvationz.bavariaImg());
		 * bavariaImg.addStyleDependentName("Cursor");
		 * bavariaImg.addClickHandler(new ClickHandler() {
		 *
		 * @Override public void onClick(final ClickEvent arg0) {
		 * Window.open("http://www.bavaria.nl", "_blank", null);
		 *
		 * } });
		 *
		 * nhImg.setUrl(Constants.salvationz.nhImg());
		 * nhImg.addStyleDependentName("Cursor"); nhImg.addClickHandler(new
		 * ClickHandler() {
		 *
		 * @Override public void onClick(final ClickEvent arg0) {
		 * Window.open("http://www.nh-hotels.nl", "_blank", null);
		 *
		 * } });
		 *
		 * paylogicImg.setUrl(Constants.salvationz.paylogicImg());
		 * paylogicImg.addStyleDependentName("Cursor");
		 * paylogicImg.addClickHandler(new ClickHandler() {
		 *
		 * @Override public void onClick(final ClickEvent arg0) {
		 * Window.open("http://www.paylogic.nl", "_blank", null);
		 *
		 * } });
		 *
		 * primeraImg.setUrl(Constants.salvationz.primeraImg());
		 * primeraImg.addStyleDependentName("Cursor");
		 * primeraImg.addClickHandler(new ClickHandler() {
		 *
		 * @Override public void onClick(final ClickEvent arg0) {
		 * Window.open("http://www.primera.nl", "_blank", null); } });
		 *
		 * ffImg.setUrl(Constants.salvationz.fitnessFirstImg());
		 * ffImg.addStyleDependentName("Cursor"); ffImg.addClickHandler(new
		 * ClickHandler() {
		 *
		 * @Override public void onClick(final ClickEvent arg0) {
		 * Window.open("http://www.fitnessfirst.nl", "_blank", null);
		 *
		 * } });
		 *
		 * partnersImg.setUrl(Constants.salvationz.partnersImg());
		 * partnersImg.getElement().setAttribute("usemap", "partners");
		 */
		initWidget(partnersUiWidget);

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

}
