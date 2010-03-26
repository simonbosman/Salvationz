package com.simonbosman.salvationz.shared.events;

import com.google.gwt.event.shared.GwtEvent;

public class FlashEvent extends GwtEvent<FlashEventHandler>{

	final private FlashEnum flashOption;
	public final static Type<FlashEventHandler> TYPE = new Type<FlashEventHandler>();

	public FlashEvent(final FlashEnum flashOption){
		this.flashOption = flashOption;
	}

	public FlashEnum getFlashOption(){
		return flashOption;
	}

	@Override
	protected void dispatch(final FlashEventHandler handler) {
		handler.onFlashEvent(this);

	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<FlashEventHandler> getAssociatedType() {
		return TYPE;
	}



}
