package de.ws.server;


import de.ws.client.GreetingService;
import de.ws.shared.FieldVerifier;
import de.ws.shared.Person;
import de.ws.shared.TokenizedText;
import de.ws.shared.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {

	public String greetServer(String input) throws IllegalArgumentException {
		// Verify that the input is valid. 
		if (!FieldVerifier.isValidName(input)) {
			// If the input is not valid, throw an IllegalArgumentException back to
			// the client.
			throw new IllegalArgumentException("Name must be at least 4 characters long");
		}

		String serverInfo = getServletContext().getServerInfo();
		String userAgent = getThreadLocalRequest().getHeader("User-Agent");

		// Escape data from the client to avoid cross-site script vulnerabilities.
		input = escapeHtml(input);
		userAgent = escapeHtml(userAgent);

		return "Hello, " + input + "!<br><br>I am running " + serverInfo + ".<br><br>It looks like you are using:<br>"
				+ userAgent;
	}

	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
	}
	@Override
	public TokenizedText createText(String input){
		ArrayList<String> tokens = tokenize(input);
		TokenizedText t = new TokenizedText(tokens);
		return t;
	}

	/**
	 * Takes the input String from the user and tokenizes it. returns an ArrayList of Strings
	 * that represent the words. Adds chars to a Stringbuilder until the word boundary is reached by 
	 * a delimiter or a punctiation symbol. then the word is added to the stringbuilder.
	 * @param input
	 * @return
	 */
	public ArrayList<String> tokenize(String input){
		ArrayList<String> tokenList = new ArrayList<String>();
		StringTokenizer tokenizer = new StringTokenizer(input, "\t\n\r ,.:;?!", true);
		
		while (tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();
			tokenList.add(token);
		}
		return tokenList;

	}
	
	public Person getPerson(String name, String password){
		DatabaseStorage db = new DatabaseStorage();
		db.open();
		db.select(name, password);
		db.close();
		return db.getPerson();

	}
	public String addUser(String name, String password){
		DatabaseStorage db = new DatabaseStorage();
		db.open();
		db.insert(name, password);
		db.close();
		return "sucess";
	}

	@Override
	public void saveWords(String word, User user) {
		DatabaseStorage db = new DatabaseStorage();
		db.open();
		db.select(user.getName(), "");
		db.saveWords(word, user);
		db.close();
	}

}