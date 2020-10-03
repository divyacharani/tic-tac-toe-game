package com.bridgelabz.tictactoe;

import java.util.Scanner;

public class TicTacToe {
	static Scanner sc = new Scanner(System.in);
	private static char userLetter;
	private static char computerLetter;
	private static boolean isPlayerTurn = false;

	public static void main(String[] args) {
		// Welcome Message
		System.out.println("Welcome to Tic Tac Toe game");
		char board[] = createBoard();
		userLetter = chooseLetter();
		computerLetter = (userLetter == 'X') ? 'O' : 'X';
		doToss();
		showBoard(board);
		board = makeMove(getMove(board), board, userLetter);
		changeTurn(board);		
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

	// Method to do a toss
	private static void doToss() {
		int turn = (int) ((Math.random() * 10) % 2);
		if (turn == 0) {
			isPlayerTurn = true;
			System.out.println("User turn");
		}
		else
			System.out.println("Computer turn");
	}

	// Method to check win
	private static boolean isWin(char[] board) {
		if ((board[1] == board[2] && board[2] == board[3] && board[1]!=' ') || (board[4] == board[5] && board[5] == board[6] && board[4]!=' ')
				|| (board[7] == board[8] && board[8] == board[9] && board[7]!=' ') || (board[1] == board[4] && board[4] == board[7] && board[1]!=' ')
				|| (board[2] == board[5] && board[5] == board[8] && board[2]!=' ') || (board[3] == board[6] && board[6] == board[9] && board[3]!=' ')
				|| (board[1] == board[5] && board[5] == board[9] && board[1]!=' ') || (board[3] == board[5] && board[5] == board[7] && board[3]!=' '))
			return true;
		else
			return false;
	}
	
	//Method to check if board is full
	private static boolean isFull(char[] board) {
		for (int index = 1; index < board.length; index++) {
			if(board[index]==' ')
				return false;
		}
		return true;
	}
	
	//Method to check Draw
	private static boolean isDraw(char[] board) {
		return (isFull(board) && !isWin(board));

	}
	
	//Method to check win or draw after every move and change turn
	private static void changeTurn(char[] board) {
		if(!(isWin(board)) && !(isDraw(board)))
			isPlayerTurn = !isPlayerTurn;
		else if(isWin(board) && isPlayerTurn == false)
			System.out.println("Computer Won!!");
		else if(isWin(board) && isPlayerTurn == true)
			System.out.println("You Won!!");
		else if(isDraw(board))
			System.out.println("It's a Draw!!");
	}
	

}
