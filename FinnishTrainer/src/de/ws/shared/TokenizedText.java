package de.ws.shared;


import java.io.Serializable;
import java.util.ArrayList;

public class TokenizedText implements Serializable{
	
	private static final long serialVersionUID = 2764686765633329356L;
	
	ArrayList<String> tokens;
	public TokenizedText() {
	}
	public TokenizedText(ArrayList<String> tokens) {
		this.tokens = tokens;
	}
	public ArrayList<String> getTokens() {
		return tokens;
	}
	public void setTokens(ArrayList<String> tokens) {
		this.tokens = tokens;
	}
}