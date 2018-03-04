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

import de.ws.shared.TokenizedText;
import de.ws.shared.User;

public class InputTextView {

	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
	//HTMLPanel contentPanel;
	HTMLPanel contentPanel;
	ArrayList<String> tokens;
	TextArea textArea;
	HTML instruction;
	Button submit;
	String userName;
	User user;
	
	public InputTextView(HTMLPanel contentPanel, User user) {
		this.contentPanel = contentPanel;
		this.user = user;
		
		//contentPanel.clear();
		
		instruction = new HTML("Please Enter a text");
		textArea = new TextArea();
		textArea.setStyleName("textArea");
		
		submit = new Button("Sumbit");
		
		contentPanel.clear();
		contentPanel.add(instruction);
		contentPanel.add(textArea);
		contentPanel.add(submit);
		submit.addDomHandler(new TextClickHandler(textArea, contentPanel, user), ClickEvent.getType());
		//submit.addDomHandler(new TextClickHandler(textArea, contentPanel, userName), ClickEvent.getType());
		
		
		
		 //contentPanel.add(inside);
		
		
	}
	
	private class TextClickHandler implements ClickHandler {
		String text;
		HTMLPanel cp;
		TextArea ta;
		User user;

		public TextClickHandler(TextArea ta, HTMLPanel cp, User user) {
			this.ta = ta;
			this.cp = cp;
			this.user = user;
		}
		@Override
		public void onClick(ClickEvent event) {
			text = ta.getText();
			greetingService.createText(text, new TokenizationCallback());
			//greetingService.saveWords(text, name, new SaveWordsCallback());
			

		}
	}
	private class TokenizationCallback implements AsyncCallback<TokenizedText> {
		
		@Override
		public void onSuccess(TokenizedText result) {
			tokens = result.getTokens();
			//contentPanel.clear();
			TranslatorView tw = new TranslatorView(result.getTokens(), contentPanel, user);
		}

		@Override
		public void onFailure(Throwable caught) {
			Window.scrollTo(0, 0);
		}
	}
//	private class SaveWordsCallback implements AsyncCallback<String> {
//		
//		@Override
//		public void onSuccess(String word) {
//			Window.alert(word);
////			tokens = result.getTokens();
////			contentPanel.clear();
////			TranslatorView tw = new TranslatorView(result.getTokens(), contentPanel);
//		}
//
//		@Override
//		public void onFailure(Throwable caught) {
//			Window.scrollTo(0, 0);
//		}
//	}

}
