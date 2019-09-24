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
 * This is a class that changes the current working directory in JShell Changes
 * to directory specified by user (either absolute or relative path) Returns
 * changed directory (or unchanged one if there is an error) upon execution
 */
public class ChangeDirectory implements DirectoryCommand {


  private String pathName; // path provided by user
  private Directory curWDir; // current working directory at start
  private Directory curWDirCopy; // to save current working directory in case of
                                 // error
  private Directory rootDir; // root directory of JShell file system
  private String[] arrOfDirs; // split array of each directory/file in path
                             // provided
  private boolean mainFlag; // if false, there is an error

  /**
   * Constructor --> Initializes global variables described above
   * 
   * @param initDir --> current working directory provided by JShell
   * @param root --> root directory of JShell
   * @param newDir --> path provided by user to be changed into.
   */
  public ChangeDirectory(Directory initDir, Directory root, String newDir) {
    pathName = newDir;
    curWDir = initDir;
    curWDirCopy = curWDir;
    rootDir = root;
    String toSeparate = pathName;
    if (pathName.startsWith("/")) {
      toSeparate = pathName.substring(1); // Ignore 1st / to avoid empty string
    }
    arrOfDirs = toSeparate.split("/");
  }

  /**
   * Returns mainFlag, which is true if there is no error in path provided by
   * user, and false if there is an error.
   * 
   * @return
   */
  public boolean isValid() {
    return mainFlag;
  }

  /**
   * Implementation of execute() method of directory command interface Will
   * return either the new directory we have changed into, or the unchanged
   * current working directory if there is an error
   */
  @Override
  public Directory execute() {
    mainFlag = true;
    Directory current = curWDir; // assume relative path
    if (pathName.startsWith("/")) {
      current = rootDir; // absolute path
    }
    if (!pathName.equals("/")) {
      for (int i = 0; arrOfDirs.length > i; i++) {

        if (mainFlag == true) {
          if (arrOfDirs[i].equals("..")) {
            if (current.getName().equals("/")) {
              mainFlag = false; // parent of root is invalid
            }
            current = current.getParent();
          } else if (current.containsDirectory(arrOfDirs[i])
              && !arrOfDirs[i].equals(".")) {
            current = current.getChildDirectory(arrOfDirs[i]);
          } else if (!arrOfDirs[i].equals(".")) {
            mainFlag = false; // path is wrong (inexistent directory)
          }
        }
      }
    }
    if (mainFlag == true) {
      return current;
    } else {
      return curWDirCopy;
    }
  }
}
