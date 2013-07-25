package edu.pdx.cs410J.whitlock;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class BankAccountTest
{

  @Ignore
  @Test
  public void account123456789IsValid() {
    String line1 = "    _  _     _  _  _  _  _";
    String line2 = "  | _| _||_||_ |_   ||_||_|";
    String line3 = "  ||_  _|  | _||_|  ||_| _| ";
    BankAccount account = new BankAccount(line1, line2, line3);
    assertTrue(account.isValid());
  }
}
