package edu.pdx.cs410J.whitlock;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DigitTest {

  @Test(expected = IllegalArgumentException.class)
  public void firstLineIsLessThan3Characters() {
    new Digit("", "   ", "   ");
  }

  @Test(expected = IllegalArgumentException.class)
  public void firstLineIsGreaterThan3Characters() {
    new Digit("12345", "   ", "   ");
  }

  @Test
  public void digit0IsValidDigit() {
    String line1 = " _ ";
    String line2 = "| |";
    String line3 = "|_|";
    Digit digit = new Digit(line1, line2, line3);

    assertThat(digit.getDigitChar(), equalTo('0'));
  }

  @Test
  public void digit1IsValidDigit() {
    String line1 = "   ";
    String line2 = "  |";
    String line3 = "  |";
    Digit digit = new Digit(line1, line2, line3);

    assertThat(digit.getDigitChar(), equalTo('1'));
  }

  @Test
  public void digit2IsValidDigit() {
    String line1 = " _ ";
    String line2 = " _|";
    String line3 = "|_ ";
    Digit digit = new Digit(line1, line2, line3);

    assertThat(digit.getDigitChar(), equalTo('2'));
  }

  @Test
  public void digit3IsValidDigit() {
    String line1 = " _ ";
    String line2 = " _|";
    String line3 = " _|";
    Digit digit = new Digit(line1, line2, line3);

    assertThat(digit.getDigitChar(), equalTo('3'));
  }

  @Test
  public void digit4IsValidDigit() {
    String line1 = "   ";
    String line2 = "|_|";
    String line3 = "  |";
    Digit digit = new Digit(line1, line2, line3);

    assertThat(digit.getDigitChar(), equalTo('4'));
  }

  @Test
  public void digit5IsValidDigit() {
    String line1 = " _ ";
    String line2 = "|_ ";
    String line3 = " _|";
    Digit digit = new Digit(line1, line2, line3);

    assertThat(digit.getDigitChar(), equalTo('5'));
  }

  @Test
  public void digit6IsValidDigit() {
    String line1 = " _ ";
    String line2 = "|_ ";
    String line3 = "|_|";
    Digit digit = new Digit(line1, line2, line3);

    assertThat(digit.getDigitChar(), equalTo('6'));
  }

  @Test
  public void digit7IsValidDigit() {
    String line1 = " _ ";
    String line2 = "  |";
    String line3 = "  |";
    Digit digit = new Digit(line1, line2, line3);

    assertThat(digit.getDigitChar(), equalTo('7'));
  }

  @Test
  public void digit8IsValidDigit() {
    String line1 = " _ ";
    String line2 = "|_|";
    String line3 = "|_|";
    Digit digit = new Digit(line1, line2, line3);

    assertThat(digit.getDigitChar(), equalTo('8'));
  }

  @Test
  public void digit9IsValidDigit() {
    String line1 = " _ ";
    String line2 = "|_|";
    String line3 = " _|";
    Digit digit = new Digit(line1, line2, line3);

    assertThat(digit.getDigitChar(), equalTo('9'));
  }

}
