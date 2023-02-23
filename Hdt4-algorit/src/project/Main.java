package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.Stack.*;

public class Main {

	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		Calculator myCalculator = null;
		System.out.println("+-----------------------------+");
		System.out.println("| Bienvenido a su Calculadora |");
		System.out.println("+-----------------------------+");
		System.out.println();
		System.out.println("Seleccione el tipo de Stack que desea: \n 1.ArrayList \n 2.Vecto \n 3.Linked List \n 4.Double Linked List \n");
		int option = tec.nextInt();
		String data = "";
		
		System.out.println();
		System.out.println("Ingreso en Infix:");
		try {
			File myFile = new File("datos.txt");
			Scanner myReader = new Scanner(myFile);
			while (myReader.hasNextLine()) {
		        data = myReader.nextLine();
		      }
			myReader.close();
			
		} catch (FileNotFoundException  e) {
			System.out.println("An error occurred.");
		      e.printStackTrace();
		}
		System.out.println(data);
		System.out.println();
		System.out.println("Su expresion posfix es:");
		System.out.println(data);
		ArrayList<String> ListOfCharacters = new ArrayList<String>(Arrays.asList(data.split(" ")));
		myCalculator.setListOfCharacters(ListOfCharacters);
		
		String r = myCalculator.calculate();
		System.out.println(r);

	}
	
	//methods to convert from infix to posfix
	static int precedence(char character)
    {
        switch (character)
        {
            case '+':
            	return 1;
            case '-':
                return 1;

            case '*':
                return 2;
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }
	
	static boolean IsOperand(char ch)
    {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }
	
	 static void covertInfixToPostfix(String InfixExpresion) {
		 Stack ToPosfix = new Stack<>();
		 StringBuilder result = new StringBuilder(new String(""));
		 
		 for(int i = 0 ; i < InfixExpresion.length() ; i++) {
			 if(IsOperand(InfixExpresion.charAt(i))) {
				 result.append(InfixExpresion.charAt(i));
			 }
			 else if(InfixExpresion.charAt(i) == '(') {
				 ToPosfix.push(InfixExpresion.charAt(i));
			 }
			 else if(InfixExpresion.charAt(i) == ')') {
				 while(!ToPosfix.empty() && ToPosfix.peek().equals('(')) {
					 result.append(ToPosfix.peek());
				 }
				 if(!InfixExpresion.isEmpty() && ToPosfix.peek().equals('(')) {
					 return;
				 }
				 else {
					 InfixExpresion.pop();
				 }
			 }
			 
		 }
	 }
}
