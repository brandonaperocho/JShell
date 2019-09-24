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
 * <h1>Copy</h1> The copy class' function is to create a copy of a specified
 * file/directory and then move it to a specified location. Will return an
 * updated directory with the copy added.
 */
public class Copy implements DirectoryCommand {
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

  // =========================================================================

  /**
   * Constructor -> Assign the main variables that will be used in copying one
   * file/directory to another another location, while maintaining its original
   * location aswell.
   * 
   * @param mainDir - current working directory
   * @param rootDir - root directory
   * @param oP - item to be copied
   * @param nP - location to be copied into
   */
  public Copy(Directory mainDir, Directory rootDir, String oP, String nP) {
    main = mainDir;
    root = rootDir;
    initPath = oP;
    newPath = nP;
  }

  // =========================================================================

  /**
   * This method will attempt to copy ONLY DIRECTORIES. If the copy can not be
   * performed, an appropriate error will be printed.
   * 
   * @return main (current working directory either with or without the newly
   *         copied item)
   */
  public Directory copyDir() {
    ChangeDirectory tempOldAct2 = new ChangeDirectory(main, root, initPath);
    ChangeDirectory tempNew2 = new ChangeDirectory(main, root, newPath);
    Directory tempOldAct = tempOldAct2.execute();
    Directory tempNew = tempNew2.execute();
    // Creates two directories, for the old location, and the new
    if (tempOldAct2.isValid() && tempNew2.isValid()
        && !tempOldAct.getName().equals("/")) {
      // If everything is valid
      toBeMoved = tempOldAct.getName(); // The directory name to be copied
      Directory x = new CopyItem(tempOldAct, tempNew).returnDirectory();
      // Recursively copy the wanted directory
      if (tempNew.containsDirectory(toBeMoved)) {
        // If a directory exists by the same name, remove then add, otherwise
        // just add
        tempNew.removeDirectory(toBeMoved);
        tempNew.addDirectory(x);
      } else {
        tempNew.addDirectory(x);
      }
    } else { // If something is not valid, print an error
      System.out.println("Can't copy " + initPath + " into " + newPath + "!");
    }
    return main;
  }

  // =========================================================================

  /**
   * This method is used to get any certain paths that will be used in the
   * process of copying a file.
   */
  private void getNames() {
    initial = new GetFullPath(main, initPath).getWithoutLast();
    newP = new GetFullPath(main, newPath).getWithoutLast();
    checkFile = new GetFullPath(main, newPath).getLast();
    toBeMoved = new GetFullPath(main, initPath).getLast();
  }

  // =========================================================================

  /**
   * This method will attempt to copy ONLY FILES. If the copy can not be
   * performed, an appropriate error will be printed.
   * 
   * @return main (current working directory either with or without the newly
   *         copied item)
   */
  public Directory copyFile() {
    getNames();
    if (!toBeMoved.equals("/")) { // Only copy if it's not the root
      Directory temp = new ChangeDirectory(main, root, initial).execute();
      if (temp.containsFile(toBeMoved)) { // Make sure it contains that FILE
        File tempMove = temp.getChildFile(toBeMoved);
        Directory check = new ChangeDirectory(main, root, newP).execute();
        if (check.containsFile(checkFile)) { // If the location is a file
          File fileExists = check.getChildFile(checkFile);
          fileExists.overwriteContents(tempMove.getContents());
          return main; // Overwrite the contents of the file at the location
        } // Otherwise we move into the directory at that location
        ChangeDirectory x = new ChangeDirectory(main, root, newPath);
        Directory newer = x.execute();
        if (x.isValid()) { // If that directory is valid
          File toAdd = new File(toBeMoved, newer);
          toAdd.overwriteContents(tempMove.getContents()); // Make the file
          if (newer.containsFile(toBeMoved)) {
            // If a file exists by the same name, remove then add, otherwise
            // just add
            newer.removeFile(toBeMoved);
            newer.addFile(toAdd);
          } else {
            newer.addFile(toAdd);
          } // Otherwise errors will be printed
        } else {
          System.out
              .println("Can't copy " + initPath + " into " + newPath + "!");
        }
      } else {
        System.out.println("Can't copy " + initPath + " into " + newPath + "!");
      }
    } else {
      System.out.println("Can't copy " + initPath + " into " + newPath + "!");
    }
    return main;
  }

  // =========================================================================

  @Override
  public Directory execute() {
    ChangeDirectory decider = new ChangeDirectory(main, root, initPath);
    decider.execute();
    if (decider.isValid()) { // Decides whether to copy file or copy directory
      return copyDir();
    } else {
      return copyFile();
    }
  }

}
