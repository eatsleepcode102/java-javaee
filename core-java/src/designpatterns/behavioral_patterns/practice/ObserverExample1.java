package designpatterns.behavioral_patterns.practice;

import java.util.Observable;
import java.util.Observer;

public class ObserverExample1 {

	public static void main(String[] args) {
		ONewsAgency observable = new ONewsAgency();
		ONewsChannel observer = new ONewsChannel();

		observable.addObserver(observer);
		observable.setNews(
				"Andrew is special person who just got 1 billion dollar");

	}

}
/*
 * Note that we don’t need to call the observer’s update() method directly. We
 * just call stateChanged() and notifyObservers(), and the Observable class is
 * doing the rest for us.
 */
class ONewsAgency extends Observable {
	private String news;

	public void setNews(String news) {
		this.news = news;
		setChanged();
		notifyObservers(news);
	}
}

/*
 * The java.util.Observer interface defines the update() method, so there’s no
 * need to define it ourselves as we did in the previous section.
 */
class ONewsChannel implements Observer {

	private String news;

	@Override
	public void update(Observable o, Object news) {
		this.news = (String) news;
		System.out.println(
				ONewsChannel.class.getSimpleName() + "'s news:" + news);
	}
}