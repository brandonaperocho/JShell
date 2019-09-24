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
 * <h1> Class PopD </h1>
 * PopD is a class used to followed the singleton design pattern and 
 * polymorphism. This class uses a stack and pops the top most item from the 
 * stack and CDs to that item; thus following the LIFO principle. 
 * 
 */

public class PopD implements DirectoryCommand {
  /**
   * Main Directory from JShell
   */
  private Directory main; // Main Directory from JShell 
  /**
   * Root Directory from JShell
   */
  private Directory root; // Root Directory from JShell
  /**
   * Stack from JShell
   */
  private LinkedList popdLL; // Stack from JShell
  /**
   * The changed Directory once popped
   */
  private Directory changedDir; // Changed directory after popping top most item

  /**
   * 
   * @param curDir --> Main Directory that JShell uses
   * @param r --> Root Directory that JShell uses
   * @param l --> The stack that JShell uses
   */
  
  public PopD(Directory curDir, Directory r, LinkedList l) {
    main = curDir;
    root = r;
    popdLL = l;
  }
  
  /**
   * When all params are met, pops the top most item and CDs to that path and 
   * returns. If the stack is empty, do not do anything and just returns the 
   * main.
   */
  @Override
  public Directory execute() { // Pops the top most item in stack and CDs to it
    if (popdLL.getSize() > 0) { // As long as the stack is not empty
      ChangeDirectory tempDir = new ChangeDirectory 
          (main, root, (String)popdLL.pop());
      
      changedDir = tempDir.execute(); // New changed Directory
      
      if (!main.getFullPath().equals(changedDir.getFullPath())) {
        return changedDir; // Returns new Directory given not the same as main
      }
      else {
        System.out.println("No change was made to the Directory!");
      }
    }
    else {
      System.out.println ("Stack was empty and Directory was not changed!");
      return main; // Proper error message for when stack is empty
    }
    return main; 
  }
}
