package project;

public class Calculator {
	
	private IStack<Float> myStack;
	
	public Calculator() {
		
	}
	
	//operations
	public float Add(float number1, float number2) {
		float r = number1 + number2;
		return r;
	}
	public float Substraction(float number1, float number2) {
		float r = number1 - number2;
		return r;
	}
	public float Multiply(float number1, float number2) {
		float r = number1 * number2;
		return r;
	}
	public float Divition(float number1, float number2) {
		float r = number1 / number2;
		return r;
	}
}
