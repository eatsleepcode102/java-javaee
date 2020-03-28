package example.ebookstore.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import example.ebookstore.endpoint.EBook;
import example.ebookstore.endpoint.EBookStore;

public class EBookStoreClient {

	public static void main(String[] args) throws MalformedURLException {
	            Service bookStoreService = Service.create(new URL("http://localhost:8080/ws/ebookstore?wsdl"),
						new QName("http://endpoint.ebookstore.example/", "EBookStoreImplService"));
		        EBookStore eBookStore=(EBookStore) bookStoreService.getPort(EBookStore.class);
		        
		        System.out.println(eBookStore.welcomeMessage("Andwrew"));
		        
		        EBook eBook = new EBook();
		        eBook.setTitle("The Jungle Book");
		        eBook.setNumPages(225);
		        eBook.setPrice(17.9);
		        eBookStore.saveBook(eBook);
		        eBook = new EBook();

		        eBook.setTitle("Animal Farm");
		        eBook.setNumPages(113);
		        eBook.setPrice(22.5);
		        List<String> notes = Arrays.asList(new String[] { "Great book", "Not too bad" });
		        eBook.getNotes().addAll(notes);
		        eBookStore.saveBook(eBook);

		        EBook response = eBookStore.takeBook("Animal Farm");
		        System.out.println("testing result:");
		        System.out.println(response.getNumPages());
		        System.out.println(response.getPrice());
		        System.out.println(response.getTitle());
		        System.out.println(response.getNotes());
		        

	}
	
	
}
