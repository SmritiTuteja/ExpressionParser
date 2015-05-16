package com.smriti.expparser;

import java.util.Scanner;
import java.util.Stack;

public class ExpressionParser {

	public static void main(String[] args) {

		// take input expression
		Scanner read = new Scanner(System.in);
		System.out.println("Enter an expression : ");
		String expression = read.nextLine();

		// print result
		boolean result = checkExpression(expression);
		System.out.println("\nResult : " + result);
	}

	public static boolean checkExpression(String ex) {

		// declare stack character
		Stack<Character> schar = new Stack<Character>();
		int l = ex.length();
		char ch = ' ';

		// run loop on input
		for (int i = 0; i < l; i++) {
			ch = ex.charAt(i);

			if (ch == '(' || ch == '[') {
				schar.push(ch);
			} else if (ch == ')' && !schar.empty()) {
				if (schar.peek() == '(') {
					schar.pop();
				}
			} else if (ch == ']' && !schar.empty()) {
				if (schar.peek() == '[') {
					schar.pop();
				}
			} else if (ch == ')' || ch == ']') {
				return false;
			}
		}

		if (!schar.empty()) {
			return false;
		} else {
			return true;
		}
	}
}
