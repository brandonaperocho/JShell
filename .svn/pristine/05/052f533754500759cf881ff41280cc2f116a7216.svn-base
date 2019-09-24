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

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import a2.Directory;
import a2.File;

public class DirectoryTest {
  
  Directory d0, d1, d2;
  File f0, f1;

  @Before
  public void setUp(){
    d0 = new Directory();
    d1 = new Directory("documents", d0);
    d2 = new Directory("music", d0);
    f0 = new File("hotline bling", d2, "I know when that hotline bling");
    f1 = new File("screenshot", d0, "image");
    
    d0.addDirectory(d1);
    d0.addDirectory(d2);
    d0.addFile(f1);
    d2.addFile(f0);
  }

  @Test
  public void firstTest() {
    assertEquals(d2.getFullPath(), "/music");
    assertEquals(f0.getFullPath(), "/music/hotline bling");
    //fail("Not yet implemented");
  }
  
  @Test
  public void secondTest(){
    String[] alphabet = {"music"};
    String x = alphabet[0];
    assertTrue(d0.containsFile("screenshot"));
    assertTrue(d0.containsDirectory(x));
    assertEquals(d1.getName(), "documents");
    assertEquals(d0.getChildDirectory(x), d2);
  }
  
  @Test
  public void thirdTest(){
    String[] s0 = {"documents", "music", "screenshot"};
    System.out.println(d0.getContents()[0]);
    System.out.println(d0.getContents()[1]);
    System.out.println(d0.getContents()[2]);
    System.out.println(d0.getContents().length);
    assertTrue(Arrays.equals(s0, d0.getContents()));
    
    f1.changeParent(d1);
    d0.removeFile("screenshot");
    d1.addFile(f1);
    String[] s1 = {"screenshot"};
    String[] s2 = {"documents", "music"};
    String[]s3 = {"documents"};
    
    assertTrue(Arrays.equals(s1, d1.getContents()));
    assertTrue(Arrays.equals(s2, d0.getContents()));
    
    d0.removeDirectory("music");
    assertTrue(Arrays.equals(s3, d0.getContents()));
  }

}
