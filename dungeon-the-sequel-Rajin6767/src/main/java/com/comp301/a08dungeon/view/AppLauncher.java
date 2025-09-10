package com.comp301.a08dungeon.view;

import com.comp301.a08dungeon.controller.Controller;
import com.comp301.a08dungeon.controller.ControllerImpl;
import com.comp301.a08dungeon.model.Model;
import com.comp301.a08dungeon.model.ModelImpl;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppLauncher extends Application {
  @Override
  public void start(Stage stage) {
    stage.setTitle("Rajin Islam's Dungeon Crawler");

    // start in title screen
    Model model = new ModelImpl(5, 5);
    Controller controller = new ControllerImpl(model);
    View view = new View(controller, model, stage);

    model.addObserver(view);

    Scene scene = new Scene(view.render(), 600, 600);
    scene.getStylesheets().add(getClass().getResource("/dungeon.css").toExternalForm());
    stage.setScene(scene);
    stage.show();
  }
}
