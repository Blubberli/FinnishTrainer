package de.ws.client;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

import de.ws.shared.TokenizedText;
import de.ws.shared.User;


public class TranslatorView extends Composite {

	private static TranslatorViewUiBinder uiBinder = GWT.create(TranslatorViewUiBinder.class);
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	interface TranslatorViewUiBinder extends UiBinder<Widget, TranslatorView> {
	}

	public TranslatorView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	HTMLPanel contentPanel;
	HTML hello;
	ArrayList<String> tokens;
	@UiField
	HTMLPanel hp;
//	@UiField
	HTMLPanel trwindow;
	HTMLPanel mainPanel;
	InfoPanel infoPanel;
	User user;
	@UiField
	HTMLPanel example;
	@UiField
	Button save;

	public TranslatorView(ArrayList<String> tokens, HTMLPanel contentPanel,User user) {
		initWidget(uiBinder.createAndBindUi(this));
		this.contentPanel= contentPanel;
		this.tokens = tokens;
		this.user = user;
		
		contentPanel.clear();
		
		infoPanel = new InfoPanel();
		infoPanel.setStyleName("infoPanel");
		
		example.setHeight("300px");
		example.setWidth("400px");
		example.getElement().setAttribute("background-color:", "grey");
		hp = new HTMLPanel("");
		contentPanel.add(hp);
		contentPanel.add(example);
		contentPanel.add(save);
		hp.setStyleName("textField");
		
		for(String token : tokens) {
			HTML t = new HTML(token);
			if(!t.equals("")) {
				t.setStyleName("token");
				hp.add(t);
				t.addClickHandler(new TokenClickHandler(token, infoPanel, user, contentPanel));
			}
			
			
		}

		contentPanel.add(infoPanel);
		
		contentPanel.add(hp);
		
	
	}
	
	private class TokenClickHandler implements ClickHandler {
		String token;
		InfoPanel ip;
		User user;
		HTMLPanel cp;

		public TokenClickHandler(String token, InfoPanel ip, User user, HTMLPanel cp) {
			this.token = token;
			this.ip = ip;
			this.user = user;
			this.cp = cp;
		}
		@Override
		public void onClick(ClickEvent event) {
			ip.setWordToPanel(token);

		}
	}
	
private class SaveWordsCallback implements AsyncCallback<Void> {
		
		@Override
		public void onSuccess(Void result) {
			
			Window.alert("Added");
			
		}

		@Override
		public void onFailure(Throwable caught) {
			Window.scrollTo(0, 0);
		}


	}


}
