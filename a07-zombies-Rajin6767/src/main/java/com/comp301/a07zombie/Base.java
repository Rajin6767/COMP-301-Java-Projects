package com.comp301.a07zombie;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Base implements IBase {
  private int supplyCount;
  private final Lock toolLock;
  private boolean isUnderAttack = false;

  public Base() {
    this.supplyCount = 0;
    this.toolLock = new ReentrantLock();
  }

  @Override
  public synchronized void addSupplies(int amount) {
    if (amount <= 0) {
      throw new IllegalArgumentException("Amount must be positive.");
    }
    supplyCount += amount;
    System.out.println(
        Thread.currentThread().getName() + " added " + amount + " supplies. Total: " + supplyCount);
  }

  @Override
  public synchronized int getSupplyCount() {
    return supplyCount;
  }

  @Override
  public void useTool(String task) {
    toolLock.lock();
    try {
      System.out.println(Thread.currentThread().getName() + " is using a tool for " + task);
      Thread.sleep(1000);
      System.out.println(Thread.currentThread().getName() + " has finished using the tool");
    } catch (InterruptedException e) {
      System.out.println("Tool use stopped.");
      Thread.currentThread().interrupt();
    } finally {
      toolLock.unlock();
    }
  }

  public synchronized void startAttack() {
    if (!isUnderAttack) {
      isUnderAttack = true;
      System.out.println("⚠️ Zombies are pullin' up!");
    }
  }

  public synchronized void endAttack() {
    if (isUnderAttack) {
      isUnderAttack = false;
      System.out.println("✅ The attack has ended. Survivors are safe... for now.");
    }
  }

  public synchronized boolean isUnderAttack() {
    return isUnderAttack;
  }
}
