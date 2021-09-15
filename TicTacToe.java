import java.util.Scanner;

public class TicTacToe {

    private Board board;
    private Player playerX;
    private Player playerO;

    public TicTacToe() {
        this.board = new Board();
        this.playerX = new Player('X');
        this.playerO = new Player('O');
    }

    public void playGame() {
        while (true) {
            Player[] players = { playerX, playerO };
            for (Player currentPlayer : players) {
                Scanner in = new Scanner(System.in);
                int position = -1;
                while (!((0 < position && position < 10) && board.checkMove(position))) {
                    System.out.print("Player " + currentPlayer.character + "'s choice:");
                    String input = in.nextLine();
                    position = Integer.parseInt(input);
                }
                board.updateBoard(position, currentPlayer);
                if (board.checkWins(currentPlayer)) {
                    System.out.println("Player " + currentPlayer.character + " won!");
                    return;
                }
                else if (board.isFull()){
                    System.out.println("It's a tie!");
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.playGame();
    }
}