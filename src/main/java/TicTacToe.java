import java.util.Scanner;
import java.util.Random;

public class TicTacToe {
    private static final char EMPTY = ' ';
    private static final char PLAYER = 'X';
    private static final char COMPUTER = 'O';
    private static final char[] board = new char[9];
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args) {
        initializeBoard();
        System.out.println("Enter box number to select");
        playGame();
    }

    private static void initializeBoard() {
        for (int i = 0; i < board.length; i++) {
            board[i] = EMPTY;
        }
    }

    private static void playGame() {
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

    private static void printBoard() {
        System.out.println("\n " + board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("-----------");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("-----------");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8] + " \n");
    }

    private static void playerMove() {
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

    private static void computerMove() {
        int move;
        do {
            move = random.nextInt(9);
        } while (board[move] != EMPTY);
        board[move] = COMPUTER;
    }

    private static boolean checkWinner(char symbol) {
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

    private static boolean isBoardFull() {
        for (char cell : board) {
            if (cell == EMPTY) {
                return false;
            }
        }
        return true;
    }
}
