package designpatterns.behavioral_patterns;

import java.util.ArrayList;
import java.util.List;

public class MediatorTest {

	public static void main(String[] args) throws InterruptedException {
		ChatMediator mediator = new ChatMediatorImpl();
		User user1 = new UserImpl(mediator, "Pankaj");
		User user2 = new UserImpl(mediator, "Lisa");
		User user3 = new UserImpl(mediator, "Saurabh");
		User user4 = new UserImpl(mediator, "David");
		mediator.addUser(user1);
		mediator.addUser(user2);
		mediator.addUser(user3);
		mediator.addUser(user4);
		user1.send("Hi All");
		
		Thread.sleep(4000);
		System.out.println("\n --1 year later--");
		user3.see();
		
	}
}

interface ChatMediator {
	void sendMessage(String msg, User user);
	void addUser(User user);
	void notifyMsgSeen(User fromuser);
}

class ChatMediatorImpl implements ChatMediator {

	List<User> users;
	
	public ChatMediatorImpl() {
		users=new ArrayList<>();
	}
	
	@Override
	public void sendMessage(String msg, User user) {
		for(User u: users){
			if(u!=user){
				u.receive(msg);
			}
		}
	}

	@Override
	public void addUser(User user) {
		this.users.add(user);
	}

	@Override
	public void notifyMsgSeen(User fromuser) {
		for(User u: users){
			if(u!=fromuser){
				u.getSeenNotification(fromuser.name + "has seen!");
			}
		}
	}
	
}

abstract class User {
	protected ChatMediator mediator;
	protected String name;
	
	public User(ChatMediator med, String name){
		this.mediator=med;
		this.name=name;
		}

	
	public abstract void send(String msg);
	public abstract void receive(String msg);
	public abstract void see();
	public abstract void getSeenNotification(String msg);
}

class UserImpl extends User {
	
	public UserImpl(ChatMediator med, String name) {
		super(med, name);
	}

	@Override
	public void send(String msg) {
		System.out.println(name +" sent:"+ msg );
		mediator.sendMessage(msg, this);
	}

	@Override
	public void receive(String msg) {
		System.out.println(name +" received:"+ msg );
	}

	@Override
	public void see() {
		System.out.println(name+" read the message");
		mediator.notifyMsgSeen(this);
	}

	@Override
	public void getSeenNotification(String msg) {
		System.out.println(msg);
	}
	
}
