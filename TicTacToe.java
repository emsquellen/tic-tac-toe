import java.util.Scanner;

public class TicTacToe {

    private Board board;
    private Player playerX;
    private Player playerO;

    public TicTacToe(Player p1, Player p2) {
        this.board = new Board();
        this.playerX = p1;
        this.playerO = p2;
    }

    public void playGame() {
        System.out.println("┌─┬─┬─┐\n│1│2│3│\n├─┼─┼─┤\n│4│5│6│\n├─┼─┼─┤\n│7│8│9|\n╘═╧═╧═╛");
        while (true) {
            Player[] players = { playerX, playerO };
            for (Player currentPlayer : players) {
                Scanner in = new Scanner(System.in);
                int position = -1;
                if (currentPlayer.isHuman) {

                    while (!((0 < position && position < 10) && board.checkMove(position))) {
                        System.out.print("Player " + currentPlayer.character + "'s choice:");
                        String input = in.nextLine();
                        position = Integer.parseInt(input);
                    }
                } else {
                    position = currentPlayer.findMove(board);
                    System.out.println("Player " + currentPlayer.character + "'s choice:" + position);
                }

                board.updateBoard(position, currentPlayer);
                if (board.checkWins(currentPlayer)) {
                    System.out.println("Player " + currentPlayer.character + " won!");
                    return;
                } else if (board.isFull()) {
                    System.out.println("It's a tie!");
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        Player you;
        Player bot;
        TicTacToe game;
        // if (args[0].equals("X")) {
        // System.out.println('X');
        // you = new Player('X', true);
        // bot = new Player('O', false);
        // game = new TicTacToe(you, bot);
        // } else if (args[0].equals("O")){
        // System.out.println('O');
        // you = new Player('O', true);
        // bot = new Player('X', false);
        // game = new TicTacToe(bot, you);
        // } else {
        you = new Player('X', false);
        bot = new Player('O', false);
        game = new TicTacToe(you, bot);
        // }
        game.playGame();
    }
}