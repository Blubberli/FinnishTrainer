package de.ws.client;



import java.util.ArrayList;
import java.util.HashMap;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.ws.shared.Admin;
import de.ws.shared.Person;
import de.ws.shared.TokenizedText;
import de.ws.shared.User;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class FinnishTrainer implements EntryPoint, ValueChangeHandler<String> {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network " + "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	
	HTMLPanel mainPanel;
	TextBox name;
	TextBox password;
	Button send;
	

	@Override
	public void onModuleLoad() {
		HTML na = new HTML("Please enter your login");
		name = new TextBox();
		HTML pa = new HTML("Please enter your password");
		password = new TextBox();
		//_____________________________
		
		send = new Button("send");
		mainPanel = new HTMLPanel("");
		mainPanel.setStyleName("conPan");
		mainPanel.add(na);
		mainPanel.add(name);
		mainPanel.add(pa);
		mainPanel.add(password);

		send.addClickHandler(new UserClickHandler(mainPanel, name, password));
		
		mainPanel.add(send);

		RootPanel.get().setStyleName("haupt");
		RootPanel.get().add(mainPanel);
		
		
		
//		
//		// initialize history system
//		History.addValueChangeHandler(this);
//		// get current token, if any
//		String startingToken = History.getToken();
//		// push token to history stack
//		History.newItem(startingToken);
//		// force the system to evaluate the current history token
//		History.fireCurrentHistoryState();
	}
	
	private class UserClickHandler implements ClickHandler {
		TextBox name;
		TextBox password;
		HTMLPanel cp;

		public UserClickHandler(HTMLPanel cp, TextBox name, TextBox password) {
			this.cp = cp;
			this.name = name;
			this.password = password;
		}
		@Override
		public void onClick(ClickEvent event) {
			greetingService.getPerson(name.getText(), password.getText(), new PersonCallback());
		}

	}
	
	private class PersonCallback implements AsyncCallback<Person> {
		
	
		@Override
		public void onSuccess(Person person) {
			if(person.getRole()=="none") {
				Window.alert("You have entered a wrong name please try again");
				
			} else if(person instanceof Admin) {
				AdminView aw = new AdminView(mainPanel);
				
			} else if(person instanceof User) { 
				User user = (User) person; 
				HomeView hm = new HomeView(mainPanel, user);
			} 
		}

		@Override
		public void onFailure(Throwable caught) {
			Window.scrollTo(0, 0);
		}
	}

	
	private void initializeHistory() {
		// TODO Auto-generated method stub
		History.addValueChangeHandler(this);
		// get current token, if any
		String startingToken = History.getToken();
		// push token to history stack
		History.newItem(startingToken);
		// force the system to evaluate the current history token
		History.fireCurrentHistoryState();
		
	}
	
	private void buildStaticInterface(FlowPanel cp) {
		// create a menu bar
		MenuBar menu = new MenuBar();
		

		
		menu.addItem("home", new ChangeCommand("home"));

		// add text item in menu
		menu.addItem("texts", new ChangeCommand("texts"));

		// add persons item in menu
	
		menu.addItem("input", new ChangeCommand("input"));
		
		RootPanel.get().add(menu);

		//contentPanel = new FlowPanel();
		RootPanel.get().add(cp);
	}
	
	/**
	 * A command to handle changes in the history.
	 * 
	 * @author bjoern
	 *
	 */
	private class ChangeCommand implements Command {

		private String histToken;
		
		
		
		public ChangeCommand(String histToken) {
			super();
			this.histToken = histToken;
		}

		@Override
		public void execute() {
			History.newItem(histToken);
		}
		
	}

	/**
	 * Handles change events in the history tokens. Called when a user uses the
	 * back and forward button in the browser or when he directly types the
	 * address with history tokens.
	 */
	@Override
	public void onValueChange(ValueChangeEvent<String> event) {

		String token = event.getValue();

		if (token == null || token.isEmpty()) {
			showHomePage();
			return;
		} else if (token.equals("home")) {
			showHomePage();
			return;
		} else if (token.equals("texts")) {
			showTextsPage();
			return;
		} else if (token.equals("input")) {
			showInputPage();
			return;
		}
		showErrorPage();
		return;
	}

	/**
	 * Fills the content of the page with some texts.
	 */
	private void showTextsPage() {

		// remove existing content

		//TextsView tw = new TextsView(contentPanel);
	}

	/**
	 * Fills the content of the page with some information about the team.
	 */
	private void showInputPage() {
		
		//InputTextView itw = new InputTextView(contentPanel);
		
	}

	/**
	 * Fills the content of the page with a start screen.
	 */
	private void showHomePage() {

		// remove existing content

	//	HomeView itw = new HomeView(mainPanel);
	}

	/**
	 * Fills the content of the page with an error text.
	 */
	private void showErrorPage() {

		// remove existing content
		mainPanel.clear();

		HTML errorText = new HTML("<h2>Error:</h2> page does not exist.");
		mainPanel.add(errorText);
	}
	
}
