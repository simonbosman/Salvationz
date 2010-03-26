package com.simonbosman.salvationz.server.guice;

import net.customware.gwt.dispatch.server.service.DispatchServiceServlet;

import com.google.inject.servlet.ServletModule;

/**
 * Endpoint for gwt-dispatch
 *
 * @author lowec
 *
 */
public class DispatchServletModule extends ServletModule {

	@Override
	public void configureServlets() {
		// NOTE: the servlet context may need changing for your own apps
		serve("/salvationz/dispatch").with(DispatchServiceServlet.class);
	}

}