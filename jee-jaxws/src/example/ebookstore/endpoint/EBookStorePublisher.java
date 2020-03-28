package example.ebookstore.endpoint;

import javax.xml.ws.Endpoint;

public class EBookStorePublisher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Endpoint.publish("http://localhost:8080/ws/ebookstore", new EBookStoreImpl());
		System.out.println("Ebookstore endpoint is published...");
	}

}
