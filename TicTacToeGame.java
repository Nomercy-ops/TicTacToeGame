/**
 * 
 * @author Rikesh Chhetri
 * @version 1.0
 * @Created_on: 06.06.21
 * 
 *  purpose:  Tic Tac Toe program game where  player and computer can play the game.
 *
 */

package com.bridgelabz;

class TicTacToeGame {

    static char gameBoard[] = new char[10];
	
    *
    Main method for execution of programs
    */
    public static void main(String[] args) {
        TicTacToeGame tictactoe = new TicTacToeGame();
        tictactoe.startGame();
        tictactoe.anotherGame();
        
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