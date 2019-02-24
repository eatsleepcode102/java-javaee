package designpatterns.behavioral_patterns.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Observer is a behavioral design pattern. It specifies communication between
 * objects: observable and observers. An observable is an object which notifies
 * observers about the changes in its state. For example, a news agency can
 * notify channels when it receives news. Receiving news is what changes the
 * state of the news agency, and it causes the channels to be notified.
 * 
 */
public class ObserverExample {

	public static void main(String[] args) {
		NewsAgency observable = new NewsAgency();
		NewsChannel observer = new NewsChannel();

		observable.addObserver(observer);
		observable.setNews(
				"Andrew is special person who just got 1 billion dollar");

	}
}

/*
 * NewAgency is an observable, and when news get updated, the state of NewAgency
 * changes. When the change happens, NewAgency notifies the observers about this
 * fact by calling their update() method. To be able do that, the Observable
 * object needs to keep references to the observers, and in our case, it's the
 * channels variable
 */
class NewsAgency {
	private String news;
	private List<Channel> channels = new ArrayList<>();

	public void addObserver(Channel channel) {
		this.channels.add(channel);
	}

	public void removeObserver(Channel channel) {
		this.channels.remove(channel);
	}

	public void setNews(String news) {
		this.news = news;
		for (Channel channel : this.channels) {
			// make the channel notified
			channel.update(news);
		}
	}

}

interface Channel {
	public void update(Object o);
}

/*
 * Let's now see how the observer, the Channel class, can look like It should
 * have the update() method which is invoked when the state of NewsAgency
 * changes
 */
class NewsChannel implements Channel {
	private String news;

	@Override
	public void update(Object news) {
		this.news = (String) news;
		System.out
				.println(NewsChannel.class.getSimpleName() + "'s news:" + news);
	}

	public String getNews() {
		return news;
	}

	public void setNews(String news) {
		this.news = news;
	}

}