package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.Stack.*;
import java.io.*;  

public class Main {

	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		Calculator myCalculator;
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
		System.out.println("--------------");
		String newData = InfixToPostfix(data);
		System.out.println("Su expresion posfix es:");
		System.out.println(data);
		ArrayList<String> ListOfCharacters = new ArrayList<String>(Arrays.asList(newData.split("")));
		myCalculator = new Calculator(option, ListOfCharacters);
		
		String r = myCalculator.calculate();
		System.out.println(r);

	}
	
	//process to change from infix to postfix
	static String InfixToPostfix(String expr) {
        int i;
        Stack  ToPosfix = new Stack<>();
        StringBuilder result = new StringBuilder(new String(""));

        for (i = 0; i < expr.length(); ++i){
            if (IsOperand(expr.charAt(i)))
                result.append(expr.charAt(i));

            else if (expr.charAt(i) == '(')
            	ToPosfix.push(expr.charAt(i));

            else if (expr.charAt(i) == ')'){
                while (!ToPosfix.empty() && ToPosfix.peek().equals('(')){
                    result.append(ToPosfix.peek());
                    ToPosfix.pop();
                }
                if (!ToPosfix.empty() && ToPosfix.peek().equals('('))
                    return ""; 
                else
                	ToPosfix.pop();
            }
            else{
                while (!ToPosfix.empty() && precedence(expr.charAt(i)) <= precedence((char) ToPosfix.peek())){
                    result.append(ToPosfix.peek());
                    ToPosfix.pop();
                }
                ToPosfix.push(expr.charAt(i));
            }

        }

        while (!ToPosfix.empty()){
            result.append(ToPosfix);
            ToPosfix.pop();
        }
        System.out.println(result);
        return result.toString();
    }

    static int precedence(char ch){
        switch (ch){
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
    

	static boolean IsOperand(char ch){
		return (ch >= '0' && ch <= '9');
	}
	
}
