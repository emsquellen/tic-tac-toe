public class Board {
    public char[][] board;

    public Board() {
        this.board = new char[][] { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
    }

    public void printBoard() {
        String fullBoard = "┌─┬─┬─┐\n";
        for (char[] row : this.board) {
            fullBoard += "│";
            for (char x : row) {
                fullBoard += x;
                fullBoard += "│";
            }
            fullBoard += "\n";
            fullBoard += "├─┼─┼─┤\n";
        }
        fullBoard = fullBoard.substring(0, 47);
        fullBoard += "\n╘═╧═╧═╛";
        System.out.println(fullBoard);
    }

    public void updateBoard(int position, Player player) {
        char character = player.character;
        board[(position - 1) / board.length][(position - 1) % board.length] = character;
        printBoard();
    }

    public boolean winHorizontal(Player p) {
        for (char[] row : this.board) {
            if (row[0] == p.character && row[0] == row[1] && row[2] == row[1]) {
                return true;
            }
        }
        return false;
    }

    public boolean checkMove(int position) {
        char chosenPos = board[(position - 1) / board.length][(position - 1) % board.length];
        if (chosenPos == ' ') {
            return true;
        }
        return false;
    }

    public boolean winVertical(Player p) {
        for (int i = 0; i < 3; i++) {
            char[] row = new char[3];
            for (int j = 0; j < 3; j++) {
                row[j] += this.board[j][i];
            }
            if (row[0] == p.character && row[0] == row[1] && row[2] == row[1]) {
                return true;
            }
        }
        return false;
    }

    public boolean winDiagonal(Player p) {
        if (board[0][0] == p.character && board[0][0] == board[1][1] && board[2][2] == board[1][1]) {
            return true;
        }
        if (board[0][0] == p.character && board[0][0] == board[1][2] && board[2][2] == board[2][1]) {
            return true;
        }
        return false;
    }

    public boolean checkWins(Player p) {
        if (winDiagonal(p) || winHorizontal(p) || winVertical(p))
            return true;
        return false;
    }

    public boolean isFull() {
        for (char[] row : this.board) {
            if (new String(row).indexOf(' ') != -1) {
                return false;
            }
        }
        return true;
    }
}
