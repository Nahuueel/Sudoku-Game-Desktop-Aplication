package sudoku.example.buildlogic;

import java.io.IOException;

import sudoku.example.computationlogic.GameLogic;
import sudoku.example.persistence.LocalStorageImpl;
import sudoku.example.problemdomain.IStogare;
import sudoku.example.problemdomain.SudokuGame;
import sudoku.example.userinterface.IUserInterfaceContract;
import sudoku.example.userinterface.logic.ControlLogic;

public class SudokuBuildLogic {
    public static void build(IUserInterfaceContract.View userInterface) throws IOException{
        SudokuGame initialState;
        IStogare storage = new LocalStorageImpl();

        try{
            initialState = storage.getGameData();
        }catch(IOException e){
            initialState = GameLogic.getNewGame();
            storage.updateGameData(initialState);
        }

        IUserInterfaceContract.EventListener uiLogic
                    = new ControlLogic(storage, userInterface);

        userInterface.setListener(uiLogic);
        userInterface.updateBoard(initialState);
    }
    
}
