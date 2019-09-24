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
import a2.LinkedList;
import a2.PopD;

public class PopDTest {

  private LinkedList stack;
  private PopD tempPopD;
  private Directory main, root, d1, d2, d3;
  
  @Before
  public void setUp() {
    root = new Directory();
    main = root;
    d1 = new Directory ("Dir1", main);
    d2 = new Directory ("DirA", d1);
    d3 = new Directory ("DirX", main);
    
    main.addDirectory(d1);
    d1.addDirectory(d2);
    main.addDirectory(d3);
    stack = new LinkedList();
    
  }

  @Test
  public void testPopEmpty() {
    tempPopD = new PopD (main, root, stack);
    // Attempts to pop when empty stack
    assertEquals(main, tempPopD.execute());
  }
  
  @Test
  public void testPopIntoDir() {
    tempPopD = new PopD (main, root, stack);
    stack.add(d2.getFullPath());
    
    String expected = d2.getFullPath();
    // Attempts to pop to the directory in the stack
    assertEquals(expected, tempPopD.execute().getFullPath());
  }

}
