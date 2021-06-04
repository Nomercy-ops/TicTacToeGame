package com.bridgelabz;
import java.util.Scanner;

class TicTacToeGame {

    static char gameBoard[] = new char[10];
	static char player = ' ';
    static char computer = ' ';
	
    public static void main(String[] args) {

        createBoard();
		userChoice();
		showBoard();
       
    }

    /**
     * UC-1 for creating Board for tic tac toe game
     */
    public static void createBoard() {
        char gameBoardElement[] = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        int i;
        for (i = 1; i < 10; i++) {
            gameBoard[i] = gameBoardElement[i];
        }

    }
	
	/**
     * UC-2 Method to allow the player to choose a letter X or O
     */
    public static void userChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 1 for 'X' or 2 for 'O':");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                player = 'X';
                computer = 'O';
                break;
            case 2:
                player = 'O';
                computer = 'X';
                break;
            default:
                System.out.println("Enter a Correct Input");
                break;
        }
        System.out.println("The Player is : " + player + " and The Computer is :    " + computer);
    }

 /**
     * UC-3 Show Board method to display the current Board
     */
    public static void showBoard() {

        System.out.println("\n\n\t\t" + gameBoard[1] + "   | " + gameBoard[2] + "  | " + gameBoard[3]);
        System.out.println(" \t\t    |    |   ");
        System.out.println(" \t\t ___|____|___ ");
        System.out.println("\n\n\t\t" + gameBoard[4] + "   | " + gameBoard[5] + "  | " + gameBoard[6]);
        System.out.println(" \t\t    |    |   ");
        System.out.println(" \t\t ___|____|___ ");
        System.out.println("\n\n\t\t" + gameBoard[7] + "   | " + gameBoard[8] + "  | " + gameBoard[9]);
        System.out.println(" \t\t    |    |   ");
        System.out.println(" \t\t    |    |   ");

	}
	}