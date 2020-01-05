import java.util.HashMap;
import java.util.Map;

public class Expression {

	private char op;

	private Expression left;

	private Expression right;

	private int constant;
	
	private Map<Character, IOperation> map;
	
	{
		map = new HashMap<>();
		map.put('c', () -> constant);
		map.put('+', () -> left.evaluate() + right.evaluate());
		map.put('-', () -> left.evaluate() - right.evaluate());
		map.put('/', () -> left.evaluate() / right.evaluate());
		map.put('*', () -> left.evaluate() * right.evaluate());
	}
	

	public Expression(int constant) {
		this.op = 'c';
		this.constant = constant;
	}

	public Expression(char op, Expression left, Expression right) {
		this.op = op;
		this.left = left;
		this.right = right;
	}
	
	
	 // I replaced switch case with Map, easier and more clear.
	 
	public int evaluate() {
		return map.get(op).calculate();
	}
	
	
/*
	public int evaluate() {
		switch (op) {
		case 'c':
			return constant;
		case '+':
			return left.evaluate() + right.evaluate();
		case '-':
			return left.evaluate() - right.evaluate();
		case '*':
			return left.evaluate() * right.evaluate();
		case '/':
			return left.evaluate() / right.evaluate();
		default:
			throw new IllegalStateException();
		}
	}
	*/
}
