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
import a2.PushD;


public class PushDTest {

  private LinkedList stack;
  private Directory main, root, d1, d2, d3;
  private PushD tempPushD;
  private String dirNameToChange;
  
  @Before
  public void setUp() {
    root = new Directory();
    main = root;
    d1 = new Directory("DirectX1", main);
    d2 = new Directory("DirectX2", main);
    d3 = new Directory("DirectX3", d2);
    main.addDirectory(d1);
    main.addDirectory(d2);
    d2.addDirectory(d3);
    
    stack = new LinkedList();
  }

  @Test
  public void testEmptyStack() {
    dirNameToChange = "/DirectX2/DirectX3";
    tempPushD = new PushD (d1, root, dirNameToChange, stack);
    
    assertEquals (0, stack.getSize());
    
    // After PushD is called
    String actual = tempPushD.execute().getFullPath();
    assertEquals ("/DirectX2/DirectX3", actual);
    // Checks Stack size after PushD called
    assertEquals (1, stack.getSize());
    // Checks contents of Stack to see if it holds the right directory
    assertEquals ("[/DirectX1]", stack.getContentsOfList());
    
  }

}
