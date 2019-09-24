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

import a2.LinkedList;

public class LinkedListTest {

  private LinkedList l;
 
  @Before
  public void setUp(){
    l = new LinkedList ();
  }
  
  @Test
  public void testEmptyList() {
    assertEquals("[]", l.getContentsOfList());
    assertEquals (0, l.getSize());
    
  }
  
  @Test
  public void testLinkedList() {
    l.add("Test1");
    l.add("Test2");
    l.add("Test2");
    assertEquals("[Test1, Test2, Test2]", l.getContentsOfList());
    assertEquals (3, l.getSize());
    l.pop();
    assertEquals("[Test1, Test2]", l.getContentsOfList());
    assertEquals (2, l.getSize());
    l.pop();
    assertEquals("[Test1]", l.getContentsOfList());
    assertEquals (1, l.getSize());
    
    l.add("Test2");
    
    assertEquals("[Test1, Test2]", l.getContentsOfList());
    assertEquals (2, l.getSize());
    
    l.add("Test3");
    
    assertEquals("[Test1, Test2, Test3]", l.getContentsOfList());
    assertEquals(3, l.getSize());
  }
}
