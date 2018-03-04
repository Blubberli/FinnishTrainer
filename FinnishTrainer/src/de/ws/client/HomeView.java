package de.ws.client;

import java.io.Serializable;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

import de.ws.shared.User;

public class HomeView extends Composite implements Serializable {
	
	// UIBinder
	private static HomeViewUiBinder uiBinder = GWT.create(HomeViewUiBinder.class);
	interface HomeViewUiBinder extends UiBinder<Widget, HomeView> {
	}
	
	@UiField
	HTMLPanel mainPanel;
	@UiField
	HTMLPanel navPanel1;
	@UiField
	Anchor userTab;
	@UiField
	Anchor textTab;
	@UiField
	Anchor inputTextTab;
	@UiField
	Anchor homeTab;
	@UiField
	HTMLPanel contentPanel;
//	@UiField
//	Anchor logoutTab;
//	@UiField
//	Anchor settings;
//	@UiField
//	Anchor words;
//	@UiField
//	Anchor practise;
	
	
	HTML helloworld;
	TextBox name;
	Button sign;
	
	User user;
	
	public HomeView() {

		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@UiConstructor
	public HomeView(HTMLPanel mainPanel, User user) {

		initWidget(uiBinder.createAndBindUi(this));
		this.user = user;
		this.mainPanel = mainPanel;
		mainPanel.clear();

		//contentPanel = new HTMLPanel("");
		navPanel1.setStyleName("navpan");
		contentPanel.addStyleName("contentPanel");
		
		
		HTML words = new HTML("");
		for(String s : user.getWordList()) {
			words = new HTML(s + ", " + words.toString());
		}
		
		contentPanel.add(words);
		
		userTab.getElement().setAttribute("data-toggle", "dropdown");
		userTab.getElement().setAttribute("role", "button");
		userTab.getElement().setAttribute("aria-haspopup", "true");
		userTab.getElement().setAttribute("expanded", "false");
		userTab.setHTML("<i class=\"fas fa-user-circle\" aria-hidden=\"true\"></i><span>&nbsp;&nbsp;" + user.getName() +  "</span>");
		homeTab.setHTML("<i class=\"fas fa-home\" aria-hidden=\"true\"></i><span>&nbsp; Home</span>");
		textTab.setHTML("<i class=\"fas fa-file-alt\" aria-hidden=\"true\"></i><span>&nbsp; Texts</span>");
		inputTextTab.setHTML("<i class=\"fas fa-edit\" aria-hidden=\"true\"></i><span>&nbsp; Insert Text</span>");
//		logoutTab.setHTML("<i class=\"fas fa-sign-out-alt\" aria-hidden=\"true\"></i><span>&nbsp; Log out</span>");
//		
//		settings.setHTML("<i class=\"fas fa-cogs\" aria-hidden=\"true\"></i>");
//		words.setHTML("<i class=\"fas fa-language\" aria-hidden=\"true\"></i>");
//		practise.setHTML("<i class=\"fas fa-gamepad\" aria-hidden=\"true\"></i>");
//		
		//userTab.addClickHandler(new UserIconClickHandler(mainPanel, navPanel2));
		
		
		//logoutTab.addClickHandler(new LogoutClickHandler(cp));
		
		
		mainPanel.add(navPanel1);
		mainPanel.add(contentPanel);
		
		

		inputTextTab.addClickHandler(new InputTextClickHandler(contentPanel, user));

	}
	
	private class InputTextClickHandler implements ClickHandler {
		
		HTMLPanel cp;
		HTMLPanel mainPanel;
		User user;

		public InputTextClickHandler(HTMLPanel cp, User user) {
			this.cp = cp;
			this.mainPanel = mainPanel;
			this.user = user;
		}
		@Override
		public void onClick(ClickEvent event) {
			InputTextView itw = new InputTextView(cp, user);
		}
		

	}
	
	
	
	private class LogoutClickHandler implements ClickHandler {
		
		HTMLPanel cp;

		public LogoutClickHandler(HTMLPanel cp) {
			this.cp = cp;
		}
		@Override
		public void onClick(ClickEvent event) {
			//TestView tw = new TestView(cp);
		}

	}
	
	
	private class UserIconClickHandler implements ClickHandler {
		
		HTMLPanel cp;
		HTMLPanel navPanel2;

		public UserIconClickHandler(HTMLPanel cp, HTMLPanel navPanel2) {
			this.cp = cp;
			this.navPanel2 = navPanel2;
		}
		@Override
		public void onClick(ClickEvent event) {
			cp.add(navPanel2);
		}

	}
}
