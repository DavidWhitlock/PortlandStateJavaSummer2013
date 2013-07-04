package edu.pdx.cs410J.whitlock;

import edu.pdx.cs410J.InvokeMainTestCase;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringContains.containsString;

/**
 * JUnit tests for the Student class.  These tests extend <code>InvokeMainTestCase</code>
 * which allows them to easily invoke the <code>main</code> method of <code>Student</code>.
 * They also make use of the <a href="http://hamcrest.org/JavaHamcrest/">hamcrest</a>matchers
 * for more readable assertion statements.
 */
public class StudentTest extends InvokeMainTestCase
{

  private MainMethodResult invokeMain(String... args) {
    return invokeMain(Student.class, args);
  }

  @Test
  public void noArgumentsHasExitCodeOf1() {
    MainMethodResult result = invokeMain();
    assertThat(result.getExitCode(), equalTo(1));
  }

  @Test
  public void noArgumentsPrintsMissingArgumentsToStandardError() {
    MainMethodResult result = invokeMain();
    assertThat(result.getErr(), containsString("Missing command line arguments"));
  }

  @Test
  public void missingGenderPrintsMissingGenderToStandardError() {
    MainMethodResult result = invokeMain("Dave");
    assertThat(result.getErr(), containsString("Missing Gender"));
  }

  public void invalidCommandLinePrintUsageInformation() {

  }

  @Ignore
  @Test
  public void exampleCommandLineFromAssignmentPrintsTheRightThing() {
    MainMethodResult result = invokeMain("Dave", "male", "3.64", "Algorithms", "Operating Systems", "Java");
    String expected = "Dave has a GPA of 3.64 and is taking 3 classes: Algorithms, Operating " +
      "Systems, and Java. He says \"This class is too much work\".";
    assertThat(result.getOut(), containsString(expected));
  }

}
