package designpatterns.behavioral_patterns;

import java.util.ArrayList;
import java.util.List;

public class VisitorTest {

	public static void main(String[] args) {
		List<ItemElement> items=new ArrayList<>();
		items.add(new Book(20, "AAA"));
		items.add(new Book(100, "BBB"));
		items.add(new Fruit(2,10, "Banana"));
		items.add(new Fruit(5,5, "Apple"));

		int total=calculatePrice(items);
		System.out.println("Total cost ="+ total);
	}
	
	private static int calculatePrice (List<ItemElement> items){
		ShoppingCartVisitor visitor=new ShoppingCartVisitorImpl();
		int sum=0;
		for (ItemElement itemElement : items) {
			sum=sum +itemElement.accept(visitor);
		}
		return sum;
	}

}

interface ShoppingCartVisitor {
	int visit(Book book);
	int visit(Fruit fruit);
}

class ShoppingCartVisitorImpl implements ShoppingCartVisitor {

	@Override
	public int visit(Book book) {
		int cost=0;
		if(book.getPrice() > 50){
			cost = book.getPrice() -5;
		} else {
			cost=book.getPrice();
		}
		System.out.println("Book::"+book.getName() + " cost="+cost);
		return cost;
	}

	@Override
	public int visit(Fruit fruit) {
		int cost = fruit.getPricePerKg()*fruit.getWeight();
		System.out.println(fruit.getName() + " cost = "+cost);
		return cost;
	}
	
}

interface ItemElement {
	int accept(ShoppingCartVisitor visitor);
}

class Book implements ItemElement{

	private int price;
	private String name;
	
	public Book(int price, String name) {
		this.price = price;
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	@Override
	public int accept(ShoppingCartVisitor visitor) {
		return visitor.visit(this);
	}
	
}

class Fruit implements ItemElement{

	private int pricePerKg;
	private int weight;
	private String name;
	
	public Fruit(int pricePerKg, int weight, String name) {
		this.pricePerKg = pricePerKg;
		this.weight = weight;
		this.name = name;
	}

	public int getPricePerKg() {
		return pricePerKg;
	}

	public int getWeight() {
		return weight;
	}

	public String getName() {
		return name;
	}

	@Override
	public int accept(ShoppingCartVisitor visitor) {
		return visitor.visit(this);
	}
	
}