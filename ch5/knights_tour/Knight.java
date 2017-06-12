class MoveFailedException extends Exception { }

class MoveBackException extends RuntimeException {
    public MoveBackException(String message) {
        super("start from " + message + " can not visit every square.");
    }
}

public class Knight {
    final static int[] moveX = {1, 2, 2, 1, -1, -2, -2, -1};
    final static int[] moveY = {-2, -1, 1, 2, 2, 1, -1, -2};
    private int posX;
    private int posY;
    private int index = 0;
    private int[][] stack = new int[100][3];
    private int counter = 0;

    Knight(int[] p) {
        this.posX = p[0];
        this.posY = p[1];
    }

    public int[] predictNextPosition() throws MoveFailedException {
        if (index == moveX.length) {
            throw new MoveFailedException();
        }

        int newPosX = this.posX + moveX[index];
        int newPosY = this.posY + moveY[index];
        index++;

        return new int[] {newPosX, newPosY};
    }

    public int[] moveBack() {
        int[] pos = new int[] {this.posX, this.posY};

        if (counter == 0) {
            throw new MoveBackException(this.toString());
        }
        this.posX = this.stack[--counter][0];
        this.posY = this.stack[counter][1];
        this.index = this.stack[counter][2];
        return pos;
    }

    public void move(int[] p) {
        this.stack[counter++] = new int[] {this.posX, this.posY, this.index};
        this.posX = p[0];
        this.posY = p[1];
        this.index = 0;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", this.posX, this.posY);
    }
}
