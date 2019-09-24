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
 * GetFullPath - Used to construct the absolute path of a file/directory.
 */
public class GetFullPath {
  /**
   * The path you want to get the absolute path of.
   */
  private String name;
  /**
   * The absolute path.
   */
  private String fPath;
  /**
   * The current working directory.
   */
  private Directory mainDir;
  /**
   * Splits name on every instance of /
   */
  private String[] splitName;
  /**
   * The directory/file being pointed at.
   */
  private String lastPart;

  // ==========================================================================

  /**
   * GetFullPath constructor for two arguments. Will set up the first steps for
   * creating the absolute path.
   * 
   * @param main - Current working directory
   * @param Path - Path needed to get absolute path of
   */
  public GetFullPath(Directory main, String Path) {
    name = Path;
    mainDir = main;
    // Check below if the path name is absolute
    if (name.startsWith("/")) {
      splitName = name.substring(1).split("/");
    } else {
      splitName = name.split("/");
    }
    // The last file/directory being pointed at
    lastPart = splitName[splitName.length - 1];
  }

  // ==========================================================================

  /**
   * Method used to get the last file/directory that is in the absolute path.
   * 
   * @return lastOne - Last file/directory within the absolute path
   */
  public String getLast() {
    String lastOne =
        getWithLast().split("/")[getWithLast().split("/").length - 1];
    return lastOne;
  }

  // ==========================================================================

  /**
   * Method used to get the full absolute path of name.
   * 
   * @return fPath - The absolute path
   */
  public String getWithLast() {
    // If it is local
    if (name.split("/").length == 1) {
      if (mainDir.getFullPath().equals("/")) { // If main is the root
        fPath = mainDir.getFullPath() + name;
      } else { // If it isn't the root
        fPath = mainDir.getFullPath() + "/" + name;
      }
    } // Other cases (relative & absolute)
    else {
      // The event the name is absolute
      if (name.startsWith("/")) {
        fPath = name;
        // Below is the event the name is relative
      } else if (!name.startsWith("/") && splitName.length > 1) {
        if (mainDir.getFullPath().equals("/")) { // If main is the root
          fPath = mainDir.getFullPath() + name;
        } else { // If it isn't the root
          fPath = mainDir.getFullPath() + "/" + name;
        }
      }
    }
    return fPath;
  }

  // ==========================================================================

  /**
   * Method used to get the full absolute path of name, without the last file or
   * directory. Basically getting the parent of name.
   * 
   * @return fPath - The absolute path without the last file/directory
   */
  public String getWithoutLast() {
    // If it is local
    if (name.split("/").length == 1) {
      fPath = mainDir.getFullPath();
    } else { // The event the name is absolute
      if (name.startsWith("/")) {
        if (name.length() == lastPart.length() + 1) {
          fPath = "/";
        } else {
          fPath = name.substring(0, name.length() - (lastPart.length() + 1));
        } // Below is the event the name is relative
      } else if (!name.startsWith("/") && splitName.length > 1) {
        if (mainDir.getFullPath().equals("/")) {
          fPath = mainDir.getFullPath()
              + name.substring(0, name.length() - (lastPart.length() + 1));
        } else {
          fPath = mainDir.getFullPath() + "/"
              + name.substring(0, name.length() - (lastPart.length() + 1));
        }
      }
    }
    return fPath;
  }
}
