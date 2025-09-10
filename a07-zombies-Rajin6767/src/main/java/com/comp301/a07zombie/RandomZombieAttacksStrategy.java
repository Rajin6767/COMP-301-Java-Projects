package com.comp301.a07zombie;

public class RandomZombieAttacksStrategy implements IDayStrategy {
  @Override
  public void execute(Base base, int durationMilliseconds) throws InterruptedException {
    int attack1 = durationMilliseconds / 5;
    int attack2 = durationMilliseconds / 5;
    int gapDuration = (durationMilliseconds - 2 * attack1) / 3;

    Thread.sleep(gapDuration);
    base.startAttack();
    Thread.sleep(attack1);
    base.endAttack();
    Thread.sleep(gapDuration);
    base.startAttack();
    Thread.sleep(attack2);
    base.endAttack();
    Thread.sleep(gapDuration);
  }
}
