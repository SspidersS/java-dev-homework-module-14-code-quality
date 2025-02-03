import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private final char EMPTY = ' ';
    private final char PLAYER = 'X';
    private final char COMPUTER = 'O';
    private final char[] board = new char[9];
    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();

    public void initializeBoard() {
        for (int i = 0; i < board.length; i++) {
            board[i] = EMPTY;
        }
    }

    public void playGame() {
        while (true) {
            printBoard();
            playerMove();
            if (checkWinner(PLAYER)) {
                printBoard();
                System.out.println("You won the game!");
                break;
            }
            if (isBoardFull()) {
                printBoard();
                System.out.println("It's a draw!");
                break;
            }
            computerMove();
            if (checkWinner(COMPUTER)) {
                printBoard();
                System.out.println("You lost the game!");
                break;
            }
        }
    }

    private void printBoard() {
        System.out.println("\n " + board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("-----------");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("-----------");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8] + " \n");
    }

    private void playerMove() {
        int input;
        while (true) {
            System.out.print("Enter your move (1-9): ");
            input = scanner.nextInt() - 1;
            if (input >= 0 && input < 9 && board[input] == EMPTY) {
                board[input] = PLAYER;
                break;
            }
            System.out.println("Invalid move. Try again.");
        }
    }

    private void computerMove() {
        int move;
        do {
            move = random.nextInt(9);
        } while (board[move] != EMPTY);
        board[move] = COMPUTER;
    }

    private boolean checkWinner(char symbol) {
        int[][] winningCombinations = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                {0, 4, 8}, {2, 4, 6}
        };
        for (int[] combo : winningCombinations) {
            if (board[combo[0]] == symbol && board[combo[1]] == symbol && board[combo[2]] == symbol) {
                return true;
            }
        }
        return false;
    }

    private boolean isBoardFull() {
        for (char cell : board) {
            if (cell == EMPTY) {
                return false;
            }
        }
        return true;
    }
}
