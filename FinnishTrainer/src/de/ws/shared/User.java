package de.ws.shared;

import java.io.Serializable;
import java.util.ArrayList;

public class User extends Person implements Serializable {
	String name;
	String psw;
	ArrayList<String> wordList;
	int id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	public ArrayList<String> getWordList() {
		return wordList;
	}
	public void setWordList(ArrayList<String> wordList) {
		this.wordList = wordList;
	}
	public ArrayList<String> addWordToList(String word) {
		wordList.add(word);
		return wordList;
	}
	

}
