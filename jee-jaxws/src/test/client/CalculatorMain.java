package test.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import test.calculator_endpoint.Calculator;

public class CalculatorMain {

	public static void main(String[] args) throws MalformedURLException {
//		URL url = new URL("http://localhost:8080/jaxws-endpoint/EBookStoreImplService?wsdl");
//		QName qname = new QName("http://jaxws_endpoint/", "EBookStoreImplService");
//		Service service = Service.create(url, qname);
//		EBookStore eBookStore = service.getPort(EBookStore.class);
//		System.out.println(eBookStore.welcomeMessage("Andrew"));
//		 EBook eBook = new EBook();
//	        eBook.setTitle("The Jungle Book");
//	        eBook.setNumPages(225);
//	        eBook.setPrice(17.9);
//	        eBookStore.saveBook(eBook);
//	        eBook = new EBook();
//
//	        eBook.setTitle("Animal Farm");
//	        eBook.setNumPages(113);
//	        eBook.setPrice(22.5);
//	        List<String> notes = Arrays.asList(new String[] { "Great book", "Not too bad" });
//	        eBook.getNotes().addAll(notes);
//	        eBookStore.saveBook(eBook);
//	        
//	        EBook response = eBookStore.takeBook("Animal Farm");
//	        System.out.println(response);
	        
			Service calservice = Service.create(new URL("http://localhost:8080/jee-jaxws/CalculatorImplService?wsdl"),
					new QName("http://calculator_endpoint.test/", "CalculatorImplService"));
	        Calculator calculator=calservice.getPort(Calculator.class);
	        System.out.println("result of add():"+calculator.add(2, 5));
	}
}