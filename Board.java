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

    public void makeMove(int position, char character) {
        board[(position - 1) / board.length][(position - 1) % board.length] = character;
    }

    public boolean winHorizontal(char character) {
        for (char[] row : this.board) {
            if (row[0] == character && row[0] == row[1] && row[2] == row[1]) {
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

    public boolean winVertical(char character) {
        for (int i = 0; i < 3; i++) {
            char[] row = new char[3];
            for (int j = 0; j < 3; j++) {
                row[j] += this.board[j][i];
            }
            if (row[0] == character && row[0] == row[1] && row[2] == row[1]) {
                return true;
            }
        }
        return false;
    }

    public boolean winDiagonal(char character) {
        if (board[0][0] == character && board[0][0] == board[1][1] && board[2][2] == board[1][1]) {
            return true;
        }
        if (board[0][2] == character && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }
        return false;
    }

    public boolean checkWins(char character) {
        if (winDiagonal(character) || winHorizontal(character) || winVertical(character))
            return true;
        return false;
    }

    public boolean checkWins(Player p) {
        if (winDiagonal(p.character) || winHorizontal(p.character) || winVertical(p.character))
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
