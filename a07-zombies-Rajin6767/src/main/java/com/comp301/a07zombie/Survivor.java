package com.comp301.a07zombie;

import java.util.Random;

public class Survivor implements ISurvivor {
  private final Base base;

  Random random = new Random();
  private volatile boolean run = true;
  private boolean isDefending = false;

  public Survivor(Base base) {

    this.base = base;
  }

  public boolean isDefending() {
    return isDefending;
  }

  @Override
  public void stop() {
    run = false;
  }

  @Override
  public void run() {
    while (run) {
      try {
        if (base.isUnderAttack()) {
          isDefending = true;
          System.out.println(
              Thread.currentThread().getName() + " is holdin' down the fort against Zombies!");
          Thread.sleep(2000);
          isDefending = false;
        } else {
          this.performAction();
        }
      } catch (InterruptedException e) {
        run = false;
      }
    }
  }

  protected void performAction() throws InterruptedException {

    int randomNumber = (int) (Math.random() * 3) + 1;
    if (randomNumber == 1) {
      scavenge();
    } else if (randomNumber == 2) {
      fortify();
    } else if (randomNumber == 3) {
      rest();
    }
  }

  protected void scavenge() throws InterruptedException {
    int randomNumber = (int) (Math.random() * 4) + 1;
    int time = randomNumber * 1000;
    System.out.println(
        Thread.currentThread().getName() + " is on the lookout for supplies right now");
    Thread.sleep(time);
    base.addSupplies(2);
  }

  protected void fortify() throws InterruptedException {
    base.useTool("fortification");
    System.out.println(Thread.currentThread().getName() + " is drippin' out the base");
    Thread.sleep(2000);
    System.out.println(Thread.currentThread().getName() + " finished drippin' out their base");
  }

  protected void rest() throws InterruptedException {

    System.out.println(Thread.currentThread().getName() + " is mad sleepy yo, abouta slump out.");
    Thread.sleep(2000);
  }
}
