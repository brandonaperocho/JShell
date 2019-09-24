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

public class ChangeDirectoryTest {

  private Directory main, root, d1, d2, d3, d4, d5, d6;
  private ChangeDirectory changedDir;

  @Before
  public void setUp() {
    root = new Directory();
    main = root;
    d1 = new Directory("DirA", main);
    d2 = new Directory("DirB", main);
    d3 = new Directory("DirC", d1);
    d4 = new Directory("DirX", d1);
    d5 = new Directory("DirY", d4);
    d6 = new Directory("DirZ", d2);

    d1.addDirectory(d3);
    d1.addDirectory(d4);
    d2.addDirectory(d6);
    d5.addDirectory(d4);
    main.addDirectory(d1);
    main.addDirectory(d2);

  }

  @Test
  public void testRegularCD() {
    changedDir = new ChangeDirectory(main, root, "/DirA/DirC");

    String expected = "/DirA/DirC";

    assertEquals(expected, changedDir.execute().getFullPath());
  }

  @Test
  public void testWithDots() {
    changedDir = new ChangeDirectory(main, root,
            "/DirB/../DirA/./../DirA/DirC/./../DirC");
    
    String expected = "/DirA/DirC";
    
    assertEquals(expected, changedDir.execute().getFullPath());
  }
  
  @Test
  public void testInvalidPath() {
    changedDir = new ChangeDirectory(main, root, "/DirA/./DirB/./DirC/./DirA");
    
    String expected = "/";
    
    assertEquals(expected, changedDir.execute().getFullPath());
  }

  @Test
  public void testInvalidPathNotAtCurrent() {
    changedDir = new ChangeDirectory(d4, root, "/DirA/./DirX/../DirZ/../DirA");
    
    String expected = "/DirA/DirX";
    
    assertEquals(expected, changedDir.execute().getFullPath());
  }

}
