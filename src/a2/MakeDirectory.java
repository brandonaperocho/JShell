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
 * <h1>MakeDirectory</h1> The MakeDirectory class' function is to create a
 * directory specified by the user (either local, absolute or relative path).
 * Will return an updated directory with the new directory added.
 */
public class MakeDirectory implements DirectoryCommand {
  /**
   * The path of the new directory to be added.
   */
  private String newDir;
  /**
   * The current working directory.
   */
  private Directory current;
  /**
   * The root directory.
   */
  private Directory rootD;
  /**
   * Array of the path, separated on instances of /.
   */
  private String[] separated;
  /**
   * The last directory in the path. (The one we want to make)
   */
  private String lastDir;
  /**
   * The directory path we need to take in order to create the new directory.
   */
  private String fPath;
  /**
   * If a new directory has not yet been made.
   */
  private boolean trigger;
  /**
   * If this new directory has been created without any problems.
   */
  private boolean wasCreated;


  // ==========================================================================

  /**
   * Constructor -> Create an array of strings that contains the path name
   * separated on instances of /. Then get the last directory in this array,
   * which will be the directory we wish to create.
   * 
   * @param dirName - Path of new Directory
   * @param dirCurrent - Current Directory
   * @param root - Root Directory
   */
  public MakeDirectory(String dirName, Directory dirCurrent, Directory root) {
    newDir = dirName;
    String toSeparate = dirName;
    current = dirCurrent;
    rootD = root;
    if (dirName.startsWith("/")) {
      toSeparate = dirName.substring(1);
    }
    separated = toSeparate.split("/");
    lastDir = separated[separated.length - 1];
    trigger = true;
    wasCreated = true;
  }

  // ==========================================================================

  /**
   * This method checks to see if this directory to be created has a valid name.
   * (no special characters)
   * 
   * @return isValid (boolean)
   */
  public boolean isValid() {
    boolean valid = false;
    if (lastDir.matches("^[a-zA-Z0-9]+$")) {
      valid = true;
    }
    return valid;
  }

  // ==========================================================================

  /**
   * This method checks to see if this directory was actually created without
   * encountering any problems.
   * 
   * @return wasCreated (boolean)
   */
  public boolean getCreated() {
    return wasCreated;
  }

  // ==========================================================================

  /**
   * This method attempts to construct this new directory within the current
   * directory that was passed. It will attempt to add it in situations where it
   * is local, absolute, and relative paths. If the addition does not succeed,
   * then the unmodified directory is returned.
   * 
   * @return current (Directory)
   */
  public Directory constructDir() {
    if (isValid()) { // Case that no special chars are in the directory name
      // If it is to be created within the local directory
      if (separated.length == 1 && !current.containsDirectory(lastDir)
          && !current.containsFile(lastDir) && !newDir.startsWith("/")) {
        current.addDirectory(new Directory(lastDir, current));
        trigger = false;
        // If it begins with / -> an absolute path
      } else if (newDir.startsWith("/")) {
        if (newDir.length() == lastDir.length() + 1) {
          fPath = "/";
        } else {
          fPath = newDir.substring(0, newDir.length() - (lastDir.length() + 1));
        }
        // If it doesn't start with / and is not local -> a relative path
      } else if (!newDir.startsWith("/") && separated.length > 1) {
        if (current.getFullPath().equals("/")) {
          fPath = current.getFullPath()
              + newDir.substring(0, newDir.length() - (lastDir.length() + 1));
        } else {
          fPath = current.getFullPath() + "/"
              + newDir.substring(0, newDir.length() - (lastDir.length() + 1));
        }
        // All other possible situations
      } else {
        trigger = false;
        wasCreated = false;
      }
      if (trigger) { // If it has not yet been created (the directory)
        ChangeDirectory x = new ChangeDirectory(current, rootD, fPath);
        // Make sure something with that name is not already contained
        if (!x.execute().containsDirectory(lastDir)
            && !x.execute().containsFile(lastDir) && x.isValid()) {
          Directory temp = current;
          current = x.execute();
          current.addDirectory(new Directory(lastDir, current));
          String changeBack = temp.getFullPath();
          ChangeDirectory y = new ChangeDirectory(current, rootD, changeBack);
          current = y.execute();
          // We modify our previous directory to now have the new one added
        } else {
          wasCreated = false;
        }
      }
    } else {
      wasCreated = false;
    }
    return current;
    // Return this (possibly) new directory
  }

  // ==========================================================================

  /**
   * Implementation of execute() method of the DirectoryCommand interface. Will
   * return a dictionary with the newly created directory added, or one that has
   * not been modified.
   */
  public Directory execute() {
    constructDir();
    if (getCreated()) {
      return current;
    } else {
      System.out.println(newDir + " could not be made!");
      return current;
    }
  }
}


