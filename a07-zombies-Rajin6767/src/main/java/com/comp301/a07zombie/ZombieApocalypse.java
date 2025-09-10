package com.comp301.a07zombie;

public class ZombieApocalypse {

  protected static Base base;
  protected static Survivor[] survivors;
  protected static Thread[] survivorThreads;

  public static void main(String[] args) {

    startSimulation(5);
    QuietDayStrategy quietDay = new QuietDayStrategy();

    simulateDayNightCycle(10000, new RandomZombieAttacksStrategy());

    endSimulation();
  }

  public static void startSimulation(int numSurvivors) {

    base = new Base();
    survivors = new Survivor[numSurvivors];
    survivorThreads = new Thread[numSurvivors];

    for (int i = 0; i < survivors.length; i++) {
      survivors[i] = new Survivor(base);
      Thread thread = new Thread(survivors[i]);
      thread.setName("Survivor-" + (i + 1));
      survivorThreads[i] = thread;
      thread.start();
    }
  }

  public static void simulateDayNightCycle(int milliseconds, IDayStrategy events) {
    try {
      events.execute(base, milliseconds);
    } catch (InterruptedException e) {
      System.out.println("Day-Night cycle interrupted: " + e.getMessage());
    }
  }

  public static void endSimulation() {

    System.out.println("Simulation ending...");
    for (Survivor survivor : survivors) {
      survivor.stop();
    }
    try {
      for (Thread thread : survivorThreads) {
        thread.join();
      }
    } catch (InterruptedException e) {
      System.out.println("Stopping loop was interrupted");
    }

    System.out.println("All survivors have stopped. Simulation over.");
  }
}
