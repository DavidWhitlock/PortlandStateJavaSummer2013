package edu.pdx.cs410J.whitlock;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class BankAccountReaderTest {

  @Test
  public void canFindValidBankAccountsFile() {
    InputStream stream = this.getClass().getResourceAsStream("validBankAccounts.txt");
    assertThat(stream, notNullValue());
  }

  @Test
  public void canParseAllExampleBankAccounts() throws IOException {
    InputStream stream = this.getClass().getResourceAsStream("validBankAccounts.txt");
    BankAccountReader reader = new BankAccountReader();
    List<BankAccount> accounts = reader.readAccounts(new InputStreamReader(stream));
    assertThat(accounts.size(), equalTo(11));

    for (int i = 0; i <= 9; i++) {
      assertThatBankAccountAtIndexAsNineDigitsAllTheSame(accounts, i);
    }

    assertThatBankAccountAtIndexHasAccountDigits(accounts, 10, "123456789");
  }

  private void assertThatBankAccountAtIndexHasAccountDigits(List<BankAccount> accounts, int index, String accountDigits) {
    assertThat(accounts.get(index).getDigitChars(), equalTo(accountDigits));
  }

  private void assertThatBankAccountAtIndexAsNineDigitsAllTheSame(List<BankAccount> accounts, int index) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 9; i++) {
      sb.append(String.valueOf(index));
    }
    String accountDigits = sb.toString();
    assertThatBankAccountAtIndexHasAccountDigits(accounts, index, accountDigits);
  }

}
