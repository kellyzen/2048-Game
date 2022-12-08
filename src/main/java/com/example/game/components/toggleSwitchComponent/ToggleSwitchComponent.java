package com.example.game.components.toggleSwitchComponent;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 *
 * Create toggle switch button.
 * Modified from https://gist.github.com/TheItachiUchiha/12e40a6f3af6e1eb6f75
 *
 * @author Kelly Kai Ling Tan-modified
 * @version Dec 16, 2022
 * @author Coursework: COMP2042
 *
 */
public class ToggleSwitchComponent extends HBox {

    private final Label label = new Label();
    private final Button button = new Button();

    private SimpleBooleanProperty switchedOn = new SimpleBooleanProperty(false);

    /**
     *
     * Set toggle switch button off (false).
     *
     * @return switchedOn boolean
     *
     */
    public SimpleBooleanProperty switchOnProperty() { return switchedOn; }

    /**
     *
     * Toggle on default "OFF".
     * Switch on/off on mouse click.
     *
     */
    private void init() {

        label.setText("OFF");

        getChildren().addAll(label, button);
        button.setOnAction((e) -> {
            switchedOn.set(!switchedOn.get());
        });
        label.setOnMouseClicked((e) -> {
            switchedOn.set(!switchedOn.get());
        });
        setStyle();
        bindProperties();
    }

    /**
     *
     * Style the toggle button.
     *
     */
    private void setStyle() {
        //Default Width
        setWidth(80);
        label.setAlignment(Pos.CENTER);
        setStyle("-fx-background-color: grey; -fx-text-fill:black; -fx-background-radius: 4;");
        setAlignment(Pos.CENTER_LEFT);
    }

    /**
     *
     * Set toggle button width and height.
     *
     */
    private void bindProperties() {
        label.prefWidthProperty().bind(widthProperty().divide(2));
        label.prefHeightProperty().bind(heightProperty());
        button.prefWidthProperty().bind(widthProperty().divide(2));
        button.prefHeightProperty().bind(heightProperty());
    }

    /**
     *
     * Constructor method for ToggleSwitchComponent class.
     *
     */
    public ToggleSwitchComponent() {
        init();
        switchedOn.addListener((a,b,c) -> {
            if (c) {
                label.setText("ON");
                setStyle("-fx-background-color: green;");
                setOpacity(0.7);
                label.toFront();
            }
            else {
                label.setText("OFF");
                setStyle("-fx-background-color: grey;");
                setOpacity(0.7);
                button.toFront();
            }
        });
    }
}