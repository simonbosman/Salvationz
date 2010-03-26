package com.simonbosman.salvationz.client.gin;

import net.customware.gwt.dispatch.client.gin.ClientDispatchModule;
import net.customware.gwt.presenter.client.place.PlaceManager;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.simonbosman.salvationz.client.mvp.presenters.SalvationzAppPresenter;

/**
 * Bootstraps GINjection. Uses the following modules: <br />
 * <ul>
 * <li><code>ClientDispatchModule</code> which provides default dispatcher
 * configuration for injection of a <code>DispatchAsync</code> instance;</li>
 * <li><code>WizardClientModule</code> which provides the Wizard application MVP
 * components.</li>
 * </ul>
 *
 * @author lowec
 *
 */
@GinModules( { ClientDispatchModule.class, WizardClientModule.class })
public interface WizardGinjector extends Ginjector {

	/**
	 * Get the application presenter.
	 *
	 * @return the application presenter
	 */
	//public AppPresenter getAppPresenter();

	/**
	 * @return the app presenter
	 */
	public SalvationzAppPresenter getSalvationzPresenter();

	/**
	 * Get the place manager
	 *
	 * @return the place manager
	 */
	public PlaceManager getPlaceManager();

}
