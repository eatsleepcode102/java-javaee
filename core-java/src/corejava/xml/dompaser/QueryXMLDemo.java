package corejava.xml.dompaser;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class QueryXMLDemo {

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		// TODO Auto-generated method stub
		File inputFile = new File("src\\corejava\\xml\\dompaser\\cars.xml");
		DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder=dbFactory.newDocumentBuilder();
		Document doc=dBuilder.parse(inputFile);
		doc.getDocumentElement().normalize();
		System.out.println("Root element:");
		System.out.println(doc.getDocumentElement().getNodeName());
		NodeList nList=doc.getElementsByTagName("supercars");
		System.out.println("----------------------");
		for(int temp=0; temp< nList.getLength(); temp++) {
			Node nNode=nList.item(temp);
			System.out.println("\nCurrent Element:");
			System.out.println(nNode.getNodeName());
			
			if(nNode.getNodeType()==Node.ELEMENT_NODE) {
				Element eElement=(Element) nNode;
				System.out.println("company:"+ eElement.getAttribute("company"));
				NodeList carNameList=eElement.getElementsByTagName("carname");
				for(int count=0; count < carNameList.getLength(); count ++) {
					Node node1=carNameList.item(count);
					if(node1.getNodeType()==node1.ELEMENT_NODE) {
						Element car=(Element) node1;
						System.out.println("car name:"+ car.getTextContent());
						System.out.println("car type:"+ car.getAttribute("type"));
					}
				}
			}
		}
	}

}
