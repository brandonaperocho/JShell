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

import java.util.Scanner;

/**
 * InputTaker - Used to collect input from user
 */
public class InputTaker {
  /**
   * LinkedList that contains history of all input
   */
  private LinkedList historyListIT;
  private Directory mainDir;

  // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

  /**
   * Constructor for InputTaker
   * 
   * @param list A LinkedList of input history
   */
  public InputTaker(LinkedList list, Directory main) {
    historyListIT = list;
    mainDir = main;
  }

  // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

  /**
   * Asks the user for input
   * 
   * @return String[] An array of all input separated on whitespace
   */
  public String[] input() {
    // Begins prompting for input
    String lineInput;
    Scanner in = new Scanner(System.in);
    if (mainDir.getFullPath().equals("/")) {
      System.out.print("#" + mainDir.getFullPath() + " ");
    } else {
      System.out.print("#" + mainDir.getFullPath() + "/ ");
    }
    lineInput = in.nextLine();
    // Adds the user input to the History LinkedList
    if (lineInput.length() > 0) {
      historyListIT.add(lineInput);
    }
    // Creates a formatted array of the input, separated on whitespace
    lineInput = lineInput.trim();
    String[] allWords = lineInput.split("\\s+");
    return allWords; // Returns this array of input
  }
}
