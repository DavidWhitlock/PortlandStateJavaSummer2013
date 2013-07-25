package edu.pdx.cs410J.whitlock;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
  private List<Digit> digits = new ArrayList<Digit>(9);

  public BankAccount(String line1, String line2, String line3) {
    checkThatLineHasLengthOf27(line1);
    checkThatLineHasLengthOf27(line2);
    checkThatLineHasLengthOf27(line3);

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

  private void checkThatLineHasLengthOf27(String line) {
    int length = line.length();
    if (length != 27) {
      String message = "Line should have length of 27, not" + length + "\"" + line + "\"";
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
}
