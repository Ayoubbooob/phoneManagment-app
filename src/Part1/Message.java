package Part1;

public class Message {
	
	private String message;
	private String recepient;
	private int id;
	public Message(String message, String recepient, int id) {
		this.message = message;
		this.recepient = recepient;
		this.id = id;
	}
	
	public String getMessage() {
		return message;
	}
	
	public String getRecepient() {
		return recepient;
	}
	
	public int getId() {
		return id;
	}
	public void setMessage(String m) {
		message = m;
	}
	
	public void getDetails() {
		System.out.println("\nContact Name : "+recepient+
				"\nMessage : "+message +
				"\nId : "+id);
	}
}
