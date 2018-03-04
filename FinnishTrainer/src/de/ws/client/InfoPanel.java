package de.ws.client;

import java.util.Iterator;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

import de.ws.shared.User;

public class InfoPanel extends Composite {

	private static InfoPanelUiBinder uiBinder = GWT.create(InfoPanelUiBinder.class);
	@UiField
	HTMLPanel textconfig;
//	@UiField
//	HTMLPanel wordconfig;
//	@UiField
//	Button translate;
//	@UiField
//	Button save;
//	@UiField
//	Button grammar;
//	@UiField
//	HTMLPanel wordconfigbuttons;
	User user;
	String word;
	HTMLPanel dafaq;
	HTMLPanel cp;
	@UiField
	HTMLPanel stuff;
	

	interface InfoPanelUiBinder extends UiBinder<Widget, InfoPanel> {
	}

	@UiConstructor
	public InfoPanel() {
		initWidget(uiBinder.createAndBindUi(this));
		
		textconfig.setStyleName("textconfig");
//		wordconfig.setStyleName("wordconfig");
//		
//		//wordconfig = new HTMLPanel("");
//		wordconfigbuttons.setStyleName("wordconfigbuttons");
//		
//		translate.setHTML("<i class=\"fas fa-language aria-hidden=\"true\"\"></i>");
//		save.setHTML("<i class=\"fa fa-save aria-hidden=\"true\"\"></i>");
//		grammar.setHTML("<i class=\"fas fa-info aria-hidden=\"true\"\"></i>");
//		
//		translate.setStyleName("infoWordButton");
//		save.setStyleName("infoWordButton");
//		grammar.setStyleName("infoWordButton");
		
		
	}

	public void setWordToPanel(String string) {
		// TODO Auto-generated method stub
		
//		wordconfig.clear();
//		wordconfig.add(new HTML(string));
	}

}
