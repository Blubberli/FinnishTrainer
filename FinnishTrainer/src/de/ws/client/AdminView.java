package de.ws.client;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;


public class AdminView {

	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
	HTMLPanel contentPanel;
	TextBox name;
	TextBox passwd;
	HTMLPanel hp;
	Button addUser;
	HTML nameInstr;
	HTML passwdInstr;
	
	public AdminView(HTMLPanel contentPanel) {
		
		this.contentPanel = contentPanel;

		contentPanel.clear();
		hp = new HTMLPanel("");
		
		nameInstr = new HTML("Please enter new name");
		name = new TextBox();
		
		passwdInstr = new HTML("Please enter new password");
		passwd = new TextBox();
		
		hp.setStyleName("adminPanel");
		addUser = new Button("Add new User");
		addUser.addClickHandler(new NewUserClickHandler(name, passwd));
		
		
		hp.add(nameInstr);
		hp.add(name);
		hp.add(passwdInstr);
		hp.add(passwd);
		hp.add(addUser);

		
		contentPanel.add(hp);
		
	}
	
	private class NewUserClickHandler implements ClickHandler {
		TextBox name;
		TextBox passwd;
		
		public NewUserClickHandler(TextBox name, TextBox passwd) {
			this.name = name;
			this.passwd = passwd;
		}

		@Override
		public void onClick(ClickEvent event) {
			greetingService.addUser(name.getText(), passwd.getText(), new NewUserCallback());
		}

	}

	private class NewUserCallback implements AsyncCallback<String> {
		
		@Override
		public void onSuccess(String message) {
			Window.alert(message);
		}

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert("Din't work");
			
		}
	}
}
