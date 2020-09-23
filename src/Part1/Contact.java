package Part1;

import java.util.ArrayList;

public class Contact {
	private String name;
	private String number;
	private String email;
	private ArrayList<Message> messages;
	public Contact(String name, String number, String email) {
		this.name = name;
		this.number = number;
		this.email = email;
		this.messages = new ArrayList<>();
	}
	public Contact(String name, String number, String email, ArrayList<Message> messages) {
		this.name = name;
		this.number = number;
		this.email = email;
		this.messages = messages;
	}
	
	public void getDetails() {
		System.out.println("Contact Name : "+name+
						"\nContact Number : "+number+
						"\nContact Email : "+email);
	}
	
	public String getName() {
		return name;
	}
	
	public String getNumber() {
		return number;
	}
	
	public String getEmail() {
		return email;
	}
	
	public ArrayList<Message> getMessages() {
		return messages;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public void setEmail(String email) {
		this.email= email;
	}
}
