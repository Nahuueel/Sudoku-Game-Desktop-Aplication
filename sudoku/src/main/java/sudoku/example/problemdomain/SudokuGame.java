package sudoku.example.problemdomain;

import java.io.Serializable;

import sudoku.example.constants.GameState;

public class SudokuGame implements Serializable {
    private final GameState gameState;
    private final int[][] girdState;

    public static final int GRID_BOUNDARY = 9;

    public SudokuGame (GameState gameState, int[][] girdState){
        this.gameState = gameState;
        this.girdState = girdState;
    }
    
    public GameState getGameState() {
        return gameState;
    }
    
    public int[][] getCopyOfGirdState() {
        return SudokuUtilities.copyToNewArray(girdState);
    }
}
