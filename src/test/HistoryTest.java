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

import a2.History;
import a2.LinkedList;

public class HistoryTest {

  private LinkedList lst;
  private History historyList;
  
  
  @Before
  public void setUp(){
    String[] testHistory = "history".split("\\s+");
    lst = new LinkedList();
    historyList = new History (testHistory, lst);
  }
  @Test
  public void testEmptyHistoryList() {
    String expected = "[]";
    
    assertEquals(expected, historyList.getContentsOfHistory(lst));
  }

  @Test
  public void testOneElementHistory() {
    historyList.addToHistoryList("First Element");
    
    String expected = "[First Element]";
    
    assertEquals(expected, historyList.getContentsOfHistory(lst));
  }
  
  @Test
  public void testMultipleElementsHistory() {
    historyList.addToHistoryList("First Element");
    historyList.addToHistoryList("Second Element");
    historyList.addToHistoryList("Third Element");
    
    String expected = "[First Element, Second Element, Third Element]";
    
    assertEquals(expected, historyList.getContentsOfHistory(lst));
  }
}
