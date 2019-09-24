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

import a2.Node;

public class NodeTest {
  
  private Node n;
  
  @Before
  public void setUp(){
    n = new Node ("Test1");
  }
  
  @Test
  public void tesTElement() {
    assertEquals("Test1", n.getElement());
    n.setElement("NewTest1");
    assertEquals("NewTest1", n.getElement());
  }

  @Test
  public void testTail() {
    assertEquals(null, n.getTail());
    n.setTail(new Node("TestTail2"));
    assertEquals("TestTail2", n.getTail().getElement());
    assertEquals (null, n.getTail().getTail());
  }
  
}
