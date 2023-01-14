package eek.ee.Idea;

public class Grid {
    public static final int SIZE = 1000;

    private boolean[][] boxCells = new boolean[SIZE][SIZE];

    public void changedState(int x, int i, boolean alive){
        boxCells [x][i] = alive;
    }

    public void nextBox(){
     boolean [][] nextStateCells = new boolean[SIZE][SIZE];
        for (int i = 1; i <SIZE-1; i++) {
            for (int j = 1; j <SIZE-1 ; j++) {
                nextStateCells[i][j] = calculateNextStateFor(i,j);

            }
            boxCells = nextStateCells;
            
        }
    }
    private boolean calculateNextStateFor (int x, int y){
        int numOfLivingCells = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            if (boxCells[i] [y - 1]){
                numOfLivingCells++;
            }
        }
            if (boxCells[x - 1] [y]){
            numOfLivingCells++;
        }
            if (boxCells[x + 1] [y]) {
            numOfLivingCells++;
        }
        for (int i = x - 1; i <= x + 1; i++) {
            if (boxCells[i] [y + 1]){
                numOfLivingCells++;
            }
        }
        if (boxCells[x][y]){
            return numOfLivingCells >= 2 && numOfLivingCells <= 3;
        } else {
            return numOfLivingCells == 3;
        }
    }

    public boolean[][] getBoxCells() {
        return boxCells;
    }
}
