package designpatterns.behavioral_patterns.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/**
 * The purpose of a Visitor pattern is to define a new operation without
 * introducing the modifications to an existing object structure. Imagine that
 * (many:many idea)we have a composite object which consists of components. The object’s
 * structure is fixed – we either can’t change it, or we don’t plan to add new
 * types of elements to the structure. Now, how could we add new functionality
 * to our code without modification of existing classes? The Visitor design
 * pattern might be an answer. Simply put, we’ll have to do is to add a function
 * which accepts the visitor class to each element of the structure. That way
 * our components will allow the visitor implementation to “visit” them and
 * perform any required action on that element. In other words, we’ll extract
 * the algorithm which will be applied to the object structure from the classes.
 * Consequently, we’ll make good use of the Open/Closed principle as we won’t
 * modify the code, but we’ll still be able to extend the functionality by
 * providing a new Visitor implementation.
 * 
 */
public class VisitorExample {

	public static void main(String[] args) {
		Visitor v = new ElementVisitor();

		Document d = new Document(generateUuid());
		d.elements.add(new JsonElement(generateUuid()));
		d.elements.add(new JsonElement(generateUuid()));
		d.elements.add(new XmlElement(generateUuid()));

		d.accept(v);
	}

	private static String generateUuid() {
		return UUID.randomUUID().toString();
	}
}

abstract class Element {
	public String uuid;

	public Element(String uuid) {
		this.uuid = uuid;
	}

	public abstract void accept(Visitor v);
}
/*
 * Our example will be custom Document object that consists of JSON and XML
 * concrete elements; the elements have a common abstract superclass, the
 * Element.
 */class Document extends Element {
	List<Element> elements = new ArrayList<>();

	public Document(String uuid) {
		super(uuid);
	}

	@Override
	public void accept(Visitor v) {
		this.elements.forEach(e -> e.accept(v));
	}
}

class XmlElement extends Element {
	public XmlElement(String uuid) {
		super(uuid);
	}

	public void accept(Visitor v) {
		v.visit(this);
	}
}

class JsonElement extends Element {
	public JsonElement(String uuid) {
		super(uuid);
	}

	public void accept(Visitor v) {
		v.visit(this);
	}
}

interface Visitor {
	void visit(XmlElement xe);
	void visit(JsonElement xe);
}

class ElementVisitor implements Visitor {

	@Override
	public void visit(XmlElement xe) {
		System.out.println("processing xml element with uuid: " + xe.uuid);
	}

	@Override
	public void visit(JsonElement je) {
		System.out.println("processing json element with uuid: " + je.uuid);
	}
}