package com.mycompany.tictactoe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {

    @Test
    public void testPlayerWin() {
        char[][] board = {
            {'X', '|', 'X', '|', 'X'},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '}
        };

        assertTrue(TicTacToe.checkWinner(board, 'X'), "Player X should win");
        assertFalse(TicTacToe.checkWinner(board, 'O'), "CPU O should not win");
    }

    @Test
    public void testCPUWin() {
        char[][] board = {
            {'O', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {'O', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {'O', '|', ' ', '|', ' '}
        };

        assertTrue(TicTacToe.checkWinner(board, 'O'), "CPU O should win");
        assertFalse(TicTacToe.checkWinner(board, 'X'), "Player X should not win");
    }

    @Test
    public void testDraw() {
        char[][] board = {
            {'X', '|', 'O', '|', 'X'},
            {'-', '+', '-', '+', '-'},
            {'O', '|', 'X', '|', 'O'},
            {'-', '+', '-', '+', '-'},
            {'O', '|', 'X', '|', 'O'}
        };

        assertTrue(TicTacToe.isBoardFull(board), "Board should be full");
        assertFalse(TicTacToe.checkWinner(board, 'X'), "No winner in a draw");
        assertFalse(TicTacToe.checkWinner(board, 'O'), "No winner in a draw");
    }

    @Test
    public void testIsValidMove() {
        char[][] board = {
            {'X', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', 'O', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '}
        };

        assertTrue(TicTacToe.isValidMove(board, 3), "Position 3 is valid");
        assertFalse(TicTacToe.isValidMove(board, 1), "Position 1 is taken");
    }

    @Test
    public void testPlacePiece() {
        char[][] board = {
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '}
        };

        TicTacToe.PlacePiece(board, 5, "player");
        assertEquals('X', board[2][2], "Player X should be placed at position 5");

        TicTacToe.PlacePiece(board, 3, "cpu");
        assertEquals('O', board[0][4], "CPU O should be placed at position 3");
    }
}
