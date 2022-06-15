module sudoku.example {
    requires javafx.controls;
    requires javafx.fxml;

    opens sudoku.example to javafx.fxml;
    exports sudoku.example;
}
