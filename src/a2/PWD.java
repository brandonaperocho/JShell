// **********************************************************
// Assignment2:
// Student1: Brandon Aperocho
// UTOR user_name: aperocho
// UT Student #: 1000763774
// Author: Brandon Aperocho
//
// Student2: Mateusz Rogozinski
// UTOR user_name: rogozin3
// UT Student #: 1000846203
// Author: Mateusz Rogozinski
//
// Student3: Kwame Koram
// UTOR user_name: koramkwa
// UT Student #: 1001960693
// Author: Kwame Koram
//
// Student4: Brian Vu
// UTOR user_name: vubrian
// UT Student #: 1001210281
// Author: Brian Vu
//
//
// Honor Code: I pledge that this program represents my own
// program code and that I have coded on my own. I received
// help from no one in designing and debugging my program.
// I have also read the plagiarism section in the course info
// sheet of CSC 207 and understand the consequences.
// *********************************************************
package a2;

/**
 * PWD Class --> prints out the current working directory upon execution
 */
public class PWD implements Command {
  private String workingDirectory;

  /**
   * Constructor --> Constructs a string of the full path of parameter dir
   * 
   * @param dir The directory we want the path of.
   * 
   */
  public PWD(Directory dir) {
    workingDirectory = dir.getFullPath();
  }

  /**
   * Implementation of execute method for this command. Will print out
   * the working directory
   * @return 
   */
  @Override
  public String execute() {
    return (workingDirectory); 
  }
}
