package edu.pdx.cs410J.whitlock;

import edu.pdx.cs410J.lang.Human;

import java.util.ArrayList;
                                                                                    
/**                                                                                 
 * This class is represents a <code>Student</code>.                                 
 */                                                                                 
public class Student extends Human {

  static final String USAGE_MESSAGE = "args are (in this order)\n" +
    "  name \n" +
    "  gender \n" +
    "  gpa \n" +
    "  classes";
  static final String MISSING_GPA = "Missing GPA";

  private double gpa;

  /**
   * Creates a new <code>Student</code>                                             
   *                                                                                
   * @param name                                                                    
   *        The student's name                                                      
   * @param classes                                                                 
   *        The names of the classes the student is taking.  A student              
   *        may take zero or more classes.                                          
   * @param gpa                                                                     
   *        The student's grade point average                                       
   * @param gender                                                                  
   *        The student's gender ("male" or "female", case insensitive)
   *
   * @throws IllegalStudentArgumentException
   *         GPA is negative
   */                                                                               
  public Student(String name, ArrayList classes, double gpa, String gender)
    throws IllegalStudentArgumentException {

    super(name);

    if (gpa < 0.0) {
      throw new IllegalStudentArgumentException("Invalid GPA: " + gpa);
    }

    this.gpa = gpa;
  }

  /**                                                                               
   * All students say "This class is too much work"                                 
   */
  @Override
  public String says() {                                                            
    return "This class is too much work";
  }
                                                                                    
  /**                                                                               
   * Returns a <code>String</code> that describes this                              
   * <code>Student</code>.                                                          
   */                                                                               
  public String toString() {
    return name + " has a GPA of " + gpa + " and is taking 0 classes.  " +
            "He says \"" + says() + "\".";
  }

  /**
   * Main program that parses the command line, creates a
   * <code>Student</code>, and prints a description of the student to
   * standard out by invoking its <code>toString</code> method.
   */
  public static void main(String[] args) {

    String name = null;
    ArrayList classes = null;
    double gpa = 0.0;
    String gender = null;

    switch (args.length) {
      case 0:
        printErrorMessageAndExit("Missing command line arguments");
        break;

      case 1:
        printErrorMessageAndExit("Missing Gender");
        break;

      case 2:
        printErrorMessageAndExit(MISSING_GPA);
        break;

      case 3:
        name = args[0];
        gender = args[1];
        gpa = Double.parseDouble(args[2]);
    }

    Student student;
    try {
      student = new Student(name, classes, gpa, gender);

    } catch (IllegalStudentArgumentException ex) {
      printErrorMessageAndExit(ex.getMessage());
      return;
    }

    System.out.print(student.toString());
    System.exit(0);
  }

  private static void printErrorMessageAndExit(String errorMessage) {
    System.err.println(errorMessage);
    System.err.println(USAGE_MESSAGE);
    System.exit(1);
  }
}