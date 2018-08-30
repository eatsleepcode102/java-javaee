package designpatterns.behavioral_patterns;

public class ChainOfResponsibilityTest {
	public static void main(String[] args) {
		DispenseChain dollar50=new Dollar50Dispenser();
		DispenseChain dollar20=new Dollar20Dispenser();
		DispenseChain dollar10=new Dollar10Dispenser();
		dollar50.setNextChain(dollar20);
		dollar20.setNextChain(dollar10);
		
		Currency cur=new Currency(136);
		dollar50.dispense(cur);
		
	}
}

class Currency {
	int amount;

	public Currency(int amount) {
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}
}

interface DispenseChain {
	void setNextChain(DispenseChain nextChain);
	void dispense(Currency cur);
}

class Dollar50Dispenser implements DispenseChain {

	private DispenseChain chain;
	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.chain=nextChain;
	}

	@Override
	public void dispense(Currency cur) {
		if(cur.getAmount()>= 50){
			int num=cur.getAmount()/50;
			int remainder=cur.getAmount()% 50;
			System.out.println("depensing +"+num +" 50$ note");
			if(remainder!=0){
				this.chain.dispense(new Currency(remainder));
			}
		} else {
			this.chain.dispense(cur);
		}
		
	}
}

class Dollar20Dispenser implements DispenseChain {

	private DispenseChain chain;
	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.chain=nextChain;
	}

	@Override
	public void dispense(Currency cur) {
		if(cur.getAmount()>= 20){
			int num=cur.getAmount()/20;
			int remainder=cur.getAmount()% 20;
			System.out.println("depensing +"+num +" 20$ note");
			if(remainder!=0){
				this.chain.dispense(new Currency(remainder));
			}
		} else {
			this.chain.dispense(cur);
		}
		
	}
}

class Dollar10Dispenser implements DispenseChain {

	private DispenseChain chain;
	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.chain=nextChain;
	}

	@Override
	public void dispense(Currency cur) {
		if(cur.getAmount()>= 10){
			int num=cur.getAmount()/10;
			int remainder=cur.getAmount()% 10;
			System.out.println("depensing +"+num +" 10$ note");
			if(remainder!=0){
//				this.chain.dispense(new Currency(remainder));
				System.out.println("remaining "+remainder +"$'");
				
			}
		} else {
			this.chain.dispense(cur);
		}
		
	}
}