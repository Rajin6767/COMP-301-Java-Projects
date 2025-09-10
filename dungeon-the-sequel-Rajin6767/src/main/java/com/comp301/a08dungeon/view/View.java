package com.comp301.a08dungeon.view;

import com.comp301.a08dungeon.controller.Controller;
import com.comp301.a08dungeon.model.Model;
import com.comp301.a08dungeon.model.Observer;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class View implements FXComponent, Observer {
  private final Controller controller;
  private final Model model;
  private final Stage stage;

  public View(Controller controller, Model model, Stage stage) {
    this.controller = controller;
    this.model = model;
    this.stage = stage;
  }

  @Override
  public Parent render() {
    if (model.getStatus() == Model.STATUS.END_GAME) {
      return new TitleScreenView(controller).render();
    } else {
      return new GameView(controller, model).render();
    }
  }

  @Override
  public void update() {
    Scene scene = new Scene(render(), 600, 600);
    scene.getStylesheets().add("dungeon.css");
    stage.setScene(scene);
  }
}
