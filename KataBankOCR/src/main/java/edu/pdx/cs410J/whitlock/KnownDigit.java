package edu.pdx.cs410J.whitlock;

public enum KnownDigit {
  DIGIT_0(
    " _ ",
    "| |",
    "|_|",
    '0'
  ),

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
  ),

  DIGIT_3(
    " _ ",
    " _|",
    " _|",
    '3'
  ),

  DIGIT_4(

    "   ",
    "|_|",
    "  |",
    '4'
  ),

  DIGIT_5(
    " _ ",
    "|_ ",
    " _|",
    '5'
  ),

  DIGIT_6(
    " _ ",
    "|_ ",
    "|_|",
    '6'
  ),

  DIGIT_7(
    " _ ",
    "  |",
    "  |",
    '7'
  ),

  DIGIT_8(
    " _ ",
    "|_|",
    "|_|",
    '8'
  ),

  DIGIT_9(
    " _ ",
    "|_|",
    " _|",
    '9'
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

  public char getDigitChar() {
    return charValue;
  }
}
