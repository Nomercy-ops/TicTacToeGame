package com.bridgelabz;
import java.util.Scanner;

class TicTacToeGame {

    static char gameBoard[] = new char[10];
	static char player = ' ';
    static char computer = ' ';
	private static int playerPosition = 0;
	
	//boolean Variables
    private static boolean whoPlaysFirst = false;
	
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
	
	 /**
     * UC-4 Method for user to make a move to a desired location in the board
     * checks before moving if the board index is free or not
     */
    private static void playerMove() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("enter number between 1 to 9 ");
        playerPosition = scanner.nextInt();
        if (checkFreeSpace(playerPosition) == true) {
            gameBoard[playerPosition] = playerLetter;
            showBoard();
        } else {
            System.out.println("That positon is already taken, please choose another");
            playerMove();
        }
        whoPlaysFirst = false;
    }
	
	/**
     * UC-5 Method for checking free space in board
     *
     * @param position to get player input
     * @return true or false
     *
     */
    private static boolean checkFreeSpace(int position) {
        return !(gameBoard[position] == 'X' || gameBoard[position] == 'O');
    }
	
	}