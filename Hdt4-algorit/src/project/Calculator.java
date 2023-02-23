package project;

import java.util.*;

public class Calculator {
	private IStack<Float> listOfNumbers;
	private IStack<String> listOfCharacters;
	
	private static Calculator instance;
	
	public Calculator(int option, IStack<String> listOfCharacters) {
		listOfNumbers = Factory.getInstance().getStack(option);
		this.listOfCharacters = listOfCharacters;
	}
	
	public static Calculator getInstance(int option, IStack<String> listOfCharacters) {
		if(instance == null) {
			instance = new Calculator(option, listOfCharacters);
		}
		return instance;
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

	
	public IStack<Float> getListOfNumbers() {
		return listOfNumbers;
	}

	public void setListOfNumbers(IStack<Float> listOfNumbers) {
		this.listOfNumbers = listOfNumbers;
	}

	public IStack<String> getListOfCharacters() {
		return listOfCharacters;
	}

	public void setListOfCharacters(IStack<String> listOfCharacters) {
		this.listOfCharacters = listOfCharacters;
	}
	public String calculate() {
		int pos = 0;
		String r = "";
		while(pos < listOfCharacters.Size()) {
			if(listOfCharacters.GetValue(pos).equals("+")) {
				float b = listOfNumbers.Pop();
				float a = listOfNumbers.Pop();
				float c = Add(a, b);
				listOfNumbers.Push(c);
			}
			else if(listOfCharacters.GetValue(pos).equals("-")) {
				float b = (float) listOfNumbers.Pop();
				float a = (float) listOfNumbers.Pop();
				listOfNumbers.Push(Substraction(a, b));
			}
			else if(listOfCharacters.GetValue(pos).equals("*")) {
				float b = (float) listOfNumbers.Pop();
				float a = (float) listOfNumbers.Pop();
				listOfNumbers.Push(Multiply(a, b));
			}
			else if(listOfCharacters.GetValue(pos).equals("/")) {
				float b = (float) listOfNumbers.Pop();
				float a = (float) listOfNumbers.Pop();
				listOfNumbers.Push(Divition(a, b));
			}
			else if(Character.isDigit(listOfCharacters.GetValue(pos).charAt(0))){
				listOfNumbers.Push(Float.parseFloat(listOfCharacters.GetValue(pos)));
            }
			pos = pos + 1;
		}
		if(r.equals("")) {
			if(listOfNumbers.Size() < 1) {
				r = "Faltaron " + (listOfNumbers.Size()-1) + "operadores";
			}
			else {
				r = "La respuesta es " + listOfNumbers.GetValue(0);
			}
		}
		return r;
	}
}
