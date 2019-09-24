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
import a2.PWD;

public class PWDTest {
  
  private Directory current;
  private Directory root = new Directory();
  private Directory d1, d2, d3;
  //private String workingDirectory;

  @Before
  public void setUp(){
    current = root;
    d1 = new Directory("documents", current);
    d2 = new Directory("music", current);
    d3 = new Directory("albums", d2);
    
    current.addDirectory(d1);
    current.addDirectory(d2);
    d2.addDirectory(d3);
  }

  @Test
  public void test() {
    PWD temp = new PWD(current);
    temp.execute();
    
    current = d1;
    PWD temp1 = new PWD(current);
    temp1.execute();
    
    current = current.getParent();
    PWD temp2 = new PWD(current);
    temp2.execute();
    
    current = d3;
    PWD temp3 = new PWD(current);
    temp3.execute();
    
    //fail("Not yet implemented");
  }

}
