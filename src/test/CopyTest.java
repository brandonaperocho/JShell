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

import a2.*;

public class CopyTest {
//Directories and Files respectively created.
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
  
  // Test that after you execute Copy, the copy and the original are of 
  // different references, and so changing one does not change the other.
  @Test
  public void testDifferentReference() {
    Copy x = new Copy(d3, d1, "/Sports", "/Games");
    Directory y = x.execute();
    Directory temp = new Directory("notInOld", y.getChildDirectory("Sports"));
    y.getChildDirectory("Sports").addDirectory(temp);
    assertEquals(false, d2.containsDirectory("notInOld"));  
  }
  
  // Test when you copy one directory into another. You should add a copy of the
  // directory into this directory. Separate references stay true.
  @Test
  public void testCopyDirectoryToDirectory() {
    Copy x = new Copy(d3, d1, "/Sports", "/Games");
    Directory y = x.execute();
    assertEquals(d1.containsDirectory("Sports"), 
        y.containsDirectory("Sports"));  
  }
  
  // Test when you copy one file into a directory. You should add a copy of the
  // file into this directory. Separate references stay true.
  @Test
  public void testCopyFileToDirectory() {
    Copy x = new Copy(d3, d1, "/Sports/Soccer", "/Games");
    Directory y = x.execute();
    assertEquals(d2.containsFile("Soccer"), y.containsFile("Soccer")); 
    assertEquals(d2.getChildFile("Soccer").getContents(), 
        y.getChildFile("Soccer").getContents());
    y.getChildFile("Soccer").overwriteContents("not anymore");
    assertNotEquals(d2.getChildFile("Soccer").getContents(),
        y.getChildFile("Soccer").getContents());
  }
  
  // Test when you copy one file into another. You should overwrite the file
  // you are moving into. Separate references stay true.
  @Test
  public void testCopyFileToFile() {
    Copy x = new Copy(d3, d1, "/Sports/Soccer", "/Games/LoL");
    Directory y = x.execute();
    assertEquals(d2.containsFile("Soccer"), y.containsFile("LoL"));
    assertEquals(false, y.containsFile("Soccer"));
    assertEquals(d2.getChildFile("Soccer").getContents(), 
        y.getChildFile("LoL").getContents());
  }
  
}
