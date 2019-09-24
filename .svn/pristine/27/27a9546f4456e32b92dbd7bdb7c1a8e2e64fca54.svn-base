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

import java.io.*;
import java.net.*;

/**
 * <h1>Class Get</h1> 
 * This command is used to get a file from a given URL by the user. Then reads
 * the file and writes it into the mock file system with the same file name.
 *
 */
public class GetURLFile implements DirectoryCommand {
  private URL currentURL;// URL being inputted
  private Directory currentDir;// Directory currently in
  private Directory rootDir; // Root directory
  private String toURLStr; // Gets the path from URL
  private String newFileName; // File name
  private String nameURL;

  /**
   * Constructor
   * @param current --> URL in string form
   * @param curDir --> Main directory in JShell
   * @param root --> Root directory from JShell
   */
  public GetURLFile(String current, Directory curDir, Directory root) {
    currentDir = curDir;
    rootDir = root;
    nameURL = current;
  }

  /**
   * Gets the file from the URL then writes it to the current working directory
   */
  public Directory execute() {
    try {
      currentURL = new URL(nameURL); // Gets URL as URL object to connect to
      toURLStr = currentURL.getPath(); // Gets string form of the URL
      newFileName = toURLStr.split("/")[toURLStr.split("/").length - 1]; 
      URLConnection currentURLConnection = currentURL.openConnection();
      currentURLConnection.connect(); // Connects to the URL given by user
      BufferedReader in = // Reads the file 
          new BufferedReader(new InputStreamReader(currentURL.openStream()));
      String inputLine;
      if (currentDir.containsFile(newFileName)) { // Checks if file exists
        currentDir.getChildFile(newFileName).overwriteContents("");
      }
      while ((inputLine = in.readLine()) != null) {
        String[] finalInput = {inputLine, ">>", newFileName}; // Format for echo
        if (currentDir.containsFile(newFileName)) { // Overwrites the file
          if (currentDir.getChildFile(newFileName).getContents().equals("")) {
            currentDir.getChildFile(newFileName).overwriteContents(inputLine);
          } else { // For the case where we must overwrite
            Echo2 tempEcho2 = new Echo2(finalInput, currentDir, rootDir);
            tempEcho2.execute(); // Creates the file and appends
          }
        } else { // For the case where the file DNE
          Echo2 tempEcho2 = new Echo2(finalInput, currentDir, rootDir);
          tempEcho2.execute(); // Creates the file and appends
        }
      }
      in.close(); // Closes the reading
    } catch (MalformedURLException e) { // If URL invalid
      System.out.println("Couldn't get the file!");
    } catch (IOException e) { // If file cannot be read
      System.out.println("Couldn't get the file!");
    }
    return currentDir; // Returns main directory for JShell
  }


}
