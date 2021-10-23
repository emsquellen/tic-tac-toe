package Board;
public class Board {
    public char[][] board;

    public Board() {
        this.board = new char[][] {
            { ' ', ' ', ' ' },
            { ' ', ' ', ' ' },
            { ' ', ' ', ' ' }
        };
    }

    public void printBoard() {
        String fullBoard = "┌─┬─┬─┐\n";
        for (char[] row : this.board) {
            fullBoard += "│";
            for (char x : row) {
                fullBoard += x;
                fullBoard += "│";
            }
            fullBoard += "\n├─┼─┼─┤\n";
        }
        fullBoard = fullBoard.substring(0, 47);
        fullBoard += "\n╘═╧═╧═╛";
        System.out.println(fullBoard);
    }

    public void makeMove(int[] position, char character) {
        this.board[position[0]][position[1]] = character;
    }

    public boolean checkMove(int[] position) {
        if ((position[0] < 0 || position[0] > this.board.length)
                || (position[1] < 0 || position[1] > this.board[0].length)) {
            return false;
        }
        return this.board[position[0]][position[1]] == ' ';
    }

    public boolean winHorizontal(char character) {
        for (char[] row : this.board) {
            if (row[0] == character && row[0] == row[1] && row[2] == row[1]) {
                return true;
            }
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
        return (board[0][0] == character && board[0][0] == board[1][1] && board[2][2] == board[1][1])
                || (board[0][2] == character && board[0][2] == board[1][1] && board[1][1] == board[2][0]);
    }

    public boolean checkWins(char character) {
        return (winDiagonal(character) || winHorizontal(character) || winVertical(character)) ? true : false;
    }

    public boolean isFull() {
        for (char[] row : this.board) {
            if (new String(row).indexOf(' ') != -1)
                return false;
        }
        return true;
    }
}
