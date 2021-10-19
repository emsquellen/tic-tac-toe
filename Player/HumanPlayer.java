package Player;
import java.util.Scanner;
import Board.Board;

public class HumanPlayer implements Player {
    public char character;
    public Scanner in = new Scanner(System.in);

    public HumanPlayer(char c) {
        this.character = c;
    }

    @Override
    public int[] getMove(Board b) {

        int move = -1;
        while (!(b.checkMove(new int[] { (move - 1) / b.board.length, (move - 1) % b.board.length }))) {
            System.out.print("Enter a valid move (1-9): ");
            move = in.nextInt();
        }
        return new int[] { (move - 1) / b.board.length, (move - 1) % b.board.length };
    }
}
