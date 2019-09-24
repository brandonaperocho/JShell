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
 * <h1> Class PreviousCommand </h1>
 * This class is a command used in JShell to allow the user to use previous
 * commands they have inputed so that they would not have to type it again.  
 * 
 */
public class PreviousCommand implements DirectoryCommand {
  /**
   * This is an array of the input entered by a user, separated on whitespace.
   */
  private String[] inputFromUser;
  /**
   * The main Directory from JShell
   */
  private Directory main;
  /**
   * The root Directory from JShell
   */
  private Directory r;
  /**
   * The history LinkedList from JShell
   */
  private LinkedList historyListPC;
  /**
   * The Pushd and Popd stack from JShell
   */
  private LinkedList pushDPopDStackPC;
  /**
   * The number specified after the '!' character
   */
  private int getNumber;
  /**
   * The previous input from the user from the history LinkedList
   */
  private String getOldInput;

  /**
   * Constructor 
   * @param inputRec --> Input from the user given by an array
   * @param curr --> main Directory
   * @param root --> root Directory
   * @param l1 --> History list
   * @param l2 --> Pushd & Popd Stack (LinkedList)
   */
  public PreviousCommand(String[] inputRec, Directory curr, Directory root,
      LinkedList l1, LinkedList l2) {

    inputFromUser = inputRec;
    main = curr;
    r = root;
    historyListPC = l1;
    pushDPopDStackPC = l2;
  }

  /**
   * Finds the command inputed at that the nth position in the history list then
   * executes that command. If it is a !number command, will iterate until it
   * finds a non !number command.
   */
  public Directory execute() {
    getNumber = Integer.parseInt(inputFromUser[0].substring(1)); // Gets number
    if (getNumber < historyListPC.getSize()) { // Checks if number is valid
      getOldInput = (String) historyListPC.peekAtPoint(getNumber);
      getOldInput.trim(); // Trims the previous command to be readable
      String[] allWords = getOldInput.split("\\s+"); // Splits at the space
      HandleCase decidePath = // Used to decide which command to use
          new HandleCase(allWords, main, r, historyListPC, pushDPopDStackPC);
      if (decidePath.findCommand()) { // Finds non DirectoryCommand
        decidePath.executeCommand();
        return main;
      } else if (decidePath.findDirCommand()) { // finds DirectoryCommand
        return decidePath.executeDirCommand();
      }
    } else {
      System.out.println("Number given too large!"); // If number is too large
    }
    System.out.println("Invalid command, please try again");
    return main;
  }
}
