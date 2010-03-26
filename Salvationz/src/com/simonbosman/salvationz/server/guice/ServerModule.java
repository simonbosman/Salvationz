package com.simonbosman.salvationz.server.guice;


import net.customware.gwt.dispatch.server.guice.ActionHandlerModule;

import com.simonbosman.salvationz.server.handler.AddToFreeTicketsHandler;
import com.simonbosman.salvationz.server.handler.AddToNewsLetterHandler;


/**
 * Module which binds the handlers and configurations
 *
 */
public class ServerModule extends ActionHandlerModule {

	@Override
	protected void configureHandlers() {
		bindHandler(AddToNewsLetterHandler.class);
		bindHandler(AddToFreeTicketsHandler.class);
	}
}