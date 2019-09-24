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
 * CopyItem - Used to recursively copy a directory to a new reference.
 */
public class CopyItem {
  /**
   * The directory to be copied.
   */
  private Directory oriDir;
  /**
   * The copy of the directory.
   */
  private Directory newDir;
  /**
   * The parent directory of the copy.
   */
  private Directory Par;

  /**
   * Constructor to copy a directory, with two arguments required. Will set up
   * the first steps of the copy.
   * 
   * @param dir --> The directory to be copied.
   * @param Parent --> The parent directory of the copy.
   */
  public CopyItem(Directory dir, Directory Parent) {
    oriDir = dir;
    Par = Parent;
    newDir = new Directory(oriDir.getName(), Par); // Make a new directory
  }

  /**
   * Will work recursively to copy every sub-directory and sub-file from
   * original into newOne.
   * 
   * @param original --> The original directory (to be copied).
   * @param newOne --> The Directory that will serve as the copy.
   */
  private void recurseThru(Directory original, Directory newOne) {
    // For every file/directory contained in the original
    for (String content : original.getContents()) {
      // Event it is a file (Non-Recursive Case)
      if (original.containsFile(content)) {
        // Create a copy of the original file and then add it
        File x = new File(content, newOne);
        String addTo = original.getChildFile(content).getContents();
        x.overwriteContents(addTo);
        newOne.addFile(x);
        // Event it is a directory (Recursive Case)
      } else if (original.containsDirectory(content)) {
        // Create a copy of the original directory and then add it
        Directory x = new Directory(content, newOne);
        newOne.addDirectory(x);
        // Perform for this sub-directory, and any others that follow
        recurseThru(original.getChildDirectory(content), x);
      }
    }
  }

  /**
   * Will call the private method to create the full copy, and then return this
   * copy.
   * 
   * @return newDir - The copy of the original directory.
   */
  public Directory returnDirectory() {
    // Create the copy, then return it
    recurseThru(oriDir, newDir);
    return newDir;
  }
}
