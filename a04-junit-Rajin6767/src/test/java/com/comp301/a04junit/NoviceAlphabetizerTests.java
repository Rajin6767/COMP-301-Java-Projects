package com.comp301.a04junit;

import static org.junit.Assert.*;

import com.comp301.a04junit.alphabetizer.Alphabetizer;
import java.util.NoSuchElementException;
import org.junit.Assert;
import org.junit.Test;

/** Write tests for the Alphabetizer class here */
public class NoviceAlphabetizerTests {
  @Test
  public void testNext() {
    String[] testStr = new String[] {"b", "a", "c"};
    String[] copy = new String[] {"b", "a", "c"};
    Alphabetizer test = new Alphabetizer(testStr);
    assertEquals("a", test.next());
    assertEquals("b", test.next());
    assertEquals("c", test.next());
    try {
      test.next();
      Assert.fail("Exception should have been thrown");
    } catch (NoSuchElementException nse) {
      Assert.assertTrue(true);
    }
  }

  @Test
  public void testNextCapitalized() {
    Alphabetizer test = new Alphabetizer(new String[] {"B", "A", "C"});
    assertEquals("A", test.next());
    assertEquals("B", test.next());
    assertEquals("C", test.next());
    try {
      test.next();
      Assert.fail("Exception should have been thrown");
    } catch (NoSuchElementException nse) {
      Assert.assertTrue(true);
    }
  }

  @Test
  public void testHasNext() {
    Alphabetizer test = new Alphabetizer(new String[] {"b", "a", "c"});
    assertTrue(test.hasNext());
    test.next();
    assertTrue(test.hasNext());
    test.next();
    assertTrue(test.hasNext());
    test.next();
    assertFalse(test.hasNext());
  }

  @Test
  public void testNull() {
    Alphabetizer test = new Alphabetizer(null);
  }

  @Test
  public void testMutate() {
    String[] testStr = new String[] {"b", "a", "c"};
    String[] copy = new String[] {"b", "a", "c"};
    Alphabetizer test = new Alphabetizer(testStr);
    assertEquals("a", test.next());
    assertEquals("b", test.next());
    assertEquals("c", test.next());
    Assert.assertArrayEquals(testStr, copy);
  }
}
