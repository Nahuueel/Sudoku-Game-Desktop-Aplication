package sudoku.example.problemdomain;

import java.io.IOException;

public interface IStogare {
    void updateGameData(SudokuGame game) throws IOException;
    SudokuGame getGameData() throws IOException; 
    
}
