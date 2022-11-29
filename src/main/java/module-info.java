module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.game to javafx.fxml;
    exports com.example.game;
    exports com.example.game.endGame;
    opens com.example.game.endGame to javafx.fxml;
    exports com.example.game.game;
    opens com.example.game.game to javafx.fxml;
    exports com.example.game.account;
    opens com.example.game.account to javafx.fxml;
    exports com.example.game.menu;
    opens com.example.game.menu to javafx.fxml;
    exports com.example.game.game.move;
    opens com.example.game.game.move to javafx.fxml;
    opens com.example.game.game.cell to javafx.fxml;
    exports com.example.game.game.cell;
    opens com.example.game.launch to javafx.fxml;
    exports com.example.game.launch;
    opens com.example.game.rank to javafx.fxml;
    exports com.example.game.rank;
}