package edu.pdx.cs410J.whitlock;

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

  @Test
  public void account123456789CanBeParsed() {
    String line1 = "    _  _     _  _  _  _  _ ";
    String line2 = "  | _| _||_||_ |_   ||_||_|";
    String line3 = "  ||_  _|  | _||_|  ||_| _|";
    BankAccount account = new BankAccount(line1, line2, line3);
    assertThat(account.getDigitChars(), equalTo("123456789"));
  }

  @Test
  public void account000000000CanBeParsed() {
    String line1 = " _  _  _  _  _  _  _  _  _ ";
    String line2 = "| || || || || || || || || |";
    String line3 = "|_||_||_||_||_||_||_||_||_|";
    BankAccount account = new BankAccount(line1, line2, line3);
    assertThat(account.getDigitChars(), equalTo("000000000"));
  }

  @Test
  public void account345882865HasValidChecksum() {
    String line1 = " _     _  _  _  _  _  _  _ ";
    String line2 = " _||_||_ |_||_| _||_||_ |_ ";
    String line3 = " _|  | _||_||_||_ |_||_| _|";
    BankAccount account = new BankAccount(line1, line2, line3);
    assertThat(account.getDigitChars(), equalTo("345882865"));
    assertThat(account.hasValidChecksum(), equalTo(true));
  }

  @Test
  public void account457508000HasValidChecksum() {
    String line1 = "    _  _  _  _  _  _  _  _ ";
    String line2 = "|_||_   ||_ | ||_|| || || |";
    String line3 = "  | _|  | _||_||_||_||_||_|";
    BankAccount account = new BankAccount(line1, line2, line3);
    assertThat(account.getDigitChars(), equalTo("457508000"));
    assertThat(account.hasValidChecksum(), equalTo(true));
  }

  @Test
  public void account664371495DoesNotHaveValidChecksum() {
    String line1 = " _  _     _  _        _  _ ";
    String line2 = "|_ |_ |_| _|  |  ||_||_||_ ";
    String line3 = "|_||_|  | _|  |  |  | _| _|";
    BankAccount account = new BankAccount(line1, line2, line3);
    assertThat(account.getDigitChars(), equalTo("664371495"));
    assertThat(account.hasValidChecksum(), equalTo(false));
  }

  @Test
  public void account86110XX36HasILLStatus() {
    // 86110??36
    String line1 = " _  _        _  _  _  _  _ ";
    String line2 = "|_||_   |  || |  |    _||_ ";
    String line3 = "|_||_|  |  ||_| _||_| _||_|";
    BankAccount account = new BankAccount(line1, line2, line3);
    assertThat(account.getStatus(), equalTo(BankAccountStatus.ILLEGAL));
  }

  @Test
  public void account457508000HasLegalStatus() {
    String line1 = "    _  _  _  _  _  _  _  _ ";
    String line2 = "|_||_   ||_ | ||_|| || || |";
    String line3 = "  | _|  | _||_||_||_||_||_|";
    BankAccount account = new BankAccount(line1, line2, line3);
    assertThat(account.getStatus(), equalTo(BankAccountStatus.LEGAL));
  }

  @Test
  public void account664371495HasErrorStatus() {
    String line1 = " _  _     _  _        _  _ ";
    String line2 = "|_ |_ |_| _|  |  ||_||_||_ ";
    String line3 = "|_||_|  | _|  |  |  | _| _|";
    BankAccount account = new BankAccount(line1, line2, line3);
    assertThat(account.getStatus(), equalTo(BankAccountStatus.ERROR));
  }

}
