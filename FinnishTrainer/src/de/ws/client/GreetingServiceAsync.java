package de.ws.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.ws.shared.Person;
import de.ws.shared.TokenizedText;
import de.ws.shared.User;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void greetServer(String input, AsyncCallback<String> callback) throws IllegalArgumentException;
	void createText(String input, AsyncCallback<TokenizedText> callback);
	void getPerson(String name, String password, AsyncCallback<Person> callback);
	void addUser(String name, String passwd, AsyncCallback<String> callback);
	void saveWords(String word, User user, AsyncCallback<Void> callback);

}