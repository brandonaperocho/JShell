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
 * <h1> Class PushD </h1>
 * PushD is a class used to followed the singleton design pattern and 
 * polymorphism. This class uses a stack to save all previous current working 
 * directories at the top most position of the stack; thus following the LIFO 
 * principle. 
 * 
 */

public class PushD implements DirectoryCommand {
  /**
   * Main Directory from JShell
   */
  private Directory main; // Main directory from JShell 
  /**
   * Root Directory from JShell
   */
  private Directory root; // Root directory from JShell
  /**
   * Dir name that is CD'd into given by user
   */
  private String dirName; // Directory name provided by the user
  /**
   * Stack from JShell
   */
  private LinkedList pushdLL; // Stack from JShell
  /**
   * Changed Directory provided by user
   */
  private Directory changedDir; // The changed directory provided by user
  
  /**
   * Constructor
   * @param curDir --> The main Directory that JShell uses 
   * @param r --> The root Directory that JShell uses
   * @param nDir --> The directory that is to be CD'd to; provided by user
   * @param l --> The PushPopStack that JShell uses
   */
  
  public PushD(Directory curDir, Directory r, String nDir, LinkedList l){ 
    main = curDir;
    root = r;
    dirName = nDir;
    pushdLL = l;
    
  }
  
  /**
   * When all params are met, CDs to the the Directory that the user provides 
   * and returns that new Directory. Otherwise returns the main if no change 
   * happens.
   */
  public Directory execute(){
    ChangeDirectory tempDir = new ChangeDirectory(main, root, dirName);
    changedDir = tempDir.execute(); 
    // Changes to temporary directory provided by the user
    
    if (main.getFullPath().equals(changedDir.getFullPath())) {
      System.out.println("Current directory did not change!");
    }
    else {
      pushdLL.add(main.getFullPath()); // Adds the currentPathName into stack
      return changedDir; // Returns the new changed Directory provided by user
    }
    return main; // Returns main when no change is made
  }

}
