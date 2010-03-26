package com.simonbosman.salvationz.client.gin;

import net.customware.gwt.presenter.client.DefaultEventBus;
import net.customware.gwt.presenter.client.Display;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.Presenter;
import net.customware.gwt.presenter.client.gin.AbstractPresenterModule;
import net.customware.gwt.presenter.client.place.PlaceManager;

import com.google.inject.Singleton;
import com.simonbosman.salvationz.client.mvp.presenters.DjPresenter;
import com.simonbosman.salvationz.client.mvp.presenters.EastMenuPresenter;
import com.simonbosman.salvationz.client.mvp.presenters.FreeTicketsPresenter;
import com.simonbosman.salvationz.client.mvp.presenters.HeaderPresenter;
import com.simonbosman.salvationz.client.mvp.presenters.HomePresenter;
import com.simonbosman.salvationz.client.mvp.presenters.LocationPresenter;
import com.simonbosman.salvationz.client.mvp.presenters.MainContentPresenter;
import com.simonbosman.salvationz.client.mvp.presenters.PartnersPresenter;
import com.simonbosman.salvationz.client.mvp.presenters.SalvationzAppPresenter;
import com.simonbosman.salvationz.client.mvp.presenters.SalvationzPresenter;
import com.simonbosman.salvationz.client.mvp.presenters.SleepingPresenter;
import com.simonbosman.salvationz.client.mvp.presenters.StartPanelPresenter;
import com.simonbosman.salvationz.client.mvp.presenters.TicketsPresenter;
import com.simonbosman.salvationz.client.mvp.presenters.WestMenuPresenter;
import com.simonbosman.salvationz.client.mvp.views.DjView;
import com.simonbosman.salvationz.client.mvp.views.EastMenuView;
import com.simonbosman.salvationz.client.mvp.views.FreeTicketsView;
import com.simonbosman.salvationz.client.mvp.views.HeaderView;
import com.simonbosman.salvationz.client.mvp.views.HomeView;
import com.simonbosman.salvationz.client.mvp.views.LocationView;
import com.simonbosman.salvationz.client.mvp.views.MainContentView;
import com.simonbosman.salvationz.client.mvp.views.PartnersView;
import com.simonbosman.salvationz.client.mvp.views.SalvationzView;
import com.simonbosman.salvationz.client.mvp.views.SleepingView;
import com.simonbosman.salvationz.client.mvp.views.StartPanelView;
import com.simonbosman.salvationz.client.mvp.views.TicketsView;
import com.simonbosman.salvationz.client.mvp.views.WestMenuView;

/**
 * Configuration for GIN bindings - bind all components that needs to be injected via GIN.
 *
 * @author lowec
 *
 */
public class WizardClientModule extends AbstractPresenterModule {

	@Override
	protected void configure() {
		// Bind core gwt-presenter components
		bind(EventBus.class).to(DefaultEventBus.class).in(Singleton.class);
		bind(PlaceManager.class).in(Singleton.class);

		//Main panel presenter
		bindPresenter(StartPanelPresenter.class, StartPanelPresenter.Display.class, StartPanelView.class);

		//Header presenter
		bindPresenter(HeaderPresenter.class, HeaderPresenter.Display.class, HeaderView.class);

		//East Menu presenter
		bindPresenter(EastMenuPresenter.class, EastMenuPresenter.Display.class, EastMenuView.class);

		//West Menu presenter
		bindPresenter(WestMenuPresenter.class, WestMenuPresenter.Display.class, WestMenuView.class);

		//Content presenter
		bindPresenter(MainContentPresenter.class, MainContentPresenter.Display.class, MainContentView.class);

		//Djpresenter
		bindPresenter(DjPresenter.class, DjPresenter.Display.class, DjView.class);

		//Tickets presenter
		bindPresenter(TicketsPresenter.class, TicketsPresenter.Display.class, TicketsView.class);

		//Home presenter
		bindPresenter(HomePresenter.class, HomePresenter.Display.class, HomeView.class);

		//Salvationz presenter
		bindPresenter(SalvationzPresenter.class, SalvationzPresenter.Display.class, SalvationzView.class);

		//FreeTickets presenter
		bindPresenter(FreeTicketsPresenter.class, FreeTicketsPresenter.Display.class, FreeTicketsView.class);

		//Location presenter
		bindPresenter(LocationPresenter.class, LocationPresenter.Display.class, LocationView.class);

		//Partners presenter
		bindPresenter(PartnersPresenter.class, PartnersPresenter.Display.class, PartnersView.class);

		//Sleeping presenter
		bindPresenter(SleepingPresenter.class, SleepingPresenter.Display.class, SleepingView.class);

		//Make these classes singletons
		bind(SalvationzAppPresenter.class).in(Singleton.class);
	}

    /**
     * @param <D>
     * @param presenter
     * @param display
     * @param displayImpl
     */
    protected <D extends Display> void bindEagerPresenter(final Class<? extends Presenter> presenter,
    													  final Class<D> display,
    													  final Class<? extends D> displayImpl ) {
		bind(presenter).asEagerSingleton();
		bindDisplay(display, displayImpl);
	}
}
