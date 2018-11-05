package corejava.xml.dompaser;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreateXMLFileDemo {

	public static void main(String[] args) throws ParserConfigurationException, TransformerException {
		// TODO Auto-generated method stub
		DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder=dbFactory.newDocumentBuilder();
		Document doc=dBuilder.newDocument();
		//root element
		Element rootElement =doc.createElement("cars");
		doc.appendChild(rootElement);
		
		//supercars element
		Element supercar=doc.createElement("supercars");
		rootElement.appendChild(supercar);
		//setting attribute to element
		Attr attr=doc.createAttribute("company");
		attr.setValue("Ferrari");
		supercar.setAttributeNode(attr);
		
		//carname element
		Element carname=doc.createElement("carname");
		Attr attrType=doc.createAttribute("type");
		attrType.setValue("formula one");
		carname.setAttributeNode(attrType);
		carname.appendChild(doc.createTextNode("ferrari 101"));
		supercar.appendChild(carname);
		
		Element carname1=doc.createElement("carname");
		Attr attrType1=doc.createAttribute("type");
		attrType1.setValue("sport");
		carname1.setAttributeNode(attrType1);
		carname1.appendChild(doc.createTextNode("ferrari 102"));
		supercar.appendChild(carname1);
		
		//write the content into xml file
		TransformerFactory transformerFactory=TransformerFactory.newInstance();
		Transformer transformer=transformerFactory.newTransformer();
		DOMSource source=new DOMSource(doc);
		StreamResult result=new StreamResult(new File("src\\corejava\\xml\\dompaser\\newcars.xml"));
		transformer.transform(source, result);
		
		//output to console for testing
		StreamResult consoleResult = new StreamResult(System.out);
        transformer.transform(source, consoleResult);
	}

}
