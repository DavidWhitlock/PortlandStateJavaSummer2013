package edu.pdx.cs410J.whitlock;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
  private List<Digit> digits = new ArrayList<Digit>(9);

  public BankAccount(String line1, String line2, String line3) {
    checkThatLineHasLengthOf27("First", line1);
    checkThatLineHasLengthOf27("Second", line2);
    checkThatLineHasLengthOf27("Third", line3);

    extractDigits(line1, line2, line3);
  }

  private void extractDigits(String line1, String line2, String line3) {
    for (int i = 0; i < 27; i += 3) {
      String chunk1 = line1.substring(i, i + 3);
      String chunk2 = line2.substring(i, i + 3);
      String chunk3 = line3.substring(i, i + 3);

      digits.add(new Digit(chunk1, chunk2, chunk3));
    }
  }

  private void checkThatLineHasLengthOf27(String ordinal, String line) {
    int length = line.length();
    if (length != 27) {
      String message = ordinal + " line should have length of 27, not" + length + "\"" + line + " \"";
      throw new IllegalArgumentException(message);
    }
  }


  public String getDigitChars() {
    StringBuilder sb = new StringBuilder();
    for (Digit digit : digits) {
      sb.append(digit.getDigitChar());
    }

    return sb.toString();
  }

  public boolean hasValidChecksum() {
    return getChecksum() == 0;
  }

  /**
   * (d1+2*d2+3*d3 +..+9*d9) mod 11 = 0
   *
   */
  private int getChecksum() {
    int checksum = 0;
    for (int i = 1; i <= digits.size(); i++) {
      Digit digit = digits.get(digits.size() - i);
      checksum += (i * digit.getDigitInt());
    }

    return checksum % 11;
  }

  public BankAccountStatus getStatus() {
    if (!containsAllKnownDigits()) {
      return BankAccountStatus.ILLEGAL;

    } else if (!hasValidChecksum()) {
      return BankAccountStatus.ERROR;

    } else {
      return BankAccountStatus.LEGAL;
    }
  }

  private boolean containsAllKnownDigits() {
    for (Digit digit : digits) {
      if (!digit.isKnownDigit()) {
        return false;
      }
    }

    return true;
  }
}
