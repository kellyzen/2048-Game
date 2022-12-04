module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens com.example.game to javafx.fxml;
    exports com.example.game;
    exports com.example.game.scene.endGame;
    opens com.example.game.scene.endGame to javafx.fxml;
    exports com.example.game.scene.game;
    opens com.example.game.scene.game to javafx.fxml;
    exports com.example.game.scene.account;
    opens com.example.game.scene.account to javafx.fxml;
    exports com.example.game.scene.menu;
    opens com.example.game.scene.menu to javafx.fxml;
    exports com.example.game.scene.game.move;
    opens com.example.game.scene.game.move to javafx.fxml;
    opens com.example.game.scene.game.cell to javafx.fxml;
    exports com.example.game.scene.game.cell;
    opens com.example.game.scene.launch to javafx.fxml;
    exports com.example.game.scene.launch;
    opens com.example.game.scene.rank to javafx.fxml;
    exports com.example.game.scene.rank;
}