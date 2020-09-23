package Part1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

		public static ArrayList<Contact> contacts;
		public static int id = 0;
		public static Scanner key;
		public static void main(String[] args) {
			contacts = new ArrayList<>();
			System.out.println("Welcome to my humble app");
			showInitialOption();
		}	
		private static void showInitialOption() {
			System.out.println("--Choose a number : ");
			System.out.println("\t1. Manage contacts\n"+
								"\t2. Messages\n"+
								"\t3. Quit");
			key = new Scanner(System.in);
			int choice = key.nextInt();
			switch(choice) {
				case 1:
					manageContacts();
					break;
				case 2:
					manageMessages();
					break;
				default:
					break;
			}
			System.out.println("***Quit***");
			
		}
		
		private static void manageContacts() {
			
			System.out.println("Choose one Option : ");
			System.out.println("\t1. Show all contacts\n"+
					"\t2. Add a new contact\n"+
					"\t3. Search for contact\n"+
					"\t4.Delete a contact\n"+
					"\t5.Go back to the previous menu");
			int choice = key.nextInt();
			
			switch(choice) {
		
				case 1: 
				
					showAllContacts();
					break;
				
				case 2: 
					
					addContact();
					break;
				
				case 3: 
					
					searchContact();
					break;
				
				case 4: 
					
					deleteContact();
					break;
				
				default:
				
					showInitialOption();
					break;
				
				}
			}
		
		private static void showAllContacts() {
			if(contacts.size() > 0) {
				for(Contact c : contacts) {
					c.getDetails();
					System.out.println("-----------------------------");
				}
			}else {
				System.out.println("There is no contacts in your device");
			}
			showInitialOption();
		}
		
		private static void addContact() {
			System.out.println("Enter the contact's name : ");
			String name = key.next();
			System.out.println("Enter the contact's number : ");
			String number = key.next();
			System.out.println("Enter the contact's email : ");
			String email = key.next();
			if(name.equals("") || number.equals("") || email.contentEquals("")) {
				System.out.println("--Please enter the informations--");
				addContact();
			}else {
				boolean doesExist = false;
				for(Contact c : contacts) {
					if(c.getName().equals(name)) {
						doesExist = true;
					}
				}
				if(!doesExist) {
					Contact contact = new Contact(name, number, email);
					contacts.add(contact);
					System.out.println(name+" has successffuly added");
				}else {
					System.out.println("There is a contact with same name in your device");
				}
				
			}
			
			showInitialOption();
		}
		
		private static void searchContact() {
			System.out.println("Enter the Name : ");
			String name = key.next();
			if(name.equals("")) {
				System.out.println("--Please enter the name--");
				searchContact();
			}else {
				boolean doesExist = false;
				for(Contact c : contacts) {
					if(c.getName().equals(name)) {
						doesExist = true;
						c.getDetails();
					}
				}
				if(!doesExist) {
					System.out.println("Contact not exist in your contacts list");
				}
			}
			showInitialOption();
			
		}
		
		private static void deleteContact() {
			System.out.println("Enter contact's name : ");
			String name = key.next();
			if(name.equals("")) {
				System.out.println("--Please enter the name--");
				deleteContact();
			}else {
				boolean doesExist = false;
				for(Contact c : contacts) {
					if(c.getName().equals(name)) {
						doesExist = true;
						contacts.remove(c);
					}
				}
				if(!doesExist) {
					System.out.println("Contact not exist in your contacts list");
				}
			}
			showInitialOption();
		}
		
		private static void manageMessages() {
			System.out.println("Choose one Option : ");
			System.out.println("\t1. Show the list of all messages\n"+
					"\t2. send a new message\n"+
					"\t3. Go back");
			int choice = key.nextInt();
			switch(choice) {
				case 1:
					showMessages();
					break;
				case 2:
					sendNewMessage();
					break;
				default:
					showInitialOption();
					break;
			}
		}
		
		private static void showMessages() {
			ArrayList<Message> allMessages = new ArrayList<>();
			for(Contact c : contacts) {
				allMessages.addAll(c.getMessages());
			}
			if(allMessages.size()>0) {
				for(Message m : allMessages) {
					m.getDetails();
				}
			}else {
				System.out.println("There are no messages in you device");
			}
			showInitialOption();
		}
		
		private static void sendNewMessage() {
			
			
			System.out.println("Who you want to send a message : ");
			String name = key.next();
			if(name.contentEquals("")) {
					System.out.println("Please enter the name of the contact : ");
					sendNewMessage();
				}else {
					boolean doesExist = false;
					
					for(Contact c : contacts) {
						if(c.getName().equals(name)) {
							doesExist = true;
						}
					}
					if(doesExist) {
						System.out.println("Enter Your Message : ");
						String message = key.next();
						if(message.equals("")) {
							System.out.println("Please enter a message : ");
							sendNewMessage();
						}else {
							id++;
							for(Contact c : contacts) {
								if(c.getName().equals(name)) {
									ArrayList<Message> messages = c.getMessages();
									Message newMessage = new Message(message, name, id);
									messages.add(newMessage);
								}
							}
						}
					}else {
						System.out.println("There is no contact with the name "+name);
					}
				
				showInitialOption();
			}
		}
	}
