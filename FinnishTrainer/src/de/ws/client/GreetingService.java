package de.ws.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import de.ws.shared.Person;
import de.ws.shared.TokenizedText;
import de.ws.shared.User;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	String greetServer(String name) throws IllegalArgumentException;
	TokenizedText createText(String input);
	Person getPerson(String name, String password);
	String addUser(String name, String passwd);
	void saveWords(String word, User user);
}