package com.comp301.a08dungeon.view;

import com.comp301.a08dungeon.controller.Controller;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class TitleScreenView implements FXComponent {
  private final Controller controller;

  public TitleScreenView(Controller controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    // Title
    Label title = new Label("Dungeon Crawler");
    title.setStyle("-fx-font-size: 48px; -fx-text-fill: white;");

    // Start button
    Button startButton = new Button("Start Game");
    startButton.setOnAction(e -> controller.startGame());

    // Theme toggle
    ToggleButton themeToggle = new ToggleButton("Light Mode");
    themeToggle.setStyle("-fx-font-size: 14px;");

    // Root pane
    StackPane root = new StackPane();
    root.setPrefSize(600, 600);
    // initial dark theme
    root.setStyle("-fx-background-color: #222;");

    themeToggle.setOnAction(
        e -> {
          if (themeToggle.isSelected()) {
            // switch to light
            root.setStyle("-fx-background-color: white;");
            title.setStyle("-fx-font-size: 48px; -fx-text-fill: black;");
            startButton.setStyle("-fx-text-fill: black;");
            themeToggle.setText("Dark Mode");
            themeToggle.setStyle("-fx-text-fill: black;");
          } else {
            // back to dark
            root.setStyle("-fx-background-color: #222;");
            title.setStyle("-fx-font-size: 48px; -fx-text-fill: white;");
            startButton.setStyle("");
            themeToggle.setText("Light Mode");
            themeToggle.setStyle("");
          }
        });

    // Layout
    VBox layout = new VBox(20, title, startButton, themeToggle);
    layout.setAlignment(Pos.CENTER);

    root.getChildren().add(layout);
    return root;
  }
}
