import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.initializeBoard();
        System.out.println("Enter box number to select");
        game.playGame();
    }
}
