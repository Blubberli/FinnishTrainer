package de.ws.server;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import de.ws.shared.Admin;
import de.ws.shared.Person;
import de.ws.shared.User;

public class DatabaseStorage {
	Connection  co;
	String userName;
	String errorWord;
	int userId;
	User user;
	Admin admin;
	Person person;
	ArrayList<String> wordlist;
	
	
	public String getErrorWord() {
		return errorWord;
	}
	public void setErrorWord(String errorWord) {
		this.errorWord = errorWord;
	}
	
    public static void main(String[] args) {
    	System.out.println("0");
    	DatabaseStorage db = new DatabaseStorage();
    	System.out.println("1");
        db.open();
    }
    
	public DatabaseStorage() {
	}
    
	void open() {
		try {
			Class.forName("org.sqlite.JDBC");
			String path = "jdbc:sqlite:users.db";
			System.out.println(1);
			co = DriverManager.getConnection(path);
			Statement statement = co.createStatement();
			System.out.println("Connected");
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	void insert(String name2, String passwd2) {
		try {
		String name = name2;
		String passwd = passwd2;
		//user = new User();
		
		String query = 
				"INSERT INTO users (name, passwd) " +
				"VALUES('" + name + "', '" + passwd + "');";
		
		Statement sta = co.createStatement();
		sta.executeUpdate(query);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	void close() {
		try {
			co.close();
			System.out.println("closed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void saveWords(String word, User user) {
		try {
			
			int userId = user.getId();
			String query = 
					"INSERT INTO userWords (userId, word) " +
					"VALUES('" + userId + "', '" + word + "');";
			
			System.out.println("added");
			Statement sta = co.createStatement();
			sta.executeUpdate(query);
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	
	void returnWords() {
		
	}
	
	void select(String name2, String password2) {
		try {
		//	String query = "SELECT id, name, word FROM users ORDER BY name;";
			String query = "SELECT id, name, passwd FROM users;";

			PreparedStatement pstmt  = co.prepareStatement(query);
			
			ResultSet rs = pstmt.executeQuery();
			
			//user = new User();
			person = new Person();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String password = rs.getString("passwd");
				userId = id;
				
				//System.out.println(name2 + " : " + name);
				
				if(name2.equals(name)) {
					if(name.equals("admin")) {
				//		errorWord = "admin";
//						admin = (Admin) new Person();
//						admin.setRole(role);
//						person.setRole("admin");
//						person.setName();
						admin = new Admin();
						admin.setName("admin");
						person = admin;
						person.setRole("admin");
						break;
						
					} else {
						user = new User();
						user.setId(userId);
						user.setName(name);
						getDatabaseWords(user);
						person = user;
						person.setRole("user");
			//			errorWord = name;
						break;
					} 
					
				} else {
					person.setRole("none");
				}
			}

			
			System.out.println("selected");
			System.out.println(person.getRole());
			//System.out.println("Name: " + user.getName() + " Id: " + user.getId());
			
			rs.close();
			pstmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void getDatabaseWords(User user) {
		int id = user.getId();
		wordlist = new ArrayList<>();
		try {
			String query = "SELECT word FROM userWords WHERE userId=" + id + ";";

			PreparedStatement pstmt;
			pstmt = co.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				wordlist.add(rs.getString("word"));
			}
			
			rs.close();
			pstmt.close();
			
			user.setWordList(wordlist);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
		
}
	/**
	 * Creates or opens a database at the given path
	 * 
	 * @param databasePath the path to the SQLite database
	 * @throws Exception 
	 */
//	public DatabaseStorage(String databasePath) throws Exception {
//
//		co = null;
//
//		try {
//			
//			Class.forName("org.sqlite.JDBC");
//			co = DriverManager.getConnection("jdbc:sqlite:uders.db");
//			
			// create a database connection
//			databaseConnection = DriverManager.getConnection("jdbc:sqlite:" + databasePath);
//			databaseConnection.setAutoCommit(false);
//			Statement statement = databaseConnection.createStatement();
//			statement.addBatch("update people set firstname='Kate' where id=1");
//		    statement.addBatch("update people set firstname='Neele' where id=2");
//			statement.executeBatch();
//			databaseConnection.commit();
//		}
//		catch(SQLException | ClassNotFoundException e) {
//			// if the error message is "out of memory",
//			// it probably means no database file is found
//			databaseConnection.close();
//			throw e;
//		}
//	}
//	
//	/**
//	 * closes the database connection
//	 * @throws SQLException
//	 */
//	public void close() throws SQLException {
//		databaseConnection.close();
//	}
	

