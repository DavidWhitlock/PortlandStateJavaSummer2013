package edu.pdx.cs410J.whitlock;

import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class BankAccountReader {
  public List<BankAccount> readAccounts(Reader reader) throws IOException {
    LineNumberReader lnr = new LineNumberReader(reader);
    List<BankAccount> accounts = new ArrayList<BankAccount>();

    try {
      while (lnr.ready()) {
        String line1 = lnr.readLine();
        String line2 = lnr.readLine();
        String line3 = lnr.readLine();
        String line4 = lnr.readLine();

        if (line4 != null && !line4.equals("")) {
          String message = "Line " + lnr.getLineNumber() + " should be empty \"" + line4 + "\"";
          throw new IllegalStateException(message);
        }

        try {
          accounts.add(new BankAccount(line1, line2, line3));

        } catch (IllegalArgumentException e) {
          throw new IllegalStateException("On line number " + lnr.getLineNumber(), e);
        }
      }
    } catch (IOException e) {
      throw new IOException("On line number " + lnr.getLineNumber(), e);
    }

    return accounts;
  }
}
