package com.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Stack;

public class Try {

	public boolean check(String input) {
		Stack<Character> theStack = new Stack<Character>();
		boolean result = true;
		for (int j = 0; j < input.length(); j++) {
			char ch = input.charAt(j);
			switch (ch) {
			case '{':
			case '[':
			case '(':
				theStack.push(ch);
				break;
			case '}':
			case ']':
			case ')':
				if (!theStack.isEmpty()) {// {{]}
					char chx = theStack.pop();
					if ((ch == '}' && chx != '{') || (ch == ']' && chx != '[') || (ch == ')' && chx != '('))
						result = false;
				} else
					result = false;
				break;
			default:
				break;
			}
		}
		if (!theStack.isEmpty()) {
			result = false;
		}
		return result;
	}

	public int factorialNormal(int n) {
		if (n == 0)
			return 1;
		else
			return (n * factorialNormal(n - 1));
	}

	public int factorialBigInt(BigInteger number) {
		int fact = 1;
		for (int j = 2; j <= number.longValue(); j++) {
			fact = fact * j;
		}
		return fact;
	}

	public int fibonacciIterator(int number) {
		if (number == 1 || number == 2) {
			return 1;
		}
		int fibo1 = 1, fibo2 = 1, fibonacci = 1;
		for (int i = 3; i <= number; i++) {
			fibonacci = fibo1 + fibo2;
			fibo1 = fibo2;
			fibo2 = fibonacci;

		}
		return fibonacci;
	}

	public String fibonacciIteratorLoop(int count) {
		String result = "";
		for (int i = 1; i <= count; i++) {
			result += "" + fibonacciIterator(i);
		}
		return result;
	}

	public int fibonacciRecursive(int num) {
		if (num == 0) {
			return 0;
		}
		if (num == 1) {
			return 1;
		}
		return fibonacciRecursive(num - 1) + fibonacciRecursive(num - 2);
	}

	public String fibonacciRecursiveLoop(int count) {
		String result = "";
		for (int i = 1; i <= count; i++) {
			result += "" + fibonacciRecursive(i);
		}
		return result;
	}

	public String fizzBuzz(int input) {
		String result = "";
		int count = 1;
		boolean check = false;
		while (count <= input) {
			if (count % 3 == 0 && count % 5 == 0) {
				result += "FizzBuzz";
				check = true;
			}
			if (!check && count % 3 == 0) {
				result += "Fizz";
				check = true;
			}
			if (!check && count % 5 == 0) {
				result += "Buzz";
				check = true;
			}
			if (!check) {
				result += "" + count;
			}
			count++;
			check = false;
		}
		return result;
	}

	public void stairCase(int n) {
		int count;
		int temp = n;
		for (int i = 1; i <= n; i++) {
			count = i;
			temp = temp - i;
			while (temp > 0) {
				System.out.print(" ");
				temp--;
			}
			while (count > 0) {
				System.out.print("#");
				count--;
			}
			System.out.println();
			temp = n;
		}

	}

	public String generateLeetSpeak(String leetSpeakInPut) {
		String leetSpeakOutPut = "";
		for (int index = 0; index < leetSpeakInPut.length(); index++) {
			switch (leetSpeakInPut.charAt(index)) {
			case 'a':
			case 'A':
				leetSpeakOutPut += "4";
				break;
			case 'e':
			case 'E':
				leetSpeakOutPut += "3";
				break;
			case 'i':
			case 'I':
				leetSpeakOutPut += "1";
				break;
			case 'o':
			case 'O':
				leetSpeakOutPut += "0";
				break;
			case 's':
			case 'S':
				leetSpeakOutPut += "5";
				break;
			case 't':
			case 'T':
				leetSpeakOutPut += "7";
				break;
			default:
				leetSpeakOutPut += leetSpeakInPut.charAt(index);
			}
		}
		return leetSpeakOutPut;
	}

	public class Matrix {
		int matrix1[][], matrix2[][], multi[][];
		int row, column;

		public void main() {
			Matrix m = new Matrix();
			m.read();
			m.addition();
			m.diagonal();
		}

		void diagonal() {
			System.out.println("The diagonal top left to bottom is:");
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					if (i == j) {
						System.out.print("\t" + multi[i][j]);
					}
				}
			}
			System.out.println("");
			System.out.println("The diagonal top right to bottom is:");
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					if (j == column - i - 1) {
						System.out.print("\t" + multi[i][j]);
					}
				}
			}
		}

		void read() {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String line;

				System.out.println("Matrix Multiplication");
				// First Matrix Creation..
				System.out.println("\nEnter number of rows & columns");
				line = br.readLine();
				row = Integer.parseInt(line);
				line = br.readLine();
				column = Integer.parseInt(line);

				matrix1 = new int[row][column];
				matrix2 = new int[row][column];
				multi = new int[row][column];
				System.out.println("Enter the data for first matrix :");

				for (int i = 0; i < row; i++) {
					for (int j = 0; j < column; j++) {
						matrix1[i][j] = Integer.parseInt(br.readLine());
					}
				}

				System.out.println("Enter the data for second matrix :");

				for (int i = 0; i < row; i++) {
					for (int j = 0; j < column; j++) {
						matrix2[i][j] = Integer.parseInt(br.readLine());
					}
				}

			} catch (IOException e) {
				System.out.println("Exception!!!!");
			}
		}

		void addition() {
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					multi[i][j] = matrix1[i][j] + matrix2[i][j];
				}
			}
			System.out.println("\n\nThe Division is :");
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					System.out.print("\t" + multi[i][j]);
				}
				System.out.println("");
			}
		}
	}
}
