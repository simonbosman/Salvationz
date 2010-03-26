package com.simonbosman.salvationz.shared.events;

import com.google.gwt.event.shared.GwtEvent;

/**
 * @author simon
 *
 */
public class WestMenuEvent extends GwtEvent<WestMenuEventHandler>{

	final private WestMenuEnum menuOption;

	/**
	 * @param menuOption
	 */
	public WestMenuEvent(final WestMenuEnum menuOption){

		this.menuOption = menuOption;
	}

	/**
	 * @return WestMenuEnum
	 */
	public WestMenuEnum getMenuOption(){
		return menuOption;
	}
	/**
	 *
	 */
	public final static Type<WestMenuEventHandler> TYPE = new Type<WestMenuEventHandler>();
	@Override
	protected void dispatch(final WestMenuEventHandler handler) {
		handler.onMenuEvent(this);

	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<WestMenuEventHandler> getAssociatedType() {
		return TYPE;
	}

}
