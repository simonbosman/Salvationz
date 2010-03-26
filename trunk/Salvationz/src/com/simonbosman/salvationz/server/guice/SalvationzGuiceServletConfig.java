package com.simonbosman.salvationz.server.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

/**
 * Servlet listener used to create Guice injection modules for our environment
 *
 * @author lowec
 *
 */
public class SalvationzGuiceServletConfig extends GuiceServletContextListener {

	@Override
	protected Injector getInjector() {
		return Guice.createInjector(new ServerModule(), new DispatchServletModule());
	}
}