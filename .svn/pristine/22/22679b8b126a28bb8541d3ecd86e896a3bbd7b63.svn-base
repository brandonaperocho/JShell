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
package driver;


import a2.InputTaker;
import a2.LinkedList;
import a2.Directory;
import a2.HandleCase;


/**
 * 
 * <h1>JShell</h1> Main driver for complete project. Continuously ask user for
 * input and execute
 */
public class JShell {
  /**
   * Drives the whole class JShell
   * 
   * @param args
   */
  public static void main(String[] args) {
    Directory root = new Directory(); // root directory
    Directory main = root; // main or current directory
    LinkedList historyList = new LinkedList(); // holds all the history
    LinkedList pushPopStack = new LinkedList(); // stack of directories
    boolean continueProgram = true; // decides if program will continue to run
    while (continueProgram) {
      InputTaker w = new InputTaker(historyList, main); // call InputTaker
      String[] allWords = w.input(); // calls the method to get user input
      HandleCase decidePath =
          new HandleCase(allWords, main, root, historyList, pushPopStack);
      // calls the class that decides which command will be triggered, if any
      if (decidePath.findCommand()) {
        decidePath.executeCommand();
        continueProgram = true;
      } else if (decidePath.findDirCommand()) {
        main = decidePath.executeDirCommand();
        continueProgram = true;
      } else if (allWords[0].equals("")) { // whitespace or blank line input
        continue;
      } else if (allWords[0].equals("exit") && allWords.length == 1) { // exit
        continueProgram = false;
      } else { // invalid input
        System.out.println("Invalid command, please try again");
      }
    }
  }
}
