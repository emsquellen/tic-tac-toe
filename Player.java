public class Player {
    public char character;
    private char enemyCharacter;
    public boolean isHuman;

    public Player(char c, boolean isHuman) {
        this.isHuman = isHuman;
        this.character = c;
        if (this.character == 'X') {
            this.enemyCharacter = 'O';
        } else {
            this.enemyCharacter = 'X';
        }
    }

    public int evaluateBoard(Board b) {
        if (b.checkWins(this)) {
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
            for (int i = 1; i <= 9; i++) {
                if (b.checkMove(i)) {
                    b.makeMove(i, this.character);
                    best = Math.max(best, miniMax(b, depth + 1, !isMax));
                    b.makeMove(i, ' ');
                }
            }
            return best;
        } else {
            int best = 1000;
            for (int i = 1; i <= 9; i++) {
                if (b.checkMove(i)) {
                    b.makeMove(i, this.enemyCharacter);
                    best = Math.min(best, miniMax(b, depth + 1, !isMax));
                    b.makeMove(i, ' ');
                }
            }
            return best;
        }
    }

    public int findMove(Board b) {
        int best = -1000;
        int bestMove = -1;
        for (int i = 1; i <= 9; i++) {
            if (b.checkMove(i)) {
                b.makeMove(i, this.character);
                int moveValue = miniMax(b, 0, false);
                b.makeMove(i, ' ');
                if (moveValue > best) {
                    best = moveValue;
                    bestMove = i;
                }
            }
        }
        return bestMove;
    }
}
