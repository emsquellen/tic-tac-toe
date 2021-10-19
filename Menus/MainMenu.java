package Menus;

import java.util.NoSuchElementException;
import java.util.Scanner;

import Board.Board;
import Game.AIvsAI;
import Game.PvAI;

public class MainMenu implements Menu {
    Scanner in = new Scanner(System.in);

    @Override
    public void run() {
        while (true) {
            Board b = new Board();
            int game = getGame();
            newGame(game, b);
            if (!(playAgain())) {
                return;
            }
        }

    }

    public int getGame() {

        System.out.print(String.join("\n", "=====GAME TYPES=====", "[1] Player vs AI", "[2] AI vs AI",
                "Choose a gamemode (1-2): "));
        int gamePick = 3;
        while (gamePick > 2 || gamePick < 1) {
            gamePick = in.nextInt();
        }
        return gamePick;
    }

    public void newGame(int gameChoice, Board b) {
        if (gameChoice == 1) {
            PvAI game = new PvAI();
            game.play(b);
        } else {
            AIvsAI game = new AIvsAI();
            game.play(b);
        }
    }

    public boolean playAgain() {
        System.out.println("Play again? [Y/N]: ");
        String play = in.next();
        return play.toUpperCase().equals("Y");

    }
}
