package edu.pdx.cs410J.whitlock;

public class Digit {
  private final String line1;
  private final String line2;
  private final String line3;

  public Digit(String line1, String line2, String line3) {
    checkThatLineHasLengthOfThree(line1);

    this.line1 = line1;
    this.line2 = line2;
    this.line3 = line3;
  }

  private void checkThatLineHasLengthOfThree(String line) {
    int length = line.length();
    if (length != 3) {
      String message = "Line should have length of 3, not" + length + "\"" + line + "\"";
      throw new IllegalArgumentException(message);
    }
  }

  public boolean isValid() {
    throw new UnsupportedOperationException();
  }

  public char getDigitChar() {
    for (KnownDigit known : KnownDigit.values()) {
      if (this.hasSameLinesAs(known)) {
        return known.getDigitChar();
      }
    }

    throw new IllegalStateException("This digit is not valid");
  }

  private boolean hasSameLinesAs(KnownDigit known) {
    return this.line1.equals(known.line1) &&
      this.line2.equals(known.line2) &&
      this.line3.equals(known.line3);
  }
}
