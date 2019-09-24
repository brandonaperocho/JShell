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
 * <h1>Move</h1> The move class' function is to move a specified file/directory
 * to a specified location. Will return an updated directory with the move
 * performed.
 */
public class Move implements DirectoryCommand {
  /**
   * The current working directory.
   */
  private Directory main;
  /**
   * The root directory.
   */
  private Directory root;
  /**
   * The file/directory to be copied.
   */
  private String initPath;
  /**
   * The location where a copy should be moved to.
   */
  private String newPath;
  /**
   * The location of the file/directory to be copied.
   */
  private String initial;
  /**
   * File/Directory that will be getting copied.
   */
  private String toBeMoved;
  /**
   * Parent of the copy location.
   */
  private String newP;
  /**
   * The file/directory at the copy location.
   */
  private String checkFile;
  /**
   * This will be used to switch into the initial directory if the current
   * working directory was a sub-directory of the directory that was moved.
   */
  private String temp;
  /**
   * Full path of object to be moved.
   */
  private String t1;
  /**
   * Full path of new location.
   */
  private String t2;

  // =========================================================================

  /**
   * Constructor -> Assign the main variables that will be used in moving one
   * file/directory to another another location.
   * 
   * @param mainDir - current working directory
   * @param rootDir - root directory
   * @param oP - item to be moved
   * @param nP - location to be moved into
   */
  public Move(Directory mainDir, Directory rootDir, String oP, String nP) {
    main = mainDir;
    root = rootDir;
    initPath = oP;
    newPath = nP;
  }

  // =========================================================================

  /**
   * This method will attempt to move ONLY DIRECTORIES. If the move can not be
   * performed, an appropriate error will be printed.
   * 
   * @return main (current working directory either with or without the newly
   *         moved item)
   */
  public Directory moveDir() {
    ChangeDirectory tempOldAct2 = new ChangeDirectory(main, root, initPath);
    ChangeDirectory tempNew2 = new ChangeDirectory(main, root, newPath);
    Directory tempOldAct = tempOldAct2.execute();
    Directory tempNew = tempNew2.execute();
    // Creates two directories, for the old location, and the new
    if (tempOldAct2.isValid() && tempNew2.isValid()
        && !tempOldAct.getName().equals("/")
        && !tempNew.getFullPath().contains(tempOldAct.getFullPath())) {
      // If directories are valid
      t1 = tempOldAct.getParent().getFullPath();
      t2 = tempNew.getParent().getFullPath();
      // The full paths of these two directories
      toBeMoved = tempOldAct.getName(); // Directory to be moved
      Directory tempOld = tempOldAct.getParent();
      Directory x = new CopyItem(tempOldAct, tempNew).returnDirectory();
      // Create a copy of the (Directory to be moved)'s parent
      tempOld.removeDirectory(toBeMoved); // Remove from the old location
      tempOldAct.changeParent(x.getParent()); // Change it's parent to the new
      // If it contains a directory of the same name (of the moving directory)
      if (tempNew.containsDirectory(toBeMoved)) {
        tempNew.removeDirectory(toBeMoved); // Remove the old directory
      }
      tempNew.addDirectory(x); // Add the new moved directory
    } else { // If something is not valid, print an error
      System.out.println("Can't move " + initPath + " into " + newPath + "!");
      return main;
    }
    // This will execute if the current working directory gets its path
    // changed as a result of the move
    if (!main.getFullPath().equals("/") && main.getFullPath().contains(t1)
        && !t1.equals(t2)) {
      if (t1.equals("/")) {
        temp = main.getFullPath().substring(t1.length());
      } else {
        temp = main.getFullPath().substring(t1.length() + 1);
      }
      Directory finalz = new ChangeDirectory(tempNew, root, temp).execute();
      return finalz;
      // This above code will return a directory that is reflective of what the
      // initial working directory was. If working directory was changed
      // because it was a sub-directory of the directory being moved, then its
      // path must be changed to correctly reflect the move
    } else {
      return main;
    }
  }

  // =========================================================================

  /**
   * This method is used to get any certain paths that will be used in the
   * process of copying a file.
   */
  public void getNames() {
    initial = new GetFullPath(main, initPath).getWithoutLast();
    newP = new GetFullPath(main, newPath).getWithoutLast();
    checkFile = new GetFullPath(main, newPath).getLast();
    toBeMoved = new GetFullPath(main, initPath).getLast();
  }

  // =========================================================================

  /**
   * This method will attempt to move ONLY FILES. If the move can not be
   * performed, an appropriate error will be printed.
   * 
   * @return main (current working directory either with or without the newly
   *         moved item)
   */
  public Directory moveFile() {
    getNames();
    if (!toBeMoved.equals("/")) { // Only move if it's not the root
      Directory temp = new ChangeDirectory(main, root, initial).execute();
      if (temp.containsFile(toBeMoved)) { // Make sure it contains that FILE
        File tempMove = temp.getChildFile(toBeMoved);
        Directory check = new ChangeDirectory(main, root, newP).execute();
        if (check.containsFile(checkFile)) { // If the location is a file
          temp.removeFile(toBeMoved); // Remove it from original location
          File fileExists = check.getChildFile(checkFile);
          fileExists.overwriteContents(tempMove.getContents());
          return main; // Overwrite the contents of the file at the location
        } // Otherwise we move into the directory at that location
        ChangeDirectory x = new ChangeDirectory(main, root, newPath);
        Directory newer = x.execute();
        if (x.isValid()) { // If that directory is valid
          temp.removeFile(toBeMoved); // Remove file from original location
          tempMove.changeParent(newer); // Change the parent of that File
          if (newer.containsFile(toBeMoved)) {
            // If a file exists by the same name, remove then add, otherwise
            // just add
            newer.removeFile(toBeMoved);
            newer.addFile(tempMove);
          } else {
            newer.addFile(tempMove);
          } // Otherwise errors will be printed
        } else {
          System.out
              .println("Can't move " + initPath + " into " + newPath + "!");
        }
      } else {
        System.out.println("Can't move " + initPath + " into " + newPath + "!");
      }
    } else {
      System.out.println("Can't move " + initPath + " into " + newPath + "!");
    }
    return main;
  }

  // =========================================================================

  @Override
  public Directory execute() {
    ChangeDirectory decider = new ChangeDirectory(main, root, initPath);
    decider.execute();
    if (decider.isValid()) { // Decides whether to copy file or copy directory
      return moveDir();
    } else {
      return moveFile();
    }
  }

}
