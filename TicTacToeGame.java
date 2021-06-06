package com.bridgelabz;
import java.util.Scanner;

class TicTacToeGame {

        static char gameBoard[] = new char[10];
	static char playerLetter = ' ';
        static char computerLetter = ' ';
	private static int playerPosition = 0;
	private static int computerPosition = 0;
	private static int nonEmptyBlockCount = 1;
	private static int computerWinMove = 0;
	private static int computerWinMove = 0;
	
	//boolean Variables
    	private static boolean whoPlaysFirst = false;
	private static boolean someOneWon = false;
	
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
     * UC-2 Method to allow the player or computer choose a letter X or O through toss
	  getting Random values between 1 or 2 for who will play first 
     */
    private static void letterAssignment() {

        // 
        int firstPlay = (int) (Math.random() * 2 + 1);
        if (firstPlay == 1) {
            whoPlaysFirst = true;
            playerLetter = 'X';
            computerLetter = 'O';
            System.out.println("Player Symbol is :  X " + " Computer Symbol is : O ");
            System.out.println("Player Plays First");
        } else {
            playerLetter = 'O';
            computerLetter = 'X';
            System.out.println("Player Symbol is : O" + " Computer Symbol is : X ");
            System.out.println("Computer Plays First");
        }

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
	
	
	 /**
     * UC-7 Method for checking Horizontal and vertical Game Board Winner
     * Checking all the horizontal and vertical possible combinations for winner
     *
     * @param symbol for getting Letter X or O
     * @param columnValues getting int values from check won methods
     * @param rowValues getting int values from check won methods
     *
     */
    private static void checkHorizontalVerticalWon(char symbol, int columnValues, int rowValues) {

        int position = 1;//taking position variable as an index  value of game board
        int loopCounter = 1;
        while (loopCounter <= 3) {
            if ((gameBoard[position] == gameBoard[position + rowValues]) && (gameBoard[position + rowValues]) == (gameBoard[position + rowValues + rowValues]) && (gameBoard[position + rowValues + rowValues]) == symbol) {
                showBoard();
                System.out.println("HURRAY!!!" + symbol + " wins ");
                someOneWon = true;
                break;
            } else {
                position += columnValues;
            }
            loopCounter++;
        } // End of while Loop
    }

    /**
     * UC-7 Method for checking Diagonal Game Board Winner Checking all the
     * diagonal position of a  wins
     *
     * @param symbol is used to get X or O letter
     */
    private static void checkDiagonalWinner(char symbol) {
        int position = 1; //taking position variable as an index  value of game board
        int loopCounter = 1;
        while (loopCounter <= 2) {
            if ((gameBoard[position] == gameBoard[position + 4]) && (gameBoard[position + 4]) == (gameBoard[position + 8]) && (gameBoard[position + 8]) == symbol) {
                showBoard();
                System.out.println("HURRAY!!!" + symbol + " wins ");
                someOneWon = true;
                break;
            } else if ((gameBoard[position + 2] == gameBoard[position + 4]) && (gameBoard[position + 4]) == (gameBoard[position + 6]) && (gameBoard[position + 6]) == symbol) {
                showBoard();
                System.out.println("HURRAY!!!" + symbol + " wins ");
                someOneWon = true;
                break;
            }
            loopCounter++;
        } // End of while Loop
    }

    /**
     * UC-7 Method for checking a game has been tie or not.
     * game will be tie if there are no other options left to move.
     */
    private static void checkGameTie() {
        
        while (gameBoard[nonEmptyBlockCount] != ' ') {
            if (nonEmptyBlockCount == 9) {
                showBoard();
                System.out.println("UhUho!!!! Game Is Tie");
                someOneWon = true;
                computerWinMove = 1;
                break;
            } else {
                nonEmptyBlockCount++;
            }
        } //End of a While loop
    }
	
	/**
     * UC-8 Method for computer to make a move to a desired location in the game.
     * it also calls a function win or block move to win or to block the other from winning 
     */
    private static void computerMove() {
        computerWinMove = 0;
        System.out.println("Computer is Playing ");
        try {
            sleep(1000);  // putting threads into sleep for 1 ms.
        } catch (Exception ex) {
            System.out.println(ex);
        }
        winOrBlockMove(computerLetter);
        winOrBlockMove(playerLetter);
        checkCorners();
        checkMiddle();
        checkRemainingSides();

        whoPlaysFirst = true;
    }
        whoPlaysFirst = false;
    }


 /**
     * UC-9 Method for checking Opponent win moves then play to block it
     * checking all the possible winning moves
     *
     * @param symbol for getting letter X or O
     */
    private static void winOrBlockMove(char symbol) {
        //assigning values as per moves checks for row,column,leftDiagonal and rightDiagonal  
        int rowValue = 1;
        int columnValue = 3;
        int leftDiagonalValue = 4;
        int rightDiagonalValue = 2;

        //sending values to check winning move method for computer moves calculation
        checkWinningMove(rowValue, symbol, columnValue);
        checkWinningMove(columnValue, symbol, rowValue);
        checkWinningMove(leftDiagonalValue, symbol, 0);
        checkWinningMove(rightDiagonalValue, symbol, 0);

    }
	
	/**
     * UC-9 Method for checking Winning move of a computer or player.
	   This method is call from win or block move method
     * @param symbol for getting Letter X or O
     * @param columnValues getting int values from win or block move methods
     * @param rowValues getting int values from win or block move methods
     *
     */
	
	 private static void checkWinningMove(int rowValues, char symbol, int columnValues) {
        int counter = 1;
        if (computerWinMove == 0) {
            for(int i = 1; i <= 3; i++) {
                if ((gameBoard[counter] == (gameBoard[counter + rowValues + rowValues])) && (gameBoard[counter + rowValues] == ' ') && (gameBoard[counter]) == symbol) {
                    computerPosition = counter + rowValues;
                    gameBoard[computerPosition] = computerLetter;
                    computerWinMove = 1;
                    break;
                } else if ((gameBoard[counter]) == (gameBoard[counter + rowValues]) && (gameBoard[counter + rowValues + rowValues] == ' ') && (gameBoard[counter] == symbol)) {
                    computerPosition = counter + rowValues + rowValues;
                    gameBoard[computerPosition] = computerLetter;
                    computerWinMove = 1;
                    break;
                } else if ((gameBoard[counter + rowValues]) == (gameBoard[counter + rowValues + rowValues]) && (gameBoard[counter] == ' ') && (gameBoard[counter + rowValues] == symbol)) {
                    computerPosition = counter;
                    gameBoard[computerPosition] = computerLetter;
                    computerWinMove = 1;
                    break;
                }
                counter += columnValues;
            } // end of for loop
        } // end of if-else statement
    }
	
	/**
     * UC-10 Method for checking available free corners and take that spot.
     * method is used to traverse the game board corner is if available then move there
     */
    private static void checkCorners() {
        if (computerWinMove == 0) {
            for (int i = 1; i <= 9; i += 2) {
                if (gameBoard[i] == ' ') {
                    computerPosition = i;
                    gameBoard[computerPosition] = computerLetter;
                    computerWinMove = 1;
                    break;
                }
                if (i == 3) {
                    i += 2;
                }
            } // end of for loop
        } // end of if statement
    }
	
	 /**
     * UC-11 Method for checking middle or center of board and take that blank
     * spot if available This method is if there is no blank spot left on the
     * corner
     */
    
    private static void checkMiddle() {
        int middle = 5;
        if ((computerWinMove == 0) && (gameBoard[middle] == ' ')) {
            computerPosition = middle;
            gameBoard[computerPosition] = computerLetter;
            computerWinMove = 1;
        }
    }
    
     /**
     * UC-11 Method for checking all remaining sides of board 
     * 
     */
     private static void checkRemainingSides() {
        if (computerWinMove == 0) {
            for (int i = 2; i < 9; i += 2) {
                if (gameBoard[i] == ' ') {
                    computerPosition = i;
                    gameBoard[computerPosition] = computerLetter;
                    computerWinMove = 1;
                    break;
                }
            } // end of for loop
        } // end of if statement
    }
    
	
	
}
