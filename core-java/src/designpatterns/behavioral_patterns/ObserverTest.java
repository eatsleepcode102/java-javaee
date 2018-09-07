package designpatterns.behavioral_patterns;

import java.util.ArrayList;
import java.util.List;

public class ObserverTest {

	public static void main(String[] args) {
		MyTopic topic=new MyTopic();
		Observer andrew=new MyTopicSubcriber("Andrew");
		Observer kai=new MyTopicSubcriber("Kai");
		Observer leo=new MyTopicSubcriber("Leo");
		
		topic.register(andrew);
		topic.register(kai);
		topic.register(leo);
		
		andrew.setSubject(topic);
		kai.setSubject(topic);
		leo.setSubject(topic);
		
		topic.postMessage("Hi, how are you?");
		andrew.update();
	}
}

interface Subject {
	public void register(Observer obj);
	public void unregister(Object obj);
	public void notifyObservers();
	public Object getUpdate();
}

class MyTopic implements Subject {
	
	private List<Observer> observers;
	private String message;
	private boolean changed;
	
	public MyTopic() {
		this.observers = new ArrayList<Observer>();
	}

	@Override
	public void register(Observer obj) {
		if(!observers.contains(obj)) {
			observers.add(obj);
		}
	}

	@Override
	public void unregister(Object obj) {
		observers.remove(obj);
	}

	@Override
	public void notifyObservers() {
		List<Observer> observerLocal=null;
		if(!changed) {
			return;
		}
		observerLocal=new ArrayList<>(this.observers);
		this.changed=false;
		for(Observer obj: observerLocal){
			obj.update();
		}
	}

	@Override
	public Object getUpdate() {
		return this.message;
	}
	
	public void postMessage(String msg){
		System.out.println("Message Posted to Topic:"+msg);
		this.message=msg;
		this.changed=true;
		notifyObservers();
	}
}

interface Observer {
	public void update();
	public void setSubject(Subject sub);
}

class MyTopicSubcriber implements Observer {

	private String name;
	private Subject topic;
	
	public MyTopicSubcriber(String name) {
		this.name = name;
	}

	@Override
	public void update() {
		String msg=(String) topic.getUpdate();
		if(msg==null){
			System.out.println(name+":: No new message");
		} else {
			System.out.println(name+"::consuming message::"+msg);
		}
	}

	@Override
	public void setSubject(Subject sub) {
		this.topic=sub;
	}
	
}