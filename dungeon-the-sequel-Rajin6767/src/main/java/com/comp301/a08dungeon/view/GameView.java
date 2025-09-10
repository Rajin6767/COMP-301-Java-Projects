package com.comp301.a08dungeon.view;

import com.comp301.a08dungeon.controller.Controller;
import com.comp301.a08dungeon.model.Model;
import com.comp301.a08dungeon.model.board.Posn;
import com.comp301.a08dungeon.model.pieces.*;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

public class GameView implements FXComponent {
  private final Controller controller;
  private final Model model;
  private static final int TILE_SIZE = 40;

  public GameView(Controller controller, Model model) {
    this.controller = controller;
    this.model = model;
  }

  @Override
  public Parent render() {
    // 1) Create the game grid
    GridPane grid = new GridPane();
    grid.setAlignment(Pos.CENTER);
    grid.setHgap(1);
    grid.setVgap(1);

    // Fill grid with cells
    for (int r = 0; r < model.getHeight(); r++) {
      for (int c = 0; c < model.getWidth(); c++) {
        Piece p = model.get(new Posn(r, c));
        Label cell = createCell(p);
        grid.add(cell, c, r);
      }
    }

    // 2) Create control buttons
    Button up = createButton("↑", () -> controller.moveUp());
    Button down = createButton("↓", () -> controller.moveDown());
    Button left = createButton("←", () -> controller.moveLeft());
    Button right = createButton("→", () -> controller.moveRight());

    HBox controls = new HBox(10, left, up, down, right);
    controls.setAlignment(Pos.CENTER);

    // 3) Create score display
    Label scoreLabel =
        new Label("Score: " + model.getCurScore() + "   High: " + model.getHighScore());
    scoreLabel.setStyle(
        "-fx-text-fill: white; " + "-fx-font-size: 18px; " + "-fx-font-weight: bold;");

    // 4) Combine controls and score
    HBox bottomBar = new HBox(30, scoreLabel, controls);
    bottomBar.setAlignment(Pos.CENTER);
    bottomBar.setStyle("-fx-background-color: #34495e; " + "-fx-padding: 15px;");

    // 5) Create main layout
    BorderPane root = new BorderPane();
    root.setCenter(grid);
    root.setBottom(bottomBar);
    root.setStyle("-fx-background-color: #2c3e50;");

    return root;
  }

  private Label createCell(Piece p) {
    String color, text;

    if (p instanceof Hero) {
      color = "#3498db";
      text = "H";
    } else if (p instanceof Enemy) {
      color = "#e74c3c";
      text = "E";
    } else if (p instanceof Treasure) {
      color = "#f1c40f";
      text = "T";
    } else if (p instanceof Exit) {
      color = "#2ecc71";
      text = "X";
    } else if (p instanceof Wall) {
      color = "#7f8c8d";
      text = "W";
    } else {
      color = "#2c3e50";
      text = "";
    }

    Label cell = new Label(text);
    cell.setPrefSize(TILE_SIZE, TILE_SIZE);
    cell.setAlignment(Pos.CENTER);
    cell.setStyle(
        "-fx-background-color: "
            + color
            + "; "
            + "-fx-border-color: #34495e; "
            + "-fx-border-width: 1px; "
            + "-fx-text-fill: white; "
            + "-fx-font-weight: bold; "
            + "-fx-font-size: 16px;");
    return cell;
  }

  private Button createButton(String text, Runnable action) {
    Button btn = new Button(text);
    btn.setOnAction(e -> action.run());
    btn.setStyle(
        "-fx-font-size: 16px; "
            + "-fx-min-width: 40px; "
            + "-fx-min-height: 40px; "
            + "-fx-background-color: #3498db; "
            + "-fx-text-fill: white; "
            + "-fx-font-weight: bold;");
    return btn;
  }
}
