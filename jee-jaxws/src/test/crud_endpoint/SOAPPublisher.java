package test.crud_endpoint;


import javax.xml.ws.Endpoint;

public class SOAPPublisher {

	public static void main(String[] args) {
		 Endpoint.publish("http://localhost:8080/ws/person", new PersonServiceImpl());  
		 System.out.println("endpoint is published...");
	}

}
