package edu.pdx.cs410J.whitlock;

public class BankAccount {
  public BankAccount(String line1, String line2, String line3) {
    checkThatLineHasLengthOf27(line1);
    checkThatLineHasLengthOf27(line2);
    checkThatLineHasLengthOf27(line3);
  }

  private void checkThatLineHasLengthOf27(String line) {
    int length = line.length();
    if (length != 27) {
      String message = "Line should have length of 27, not" + length + "\"" + line + "\"";
      throw new IllegalArgumentException(message);
    }
  }


  public String getDigitChars() {
    throw new UnsupportedOperationException();
  }
}
