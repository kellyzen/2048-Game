module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
    exports com.example.demo.endGame;
    opens com.example.demo.endGame to javafx.fxml;
    exports com.example.demo.game;
    opens com.example.demo.game to javafx.fxml;
    exports com.example.demo.account;
    opens com.example.demo.account to javafx.fxml;
    exports com.example.demo.menu;
    opens com.example.demo.menu to javafx.fxml;
    exports com.example.demo.game.move;
    opens com.example.demo.game.move to javafx.fxml;
    opens com.example.demo.game.cell to javafx.fxml;
    exports com.example.demo.game.cell;
}