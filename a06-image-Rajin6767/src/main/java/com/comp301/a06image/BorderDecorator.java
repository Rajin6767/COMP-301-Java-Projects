package com.comp301.a06image;

import java.awt.*;

public class BorderDecorator implements Image {
  private final Image image;
  private final int thickness;
  private final Color borderColor;

  public BorderDecorator(Image image, int thickness, Color borderColor) {
    if (image == null || thickness < 0) {
      throw new IllegalArgumentException();
    }
    this.image = image;
    this.thickness = thickness;
    this.borderColor = borderColor;
  }

  @Override
  public Color getPixelColor(int x, int y) {
    if (x < 0 || x >= this.getWidth() || y < 0 || y >= this.getHeight()) {
      throw new IllegalArgumentException();
    }
    if (x < thickness
        || x >= this.getWidth() - thickness
        || y < thickness
        || y >= this.getHeight() - thickness) {
      return borderColor;
    }
    return image.getPixelColor(x - thickness, y - thickness);
  }

  @Override
  public int getWidth() {
    return image.getWidth() + (thickness * 2);
  }

  @Override
  public int getHeight() {
    return image.getHeight() + (thickness * 2);
  }

  @Override
  public int getNumLayers() {
    return image.getNumLayers() + 1;
  }
}
