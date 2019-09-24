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

public class FileTest {
  
  File f;
  Directory d;
  Directory d1;
  
  @Before
  public void setUp(){
    d = new Directory();
    d1 = new Directory("user", d);
    f = new File("myFile", d);
  }

  @Test
  public void testConstructor() {
    assertEquals("myFile", f.getName());
    assertEquals(d.getFullPath()+"myFile", f.getFullPath());
    //fail("Not yet implemented");
  }
  
  @Test
  public void testChangeParent(){
    f.changeParent(d1);
    assertEquals(d1.getFullPath()+"/myFile", f.getFullPath());
  }
  
  @Test
  public void testContents(){
    f.overwriteContents("Hello World");
    assertEquals("Hello World", f.getContents());
    
    f.overwriteContents("Hello Sky");
    assertEquals("Hello Sky", f.getContents());
    
    f.addToContents(" and World");
    assertEquals("Hello Sky\n and World", f.getContents());
  }

}
