package sudoku.example.userinterface.logic;

import java.io.IOException;

import sudoku.example.computationlogic.GameLogic;
import sudoku.example.constants.GameState;
import sudoku.example.constants.Messages;
import sudoku.example.problemdomain.IStogare;
import sudoku.example.problemdomain.SudokuGame;
import sudoku.example.userinterface.IUserInterfaceContract;

public class ControlLogic implements IUserInterfaceContract.EventListener {

    private IStogare stogare;

    private IUserInterfaceContract.View view;

    public ControlLogic(IStogare stogare, IUserInterfaceContract.View view) {
        this.stogare = stogare;
        this.view = view;
    }

    @Override
    public void onSudokuInput(int x, int y, int input) {
        try{
            SudokuGame gameData = stogare.getGameData();
            int[][] newGridState = gameData.getCopyOfGirdState();
            newGridState[x][y] = input;

            gameData = new SudokuGame(
                GameLogic.checkForCompletion(newGridState),
                newGridState);

            stogare.updateGameData(gameData);

            view.updateSquare(x, y, input);

            if(gameData.getGameState() == GameState.COMPLETE){
                view.showDialog(Messages.GAME_COMPLETE);
            }
        } catch(IOException e){
            e.printStackTrace();
            view.showError(Messages.ERROR);
        }
        
    }

    @Override
    public void onDialogClick() {
        try{
            stogare.updateGameData(GameLogic.getNewGame());

            view.updateBoard(stogare.getGameData());
        } catch(IOException e){
            view.showError(Messages.ERROR);
        }
    }

    
}
