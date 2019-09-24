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

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import a2.CopyItem;
import a2.Directory;
import a2.File;

public class CopyItemTest {
  // Directories and Files respectively created.
  Directory d1, d2, d3, d4, d5;
  File f1, f2, f3, f4, f5;
  // String that is to match the output
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

  // Test to check if the copy has all the same contents
  @Test
  public void testContents() {
    CopyItem x = new CopyItem(d2, d2.getParent());
    Directory temp = x.returnDirectory();
    Assert.assertArrayEquals(d2.getContents(), temp.getContents());
    Assert.assertArrayEquals(d2.getChildDirectory("Rules").getContents(),
        temp.getChildDirectory("Rules").getContents());
  }

  // Test to see if the files are copied correctly
  @Test
  public void testFiles() {
    CopyItem x = new CopyItem(d5, d4);
    Directory temp = x.returnDirectory();
    expected = "Delussional!";
    assertEquals(expected, temp.getChildFile("Leafs").getContents());
  }

  // Test to see if the parent directory is correct
  @Test
  public void testParents() {
    CopyItem x = new CopyItem(d4, d2);
    Directory temp = x.returnDirectory();
    Assert.assertArrayEquals(d4.getContents(), temp.getContents());
    assertEquals(d4.getParent(), temp.getParent());
  }
}
