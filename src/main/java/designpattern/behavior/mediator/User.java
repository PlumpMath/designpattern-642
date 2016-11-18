package designpattern.behavior.mediator;

public class User {
	
	private String name;
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public User(String name) {
		this.setName(name);
	}
	
	public void sendMessage(String message) {
		ChatRoom.showMessage(this, message);
	}

}
