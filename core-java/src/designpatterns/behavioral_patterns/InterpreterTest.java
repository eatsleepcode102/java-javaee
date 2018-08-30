package designpatterns.behavioral_patterns;

public class InterpreterTest {

	public static void main(String[] args) {
		InterpreterContext ic=new InterpreterContext();
		Expression ex=new IntToBinaryExpression(10);
		String result= ex.interpret(ic);
		System.out.println(result);
	}
}

class InterpreterContext {
	public String getBinaryFormat(int i){
		return Integer.toBinaryString(i);
	}
	
	public String getHexadecimalFormat(int i){
		return Integer.toHexString(i);
	}
}

interface Expression {
	String interpret(InterpreterContext ic);
}

class IntToBinaryExpression implements Expression {

	int i;
	
	public IntToBinaryExpression(int i) {
		this.i = i;
	}

	@Override
	public String interpret(InterpreterContext ic) {
		return ic.getBinaryFormat(i);
	}
}
class IntToHexExpression implements Expression {

	int i;
	
	public IntToHexExpression(int i) {
		this.i = i;
	}

	@Override
	public String interpret(InterpreterContext ic) {
		return ic.getHexadecimalFormat(i);
	}
}