package Player;

import Board.Board;

public class AIPlayer implements Player {

    public char character;
    private char enemyCharacter;

    public AIPlayer(char c) {
        this.character = c;
        this.enemyCharacter = this.character == 'X' ? 'O' : 'X';
    }

    public int evaluateBoard(Board b) {
        if (b.checkWins(this.character)) {
            return 10;
        } else if (b.checkWins(enemyCharacter)) {
            return -10;
        } else {
            return 0;
        }
    }

    public int miniMax(Board b, int depth, boolean isMax) {

        int score = evaluateBoard(b);
        if (score != 0)
            return score;
        if (b.isFull())
            return 0;

        if (isMax) {
            int best = -1000;
            for (int i = 0; i < b.board.length; i++) {
                for (int j = 0; j < b.board[0].length; j++) {
                    int[] currentCell = new int[] { i, j };
                    if (b.checkMove(currentCell)) {
                        b.makeMove(currentCell, this.character);
                        best = Math.max(best, miniMax(b, depth + 1, !isMax));
                        b.makeMove(currentCell, ' ');
                    }
                }
            }
            return best;
        } else {
            int best = 1000;
            for (int i = 0; i < b.board.length; i++) {
                for (int j = 0; j < b.board[0].length; j++) {
                    int[] currentCell = new int[] { i, j };
                    if (b.checkMove(currentCell)) {
                        b.makeMove(currentCell, this.enemyCharacter);
                        best = Math.min(best, miniMax(b, depth + 1, !isMax));
                        b.makeMove(currentCell, ' ');
                    }
                }
            }
            return best;
        }
    }

    @Override
    public int[] getMove(Board b) {
        int best = -1000;
        int bestMoveRow = -1;
        int bestMoveCol = -1;
        for (int i = 0; i < b.board.length; i++) {
            for (int j = 0; j < b.board[0].length; j++) {
                int[] currentCell = new int[] { i, j };
                if (b.checkMove(currentCell)) {
                    b.makeMove(currentCell, this.character);
                    int moveValue = miniMax(b, 0, false);
                    b.makeMove(currentCell, ' ');
                    if (moveValue > best) {
                        best = moveValue;
                        bestMoveRow = i;
                        bestMoveCol = j;
                    }
                }
            }
        }
        return new int[] { bestMoveRow, bestMoveCol };
    }
}