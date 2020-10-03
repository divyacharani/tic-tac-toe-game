package com.bridgelabz.tictactoe;

import java.util.Scanner;

public class TicTacToe {
	static Scanner sc = new Scanner(System.in);
	private static char userLetter;
	private static char computerLetter;

	public static void main(String[] args) {
		// Welcome Message
		System.out.println("Welcome to Tic Tac Toe game");
		char board[] = createBoard();
		userLetter = chooseLetter();
		computerLetter = (userLetter == 'X') ? 'O' : 'X';
		showBoard(board);
		board = makeMove(getMove(board), board, userLetter);
	}

	// Method to create board
	private static char[] createBoard() {
		char[] board = new char[10];
		for (int index = 1; index < board.length; index++)
			board[index] = ' ';
		return board;
	}

	// Method to choose a letter
	private static char chooseLetter() {
		char letter = ' ';
		while (true) {
			System.out.println("Choose a letter 'X' or 'O' ");
			letter = sc.next().toUpperCase().charAt(0);
			if (letter == 'X' || letter == 'O')
				break;
			else
				System.out.println("Invalid Entry!! Choose a letter 'X or 'O'");
		}
		return letter;
	}

	// Method to show board
	private static void showBoard(char[] board) {
		System.out.println("Current Board: ");
		System.out.println(board[1] + " | " + board[2] + " | " + board[3]);
		System.out.println("----------");
		System.out.println(board[4] + " | " + board[5] + " | " + board[6]);
		System.out.println("----------");
		System.out.println(board[7] + " | " + board[8] + " | " + board[9]);
	}

	// Method to getMove
	private static int getMove(char[] board) {
		int index;
		while (true) {
			System.out.println("Select the index from 1 to 9");
			index = sc.nextInt();
			if (index <= 0 || index > 9)
				System.out.println("Invalid!! Enter between 1 to 9");
			else if (isFree(board, index)) {
				break;
			} else
				System.out.println("Position is occupied!! Enter another index");
		}
		return index;
	}

	// Method to check board is free
	private static boolean isFree(char[] board, int index) {
		return (board[index] == ' ');
	}

	// Method to make move
	private static char[] makeMove(int index, char[] board, char letter) {
		board[index] = letter;
		showBoard(board);
		return board;
	}

}
