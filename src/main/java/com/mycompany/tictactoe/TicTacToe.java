/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tictactoe;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Faren
 */

public class TicTacToe {

    public static void main(String[] args) {
        char[][] gameBoard = {
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '}
        };

        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        boolean gameOver = false;

        printGameBoard(gameBoard);

        while (!gameOver) {
            // Player turn
            playerTurn(gameBoard, scan);
            if ((gameOver = checkGameOver(gameBoard, 'X'))) break;

            // CPU turn
            cpuTurn(gameBoard, rand);
            if ((gameOver = checkGameOver(gameBoard, 'O'))) break;
        }

        scan.close();
    }

    private static void playerTurn(char[][] gameBoard, Scanner scan) {
        int pos;
        while (true) {
            System.out.println("Enter your placement (1-9):");
            pos = scan.nextInt();
            if (isValidMove(gameBoard, pos)) break;
            System.out.println("Position already taken. Try again.");
        }
        PlacePiece(gameBoard, pos, "player");
        printGameBoard(gameBoard);
    }

    private static void cpuTurn(char[][] gameBoard, Random rand) {
        int cpuPos;
        while (true) {
            cpuPos = rand.nextInt(9) + 1;
            if (isValidMove(gameBoard, cpuPos)) break;
        }
        PlacePiece(gameBoard, cpuPos, "cpu");
        System.out.println("CPU placed at position: " + cpuPos);
        printGameBoard(gameBoard);
    }

    private static boolean checkGameOver(char[][] board, char symbol) {
        if (checkWinner(board, symbol)) {
            if (symbol == 'X') System.out.println("Congratulations! You win!");
            else System.out.println("CPU wins! Better luck next time.");
            return true;
        } else if (isBoardFull(board)) {
            System.out.println("It's a draw!");
            return true;
        }
        return false;
    }

    public static void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) System.out.print(c);
            System.out.println();
        }
    }

    public static void PlacePiece(char[][] gameBoard, int pos, String user) {
        char symbol = user.equals("player") ? 'X' : 'O';

        switch (pos) {
            case 1: gameBoard[0][0] = symbol; break;
            case 2: gameBoard[0][2] = symbol; break;
            case 3: gameBoard[0][4] = symbol; break;
            case 4: gameBoard[2][0] = symbol; break;
            case 5: gameBoard[2][2] = symbol; break;
            case 6: gameBoard[2][4] = symbol; break;
            case 7: gameBoard[4][0] = symbol; break;
            case 8: gameBoard[4][2] = symbol; break;
            case 9: gameBoard[4][4] = symbol; break;
        }
    }

    public static boolean isValidMove(char[][] board, int pos) {
        switch (pos) {
            case 1: return board[0][0] == ' ';
            case 2: return board[0][2] == ' ';
            case 3: return board[0][4] == ' ';
            case 4: return board[2][0] == ' ';
            case 5: return board[2][2] == ' ';
            case 6: return board[2][4] == ' ';
            case 7: return board[4][0] == ' ';
            case 8: return board[4][2] == ' ';
            case 9: return board[4][4] == ' ';
            default: return false;
        }
    }

    public static boolean checkWinner(char[][] board, char s) {
        // Rows
        if (board[0][0] == s && board[0][2] == s && board[0][4] == s) return true;
        if (board[2][0] == s && board[2][2] == s && board[2][4] == s) return true;
        if (board[4][0] == s && board[4][2] == s && board[4][4] == s) return true;

        // Columns
        if (board[0][0] == s && board[2][0] == s && board[4][0] == s) return true;
        if (board[0][2] == s && board[2][2] == s && board[4][2] == s) return true;
        if (board[0][4] == s && board[2][4] == s && board[4][4] == s) return true;

        // Diagonals
        if (board[0][0] == s && board[2][2] == s && board[4][4] == s) return true;
        if (board[0][4] == s && board[2][2] == s && board[4][0] == s) return true;

        return false;
    }

    public static boolean isBoardFull(char[][] board) {
        for (int pos = 1; pos <= 9; pos++) {
            if (isValidMove(board, pos)) return false;
        }
        return true;
    }
}
