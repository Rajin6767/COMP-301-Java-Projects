package com.comp301.a07zombie;

public class MyDayMyWayStrategy implements IDayStrategy {
  @Override
  public void execute(Base base, int durationMilliseconds) throws InterruptedException {
    int attackTime = durationMilliseconds / 4;
    int chillTime = (durationMilliseconds - attackTime) / 2;

    // chill to get ready
    Thread.sleep(chillTime);

    // throw hands
    base.startAttack();
    Thread.sleep(attackTime);
    base.endAttack();

    // chill to rest up
    Thread.sleep(chillTime);
  }
}
