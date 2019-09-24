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
import a2.LS;

public class LSTest {
  Directory d0, d1, d2;
  File f0, f1;
  String testString;

  @Before
  public void setUp(){
    d0 = new Directory();
    d1 = new Directory("documents", d0);
    d2 = new Directory("music", d0);
    f0 = new File("hotlineBling", d2, "I know when that hotline bling");
    f1 = new File("screenshot", d0, "image");
    
    d0.addDirectory(d1);
    d0.addDirectory(d2);
    d0.addFile(f1);
    d2.addFile(f0);
    testString = "/one/two/three/four";
  }

  @Test
  public void test() {
    
    String[] testSeparated = testString.split("/");
    String[] expectedSeparated = {"one", "two", "three", "four"};
    assert(Arrays.equals(testSeparated, expectedSeparated));
    
    LS temp = new LS(d0, false);
    String[] expected = {"documents", "music", "screenshot"}; 
    temp.execute();; // contents of root
    System.out.println("------------");
    
    LS temp2 = new LS(d2, false);
    temp2.execute(); // contents of music
    System.out.println("------------");
    
    LS temp1 = new LS(d1, false);
    temp1.execute(); //blank line (contents of documents)
    System.out.println("------------");
    //fail("Not yet implemented");
  }
  
  @Test
  public void secondTest() {
    
    LS temp = new LS("/music/hotlineBling", d2, d0, false);
    temp.execute(); //This should print out "hotlineBling"
    System.out.println("------------");
    
    LS temp1 = new LS("../.", d2, d0, false);
    temp1.execute(); //This should print out contents of d0
    //fail("Not yet implemented");
    System.out.println("------------");
  }
  
  @Test
  public void thirdTest() {
    
    LS temp = new LS("/music//hotlineBling", d1, d0, false);
    temp.execute(); //This should print out an error message (2 slashes)
    System.out.println("------------");
    
    LS temp1 = new LS("hello", d2, d0, false);
    temp1.execute(); //This should print out an error message(no such file)
    //fail("Not yet implemented");
    System.out.println("------------");
  }

}
