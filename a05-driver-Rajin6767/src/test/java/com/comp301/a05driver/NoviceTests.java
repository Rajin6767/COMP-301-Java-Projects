package com.comp301.a05driver;

//import com.comp301.a05driver.ProximityIterator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NoviceTests {

  @Test
  public void simpleTest() {
    Driver d1 = this.makeDriver(0, 1);
    Driver d2 = this.makeDriver(0, 2);
    Driver d3 = this.makeDriver(0, 3);
    Driver d4 = this.makeDriver(0, 4);
    Driver d5 = this.makeDriver(0, 5);
    List<Driver> pool = new ArrayList<>();
    pool.add(d1);
    pool.add(d2);
    pool.add(d3);
    pool.add(d4);
    pool.add(d5);
    Position client_position = new PositionImpl(0, 0);
//    Iterator<Driver> proximity_iterator = new ProximityIterator(pool, client_position, 6);
//    assertTrue(proximity_iterator.hasNext());
//    assertEquals(d1, proximity_iterator.next());
//    assertTrue(proximity_iterator.hasNext());
//    assertEquals(d2, proximity_iterator.next());
//    assertTrue(proximity_iterator.hasNext());
//    assertEquals(d3, proximity_iterator.next());
//    assertTrue(proximity_iterator.hasNext());
//    assertEquals(d4, proximity_iterator.next());
//    assertTrue(proximity_iterator.hasNext());
//    assertEquals(d5, proximity_iterator.next());
  }

  @Test
  public void excludesTwoTest() {
    Driver d1 = this.makeDriver(0, 1);
    Driver d2 = this.makeDriver(0, 2);
    Driver d3 = this.makeDriver(0, 3);
    Driver d4 = this.makeDriver(0, 4);
    Driver d5 = this.makeDriver(0, 5);
    List<Driver> pool = new ArrayList<>();
    pool.add(d1);
    pool.add(d2);
    pool.add(d3);
    pool.add(d4);
    pool.add(d5);
    Position client_position = new PositionImpl(0, 0);
//    Iterator<Driver> proximity_iterator = new ProximityIterator(pool, client_position, 3);
//    assertTrue(proximity_iterator.hasNext());
//    assertEquals(d1, proximity_iterator.next());
//    assertTrue(proximity_iterator.hasNext());
//    assertEquals(d2, proximity_iterator.next());
//    assertTrue(proximity_iterator.hasNext());
//    assertEquals(d3, proximity_iterator.next());
//    assertFalse(proximity_iterator.hasNext());
//    assertFalse(proximity_iterator.hasNext());
  }

  @Test
  public void sizeZeroPoolTest() {
    List<Driver> pool = new ArrayList<>();
    Position client_position = new PositionImpl(0, 0);
//    Iterator<Driver> proximity_iterator = new ProximityIterator(pool, client_position, 3);
//    assertFalse(proximity_iterator.hasNext());
//    assertFalse(proximity_iterator.hasNext());
  }

  @Test
  public void noEligibleDriversInPoolTest() {
    Driver d1 = this.makeDriver(0, 1);
    Driver d2 = this.makeDriver(0, 2);
    Driver d3 = this.makeDriver(0, 3);
    Driver d4 = this.makeDriver(0, 4);
    Driver d5 = this.makeDriver(0, 5);
    List<Driver> pool = new ArrayList<>();
    pool.add(d1);
    pool.add(d2);
    pool.add(d3);
    pool.add(d4);
    pool.add(d5);
    Position client_position = new PositionImpl(10, 0);
//    Iterator<Driver> proximity_iterator = new ProximityIterator(pool, client_position, 3);
//    assertFalse(proximity_iterator.hasNext());
//    assertFalse(proximity_iterator.hasNext());
  }

  @Test
  public void severalAtSameDistanceTest() {
    Driver d1 = this.makeDriver(0, 2);
    Driver d2 = this.makeDriver(0, 2);
    Driver d3 = this.makeDriver(0, 4);
    Driver d4 = this.makeDriver(0, 4);
    Driver d5 = this.makeDriver(0, 4);
    List<Driver> pool = new ArrayList<>();
    pool.add(d1);
    pool.add(d2);
    pool.add(d3);
    pool.add(d4);
    pool.add(d5);
    Position client_position = new PositionImpl(0, 0);
//    Iterator<Driver> proximity_iterator = new ProximityIterator(pool, client_position, 6);
//    assertTrue(proximity_iterator.hasNext());
//    assertEquals(d1, proximity_iterator.next());
//    assertTrue(proximity_iterator.hasNext());
//    assertEquals(d2, proximity_iterator.next());
//    assertTrue(proximity_iterator.hasNext());
//    assertEquals(d3, proximity_iterator.next());
//    assertTrue(proximity_iterator.hasNext());
//    assertEquals(d4, proximity_iterator.next());
//    assertTrue(proximity_iterator.hasNext());
//    assertEquals(d5, proximity_iterator.next());
  }

  @Test
  public void skipsSomeInMiddleTest() {
    Driver d1 = this.makeDriver(0, 1);
    Driver d2 = this.makeDriver(0, 20);
    Driver d3 = this.makeDriver(0, 3);
    Driver d4 = this.makeDriver(0, 40);
    Driver d5 = this.makeDriver(0, 5);
    List<Driver> pool = new ArrayList<>();
    pool.add(d1);
    pool.add(d2);
    pool.add(d3);
    pool.add(d4);
    pool.add(d5);
    Position client_position = new PositionImpl(0, 0);
//    Iterator<Driver> proximity_iterator = new ProximityIterator(pool, client_position, 6);
//    assertTrue(proximity_iterator.hasNext());
//    assertEquals(d1, proximity_iterator.next());
//    assertTrue(proximity_iterator.hasNext());
//    assertEquals(d3, proximity_iterator.next());
//    assertTrue(proximity_iterator.hasNext());
//    assertEquals(d5, proximity_iterator.next());
//    assertFalse(proximity_iterator.hasNext());
//    assertFalse(proximity_iterator.hasNext());
  }

  @Test
  public void throwsNoSuchElementTest() {
    Driver d1 = this.makeDriver(0, 1);
    Driver d2 = this.makeDriver(0, 20);
    List<Driver> pool = new ArrayList<>();
    pool.add(d1);
    pool.add(d2);
    Position client_position = new PositionImpl(0, 0);
//    Iterator<Driver> proximity_iterator = new ProximityIterator(pool, client_position, 6);
//    assertTrue(proximity_iterator.hasNext());
//    assertEquals(d1, proximity_iterator.next());
//    assertFalse(proximity_iterator.hasNext());

//    try {
//      Driver d = (Driver) proximity_iterator.next();
//      fail("Expected NoSuchElementException to be thrown");
//    } catch (NoSuchElementException var7) {
//    } catch (Exception var8) {
//      fail("Exception thrown was not NoSuchElementException");
//    }

  }

  @Test
  public void nullPoolThrowsConstructorExceptionTest() {
//    try {
      Position client_position = new PositionImpl(0, 0);
//      new ProximityIterator((Iterable) null, client_position, 6);
//      fail("Should have thrown IllegalArgumentException");
//    } catch (IllegalArgumentException var3) {
//    } catch (Exception var4) {
//      fail("Threw exception for null driver pool, but not IllegalArgumentException");
//    }

  }

  @Test
  public void nullPositionConstructorExceptionTest() {
//    try {
//      Driver d1 = this.makeDriver(0, 1);
//      Driver d2 = this.makeDriver(0, 20);
//      List<Driver> pool = new ArrayList<>();
//      pool.add(d1);
//      pool.add(d2);
//      new ProximityIterator(pool, (Position) null, 6);
//      fail("Should have thrown IllegalArgumentException");
//    } catch (IllegalArgumentException var5) {
//    } catch (Exception var6) {
//      fail("Threw exception for null position, but not IllegalArgumentException");
//    }

  }

  @Test
  public void worksWithAnyIterableTest() {
    class TestCollection implements Iterable<Driver> {

      private List<Driver> _pool = new ArrayList<>();

      public TestCollection() {
        this._pool.add(makeDriver(1, 1));
        this._pool.add(makeDriver(2, 2));
        this._pool.add(makeDriver(3, 3));
        this._pool.add(makeDriver(4, 4));
        this._pool.add(makeDriver(5, 5));
      }

      @Override
      public Iterator<Driver> iterator() {
        return this._pool.iterator();
      }

      public Driver getDriver(int idx) {
        return (Driver) this._pool.get(idx);
      }
    }

    TestCollection test_collection = new TestCollection();
//    Iterator<Driver> proximity_iterator = new ProximityIterator(test_collection,
//        new PositionImpl(0, 0), 6);
//    assertTrue(proximity_iterator.hasNext());
//    assertEquals(test_collection.getDriver(0), proximity_iterator.next());
//    assertTrue(proximity_iterator.hasNext());
//    assertEquals(test_collection.getDriver(1), proximity_iterator.next());
//    assertTrue(proximity_iterator.hasNext());
//    assertEquals(test_collection.getDriver(2), proximity_iterator.next());
//    assertFalse(proximity_iterator.hasNext());
  }

  private Driver makeDriver(int i, int j) {
    Vehicle v = new VehicleImpl("make", "model", "plate", new PositionImpl(i, j));
    return new DriverImpl("first", "last", 0, v);
  }
}
