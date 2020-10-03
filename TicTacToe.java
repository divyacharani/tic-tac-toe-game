package com.bridgelabz.tictactoe;

public class TicTacToe {

	public static void main(String[] args) {
		// Welcome Message
		System.out.println("Welcome to Tic Tac Toe game");
		char board[] = createBoard();
	}

	// Method to create board
	private static char[] createBoard() {
		char[] board = new char[10];
		for (int index = 1; index < board.length; index++)
			board[index] = ' ';
		return board;
	}
}
