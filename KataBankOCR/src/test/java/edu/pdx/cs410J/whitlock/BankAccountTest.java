package edu.pdx.cs410J.whitlock;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Unit test for simple App.
 */
public class BankAccountTest
{

  @Test(expected = IllegalArgumentException.class)
  public void firstLineLessThan27CharactersThrowsIllegalArgumentException() {
    String line1 = "";
    String line2 = "  | _| _||_||_ |_   ||_||_|";
    String line3 = "  ||_  _|  | _||_|  ||_| _| ";
    new BankAccount(line1, line2, line3);
  }

  @Ignore
  @Test
  public void account123456789IsValid() {
    String line1 = "    _  _     _  _  _  _  _";
    String line2 = "  | _| _||_||_ |_   ||_||_|";
    String line3 = "  ||_  _|  | _||_|  ||_| _| ";
    BankAccount account = new BankAccount(line1, line2, line3);
    assertThat(account.getDigitChars(), equalTo("123456789"));
  }
}
