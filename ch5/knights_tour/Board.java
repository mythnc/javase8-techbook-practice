import java.util.Arrays;
import java.util.Random;

class Board {
    private final int size;
    private int[][] board;
    private Knight knight;
    private int counter = 0;

    Board(int size) {
        this.size = size;
        board = new int[size][size];
        for (int i = 0; i < size ; i++ ) {
            Arrays.fill(board[i], 0);
        }

        int[] pos = getRandomPosition();
        board[pos[1]][pos[0]] = ++counter;
        knight = new Knight(pos);

        while (!isMoveCompleted()) {
            this.moveKnight();
        }
        this.display();
    }

    private int[] getRandomPosition() {
        Random rnd = new Random();
        return new int[] {rnd.nextInt(size), rnd.nextInt(size)};
    }

    private void moveKnight() {
        int[] pos = new int[2];
        do {
            try {
                pos = knight.predictNextPosition();
            } catch(MoveFailedException ex) {
                pos = knight.moveBack();
                board[pos[1]][pos[0]] = 0;
                counter--;
                return;
            }
        } while(!isValidMove(pos));
        
        knight.move(pos);
        board[pos[1]][pos[0]] = ++counter;
    }

    private boolean isValidMove(int[] pos) {
        return (pos[0] >= 0 && pos[0] < size
                && pos[1] >= 0 && pos[1] < size
                && board[pos[1]][pos[0]] == 0);
    }

    private boolean isMoveCompleted() {
        if (counter < size * size) {
            return false;
        }
        return true;
    }

    private void display() {
        System.out.print("\033[H\033[2J");
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                String token = String.format("%2d", board[i][j]);
                s.append("  " + token);
            }
            s.append(System.getProperty("line.separator"));
            s.append(System.getProperty("line.separator"));
        }
        return s.toString();
    }

    public static void main (String[] args) {
        Board b = new Board(Integer.parseInt(args[0]));
    }
}
