package com.simonbosman.salvationz.client.mvp.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.simonbosman.salvationz.client.mvp.presenters.DjPresenter;

/**
 * @author ubuntu
 *
 */
public class DjView extends Composite implements DjPresenter.Display{

	private static DjViewUiBinder uiBinder = GWT.create(DjViewUiBinder.class);

	interface DjViewUiBinder extends UiBinder<Widget, DjView> {
	}

	/**
	 * @param firstName
	 */
	public DjView() {
		initWidget(uiBinder.createAndBindUi(this));
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
