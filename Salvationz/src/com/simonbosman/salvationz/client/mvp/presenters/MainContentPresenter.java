package com.simonbosman.salvationz.client.mvp.presenters;

import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;
import net.customware.gwt.presenter.client.place.PlaceRequest;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.inject.Inject;
import com.simonbosman.salvationz.client.consts.Constants;
import com.simonbosman.salvationz.shared.events.WestMenuEvent;
import com.simonbosman.salvationz.shared.events.WestMenuEventHandler;

/**
 * @author simon
 *
 */
public class MainContentPresenter extends
		WidgetPresenter<MainContentPresenter.Display> {

	final private WestMenuPresenter westMenuPresenter;
	final private HomePresenter homePresenter;
	final private SalvationzPresenter salvationzPresenter;
	final private DjPresenter djPresenter;
	final private LocationPresenter locationPresenter;
	final private PartnersPresenter partnersPresenter;

	/**
	 * @param display
	 * @param eventBus
	 * @param westMenuPresenter
	 * @param locationPresenter
	 */
	@Inject
	public MainContentPresenter(final Display display, final EventBus eventBus,
			final WestMenuPresenter westMenuPresenter,
			final SalvationzPresenter salvationzPresenter,
			final DjPresenter djPresenter,
			final LocationPresenter locationPresenter,
			final PartnersPresenter partnersPresenter,
			final HomePresenter homePresenter) {
		super(display, eventBus);
		this.westMenuPresenter = westMenuPresenter;
		this.salvationzPresenter = salvationzPresenter;
		this.djPresenter = djPresenter;
		this.locationPresenter = locationPresenter;
		this.partnersPresenter = partnersPresenter;
		this.homePresenter = homePresenter;
	}

	/**
	 * @author simon
	 *
	 */
	public interface Display extends WidgetDisplay {
		/**
		 * @return {@link FlowPanel}
		 */
		public FlowPanel getWestMenu();

		/**
		 * @return {@link FlowPanel}
		 */
		public FlowPanel getHeaderContent();

		/**
		 * @return {@link FlowPanel}
		 */
		public FlowPanel getMainContent();

		/**
		 * @return mainConainer
		 */
		public FlowPanel getMainConainter();

	}

	private void loadContent() {

		/*display.getMainConainter().getParent().getParent().removeStyleName(
				"westPanel");
		display.getMainConainter().getParent().getParent().addStyleName(
				"westPanelHome");*/
		display.getHeaderContent().add(
				new Image(Constants.salvationz.headerDj()));

		display.getMainContent().add(homePresenter.getDisplay().asWidget());

		display.getWestMenu().add(westMenuPresenter.getDisplay().asWidget());
		westMenuPresenter.bind();
	}

	@Override
	public Place getPlace() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void onBind() {
		loadContent();

		eventBus.addHandler(WestMenuEvent.TYPE, new WestMenuEventHandler() {

			@Override
			public void onMenuEvent(final WestMenuEvent event) {

				display.getHeaderContent().remove(0);

				switch (event.getMenuOption()) {

				case HOME:
					/*display.getMainConainter().getParent().getParent()
							.removeStyleName("westPanel");
					display.getMainConainter().getParent().getParent()
							.addStyleName("westPanelHome");*/
					display.getHeaderContent().add(
							new Image(Constants.salvationz.headerDj()));
					display.getMainContent().remove(0);
					display.getMainContent().add(
							homePresenter.getDisplay().asWidget());
					homePresenter.bind();
					break;

				case LOCATION:
					/*display.getMainConainter().getParent().getParent()
							.removeStyleName("westPanelHome");
					display.getMainConainter().getParent().getParent()
							.addStyleName("westPanel");
					*/display.getHeaderContent().add(
							new Image(Constants.salvationz.headerLocation()));
					display.getMainContent().remove(0);
					display.getMainContent().add(
							locationPresenter.getDisplay().asWidget());
					locationPresenter.bind();
					break;

				case DJ:
					/*display.getMainConainter().getParent().getParent()
							.removeStyleName("westPanelHome");
					display.getMainConainter().getParent().getParent()
							.addStyleName("westPanel");
					*/display.getHeaderContent().add(
							new Image(Constants.salvationz.headerDj()));
					display.getMainContent().remove(0);
					display.getMainContent().add(
							djPresenter.getDisplay().asWidget());
					djPresenter.bind();
					break;

				case CONTACT:
/*					display.getMainConainter().getParent().getParent()
							.removeStyleName("westPanelHome");
					display.getMainConainter().getParent().getParent()
							.addStyleName("westPanel");
*/					display.getHeaderContent().add(
							new Image(Constants.salvationz.headerContact()));
					display.getMainContent().remove(0);
					// TODO: Clean this up...put in an UIBinder
					final HTML contact = new HTML(
							"<p class=tittle>Organisatie</p>"
									+ "<p><a href=\"http://www.guaranteevents.nl\" target=\"_blank\">"
									+ "<img src=\"/salvationz/img/ge.jpg\" href=\"http://www.guaranteevents.nl\"><br>"
									+ "Guaranteevents</a><br>"
									+ "<a href=mailto:info@salvationz.nl>mail@guaranteevents.nl</a></p>"
									+ "<p class=tittle>E-tickets</p>"
									+ "<p>Voor alle vragen over e-ticket...<br>"
									+ "<a href=mailto:e-tickets@salvationz.nl>e-tickets@salvationz.nl</a></p>"
									+ "<p class=tittle>Marketing en communicatie</p>"
									+ "<p>Voor alle promotionele activiteiten...<br>"
									+ "<a href=mailto:MC@salvationz.nl>MC@salvationz.nl</a></p>");
					contact.addStyleDependentName("Contact");
					display.getMainContent().add(contact);
					break;
				case TICKETS:
/*					display.getMainConainter().getParent().getParent()
							.removeStyleName("westPanelHome");
					display.getMainConainter().getParent().getParent()
							.addStyleName("westPanel");
*/					display.getHeaderContent().add(new HTML("Tickets<hr>"));
					display.getMainContent().remove(0);
					display.getMainContent().add(
							new HTML("Buy your tickets at paylogic..."));
					break;
				case PHOTOS:
					display.getHeaderContent().add(new HTML("Photo's<hr>"));
					display.getMainContent().remove(0);
					display.getMainContent().add(new HTML(""));
					break;
				case MOVIES:
					display.getHeaderContent().add(new HTML("Movies<hr>"));
					display.getMainContent().remove(0);
					display.getMainContent().add(new HTML(""));
					break;
				case ABOUT:
					display.getHeaderContent().add(new HTML("About<hr>"));
					display.getMainContent().remove(0);
					display.getMainContent().add(new HTML(""));
					break;
				case SALVATIONZ:
				/*	display.getMainConainter().getParent().getParent()
							.removeStyleName("westPanelHome");
					display.getMainConainter().getParent().getParent()
							.addStyleName("westPanel");
				*/	display.getHeaderContent().add(
							new Image(Constants.salvationz.headerSalvationz()));
					display.getMainContent().remove(0);
					display.getMainContent().add(
							salvationzPresenter.getDisplay().asWidget());
					salvationzPresenter.bind();
					break;

				case PARTNERS:
				/*	display.getMainConainter().getParent().getParent()
							.removeStyleName("westPanelHome");
					display.getMainConainter().getParent().getParent()
							.addStyleName("westPanel");
				*/	display.getHeaderContent().add(
							new Image(Constants.salvationz.headerPartners()));
					display.getMainContent().remove(0);
					display.getMainContent().add(
							partnersPresenter.getDisplay().asWidget());
					partnersPresenter.bind();
					break;

				default:
					display.getHeaderContent().add(
							new HTML(event.getMenuOption() + "<hr>"));
					display.getMainContent().remove(0);
					display.getMainContent().add(new HTML(""));
					break;

				}

			}
		});
	}

	@Override
	protected void onPlaceRequest(final PlaceRequest request) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onUnbind() {
		// TODO Auto-generated method stub

	}

	@Override
	public void refreshDisplay() {
		// TODO Auto-generated method stub

	}

}
