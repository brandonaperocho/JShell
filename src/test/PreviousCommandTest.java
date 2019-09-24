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

package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import a2.ChangeDirectory;
import a2.Directory;
import a2.Echo1;
import a2.Echo2;
import a2.File;
import a2.History;
import a2.LinkedList;
import a2.MakeDirectory;
import a2.PreviousCommand;

public class PreviousCommandTest {
  private PreviousCommand prevCom;
  private LinkedList hList, PPStack;
  private Directory d1, d2, d3, d4, main, root;
  private File f1, f2, f3;

  @Before
  public void setUp() {
    root = new Directory();
    main = root;
    d1 = new Directory("Directory1", main);
    d2 = new Directory("Directory2", main);
    d3 = new Directory("DirectoryA", d1);
    d4 = new Directory("DirectoryB", d2);
    f1 = new File("File1.txt", main, "Root file!");
    f2 = new File("FileA.pdf", d1, "I am contained in D1");
    f3 = new File("Fileb.doc", d4, "Absolute");
    d1.addDirectory(d3);
    d2.addDirectory(d4);
    main.addDirectory(d1);
    main.addDirectory(d2);
    main.addFile(f1);
    d1.addFile(f2);
    d4.addFile(f3);
    hList = new LinkedList();
    hList.add("mkdir Directory1 Directory2 DirectoryA DirectoryB");
    hList.add("echo \"Root file!\" > File1.txt");
    hList.add("echo \"I am contained in D1\" > Directory1/FileA.pdf");
    hList.add("echo \"Absolute\" >> /Directory2/DirectoryB/Fileb.doc");
    hList.add("history");
    hList.add("!1");
    hList.add("!6");
    hList.add("cd /Directory1/DirectoryA");
    hList.add("ASD"); // Needed so that the list is of correct size
  }

  @Test
  public void testPreviousCommandCD() {
    String[] testInput = {"!8"};
    prevCom = new PreviousCommand(testInput, main, root, hList, PPStack);
    // Before PreviousCommand called
    assertEquals("/", main.getFullPath());
    main = prevCom.execute();
    // After PreviousCommand called
    assertEquals("/Directory1/DirectoryA", main.getFullPath());
  }

  @SuppressWarnings("deprecation")
  @Test
  public void testPreviouscommandMkdir() {
    String[] testInput = {"!1"};
    prevCom = new PreviousCommand(testInput, d3, root, hList, PPStack);
    String[] expectedBefore = {};
    // Before PreviousCommand called
    assertEquals(expectedBefore, d3.getContents());
    main = prevCom.execute();
    // After PreviousCommand called
    String[] expectedAfter =
        {"Directory1", "Directory2", "DirectoryA", "DirectoryB"};
    assertEquals(expectedAfter, d3.getContents());
  }

  @SuppressWarnings("deprecation")
  @Test
  public void testPreviousCommandRecur() {
    String[] testInput = {"!6"};
    prevCom = new PreviousCommand(testInput, d3, root, hList, PPStack);
    
    String[] expectedBefore = {};
    // Before PreviousCommand called
    assertEquals(expectedBefore, d3.getContents());
    main = prevCom.execute();
    // After PreviousCommand called
    String[] expectedAfter =
        {"Directory1", "Directory2", "DirectoryA", "DirectoryB"};
    assertEquals(expectedAfter, d3.getContents());
    
  }
}
