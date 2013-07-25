package edu.pdx.cs410J.whitlock;

public enum KnownDigit {
  DIGIT_1(
    "   ",
    "  |",
    "  |",
    '1'
  ),

  DIGIT_2(
    " _ ",
    " _|",
    "|_ ",
    '2'
  )

  ;

  final String line1;
  final String line2;
  final String line3;
  private final char charValue;

  KnownDigit(String line1, String line2, String line3, char charValue) {
    this.line1 = line1;
    this.line2 = line2;
    this.line3 = line3;
    this.charValue = charValue;
  }

  public char getCharValue() {
    return charValue;
  }
}