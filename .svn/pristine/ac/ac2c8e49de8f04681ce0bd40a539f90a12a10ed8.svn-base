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
import a2.Directory;
import a2.File;
import a2.Cat;

public class CatTest {
  // Directories and Files respectively created.
  Directory d1, d2, d3, d4, d5;
  File f1, f2, f3, f4, f5;
  // String that is to match the output of Cat class
  String expected;

  // Set up and create the files and directories
  @Before
  public void setUp() {
    d1 = new Directory();
    d2 = new Directory("Sports", d1);
    d1.addDirectory(d2);
    d3 = new Directory("Games", d1);
    d1.addDirectory(d3);
    d4 = new Directory("Rules", d2);
    d2.addDirectory(d4);
    d5 = new Directory("Fans", d4);
    d4.addDirectory(d5);
    f1 = new File("Soccer", d2, "11v11 90minute games");
    f2 = new File("Hockey", d4, "6v6 60minute games");
    f3 = new File("LoL", d3, "Bunch of feeders.");
    f4 = new File("RootFile", d1, "It's like a root of a tree.");
    f5 = new File("Leafs", d5, "Delussional!");
    d2.addFile(f1);
    d4.addFile(f2);
    d3.addFile(f3);
    d1.addFile(f4);
    d5.addFile(f5);

  }

  // Test when the file is within the directory
  @Test
  public void testLocalWithinRoot() {
    Cat x = new Cat(d1, d1, "RootFile");
    expected = "It's like a root of a tree.";
    assertEquals(expected, x.getContents());
  }

  // Test when the file is on a relative path from current directory
  @Test
  public void testRelativePathFile() {
    Cat x = new Cat(d2, d1, "Rules/Hockey");
    expected = "6v6 60minute games";
    assertEquals(expected, x.getContents());
  }

  // Test when the file is an absolute path while in the root
  @Test
  public void testAbsolutePathFile() {
    Cat x = new Cat(d1, d1, "/Games/LoL/");
    expected = "Bunch of feeders.";
    assertEquals(expected, x.getContents());
  }

  // Test when the file is an absolute path while in a completely different
  // path.
  @Test
  public void testAbsolutePathFileFromOther() {
    Cat x = new Cat(d3, d1, "/Sports/Rules/Fans/Leafs");
    expected = "Delussional!";
    assertEquals(expected, x.getContents());
  }

  // Test when the file provided does not exist
  @Test
  public void testFileDoesntExist() {
    Cat x = new Cat(d3, d1, "/Sports/Rules/Fans/Sens");
    expected = "That file does not exist!";
    assertEquals(expected, x.getContents());
  }

  // Test when the path provided is not valid
  @Test
  public void testPathDoesntExist() {
    Cat x = new Cat(d3, d1, "/Sports/hello/Fans/Leafs");
    expected = "That file does not exist!";
    assertEquals(expected, x.getContents());
  }
  
  // Test multiple files that all exist.
  @Test
  public void testMultipleAllExist(){
    String[] files = {"cat", "Sports/Soccer", "Sports/Rules/Hockey", 
        "/Games/LoL"};
    Cat x = new Cat(d1, d1, files);
    expected = "Sports/Soccer:\n11v11 90minute games\n\nSports/Rules/Hockey:"
        + "\n6v6 60minute games\n\n/Games/LoL:\nBunch of feeders.";
    assertEquals(expected, x.getMultFileCont());
  }

  // Test multiple files that do not exist.
  @Test
  public void testMultipleNoneExist(){
    String[] files = {"cat", "Sports/Basketball", "Sports/Rules/Tennis", 
        "/Games/CSGO"};
    Cat x = new Cat(d1, d1, files);
    expected = "Sports/Basketball:\nThat file does not exist!\n\nSports/Rule"
        + "s/Tennis:\nThat file does not exist!\n\n/Games/CSGO:\nThat file "
        + "does not exist!";
    assertEquals(expected, x.getMultFileCont());
  }
  
  // Test multiple files where some exist and some don't.
  @Test
  public void testMultipleMixed(){
    String[] files = {"cat", "Sports/Soccer", "Sports/Rules/Tennis", 
        "/Games/CSGO", "/RootFile"};
    Cat x = new Cat(d1, d1, files);
    expected = "Sports/Soccer:\n11v11 90minute games\n\nSports/Rules/Tennis:"
        + "\nThat file does not exist!\n\n/Games/CSGO:\nThat file does not "
        + "exist!\n\n/RootFile:\nIt's like a root of a tree.";
    assertEquals(expected, x.getMultFileCont());
  }
  
}
