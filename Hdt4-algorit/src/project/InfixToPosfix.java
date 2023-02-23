package project;

import java.io.*;

public class InfixToPosfix {
	static myStack operators = new myStack();         
	public static void main(String argv[]) throws IOException  
	{  
		String infix;  
		//create an input stream object  
		BufferedReader keyboard = new BufferedReader (new InputStreamReader(System.in));  
		//get input from user  
		System.out.print("\nEnter the infix expression you want to convert: ");  
		infix = keyboard.readLine();  
		//output as postfix  
		System.out.println("Postfix expression for the given infix expression is:" + toPostfix(infix));  
		}  
	
	private static String toPostfix(String infix)  
	{  
			
		char symbol;  
		String postfix = "";  
		for(int i=0;i<infix.length();++i){  
			symbol = infix.charAt(i);  
			if (Character.isLetter(symbol))  
				postfix = postfix + symbol;  
			else if (symbol=='('){  
				operators.push(symbol);  
			}  
			else if (symbol==')'){  
				while (operators.peek() != '('){  
					postfix = postfix + operators.pop();  
				}  
			
				operators.pop();  
			}  
			else{  
				while (!operators.isEmpty() && !(operators.peek()=='(') && prec(symbol) <= prec(operators.peek()))  
				postfix = postfix + operators.pop();  
				operators.push(symbol);  
			}  
		}  
		
		while (!operators.isEmpty())  
			postfix = postfix + operators.pop();  
		return postfix;  
	} 
	
	static int prec(char x)  
	{  
		if (x == '+' || x == '-')  
			return 1;  
		if (x == '*' || x == '/' || x == '%')  
			return 2;  
		return 0;  
	}  
}
