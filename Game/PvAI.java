package Game;

import java.util.Scanner;
import java.util.Arrays;
import Board.Board;
import Player.AIPlayer;
import Player.HumanPlayer;

public class PvAI implements Game {
    @Override
    public void play(Board b) {
        Scanner in = new Scanner(System.in);
        System.out.print("Do you want to play as X or O: ");
        char choice = ' ';
        while (!(choice == 'X' || choice == 'O')) {
            choice = in.next().charAt(0);
        }
        if (choice == 'X') {
            humanIsX(b);
        } else {
            humanIsO(b);
        }
        in.close();

    }

    public void humanIsX(Board b) {
        HumanPlayer x = new HumanPlayer('X');
        AIPlayer o = new AIPlayer('O');
        while (true) {
            int[] move = x.getMove(b);
            System.out.println("Player X's choice: " + Arrays.toString(move));
            b.makeMove(move, 'X');
            b.printBoard();
            if (b.checkWins(x.character)) {
                System.out.println("Player X won!");
                return;
            } else if (b.isFull()) {
                System.out.println("It's a tie!");
                return;
            }
            move = o.getMove(b);
            System.out.println("Player O's choice: " + Arrays.toString(move));
            b.makeMove(move, 'O');
            b.printBoard();
            if (b.checkWins(o.character)) {
                System.out.println("Player O won!");
                return;
            } else if (b.isFull()) {
                System.out.println("It's a tie!");
                return;
            }
        }
    }

    public void humanIsO(Board b) {
        AIPlayer x = new AIPlayer('X');
        HumanPlayer o = new HumanPlayer('O');
        while (true) {
            int[] move = x.getMove(b);
            System.out.println("Player X's choice: " + Arrays.toString(move));
            b.makeMove(move, 'X');
            b.printBoard();
            if (b.checkWins(x.character)) {
                System.out.println("Player X won!");
                return;
            } else if (b.isFull()) {
                System.out.println("It's a tie!");
                return;
            }
            move = o.getMove(b);
            System.out.println("Player O's choice: " + Arrays.toString(move));
            b.makeMove(move, 'O');
            b.printBoard();
            if (b.checkWins(o.character)) {
                System.out.println("Player O won!");
                return;
            } else if (b.isFull()) {
                System.out.println("It's a tie!");
                return;
            }
        }
    }
}