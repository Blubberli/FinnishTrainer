package de.ws.client;

import java.util.ArrayList;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;

import de.ws.shared.TokenizedText;

public class TextsView {
	
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	FlowPanel contentPanel;
	ArrayList<String> tokens;

	HTMLPanel textBox;
	String text;
	HTML httext;
	
	public TextsView(FlowPanel contentPanel) {
		this.contentPanel = contentPanel;
		contentPanel.clear();
		text = "What a great pleasure to be chosen";
		httext = new HTML(text);
		textBox = new HTMLPanel("");
		textBox.setStyleName("textBox");
		textBox.add(httext);
		

		textBox.addDomHandler(new TextClickHandler(text, contentPanel), ClickEvent.getType());
		
		contentPanel.add(textBox);
		
		
	}
	
	private class TextClickHandler implements ClickHandler {
		String text;
		FlowPanel cp;

		public TextClickHandler(String text, FlowPanel cp) {
			this.text = text;
			this.cp = cp;
		}
		@Override
		public void onClick(ClickEvent event) {
			greetingService.createText(text, new TokenizationCallback());
			

		}
	}
	private class TokenizationCallback implements AsyncCallback<TokenizedText> {
		
		@Override
		public void onSuccess(TokenizedText result) {
			tokens = result.getTokens();
			contentPanel.clear();
			//TranslatorView tw = new TranslatorView(result.getTokens(), contentPanel);
		}

		@Override
		public void onFailure(Throwable caught) {
			Window.scrollTo(0, 0);
		}
	}

	
}
