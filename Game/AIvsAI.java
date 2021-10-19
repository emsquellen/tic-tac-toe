package Game;

import java.util.Arrays;

import Board.Board;
import Player.AIPlayer;

public class AIvsAI implements Game {
    @Override
    public void play(Board b) {
        AIPlayer[] players = new AIPlayer[] { new AIPlayer('X'), new AIPlayer('O') };
        while (true) {
            for (AIPlayer player : players) {
                int[] move = player.getMove(b);
                System.out.println("Player " + player.character + "'s choice: " + Arrays.toString(move));
                b.makeMove(move, player.character);
                b.printBoard();
                if (b.checkWins(player.character)) {
                    System.out.println("Player " + player.character + " won!");
                    return;
                } else if (b.isFull()) {
                    System.out.println("It's a tie!");
                    return;
                }
            }
        }
    }
}
