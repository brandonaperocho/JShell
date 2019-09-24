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
import a2.Echo1;
import a2.File;

public class Echo1Test {

  Directory d1, d2, d3, d4, main, root;
  File f1, f2, f3, testFile;
  private Echo1 echo1;

  @Before
  public void setUp() {
    root = new Directory();
    main = root;
    d1 = new Directory("Directory1", main);
    d2 = new Directory("Directory2", main);
    d3 = new Directory("DirectoryA", d1);
    d4 = new Directory("DirectoryB", d2);
    f1 = new File("File1.txt", main, "Root file!");
    f2 = new File("FileA.pdf", d1, "I am contained in D1");
    f3 = new File("Fileb.doc", d4, "Absolute");
    d1.addDirectory(d3);
    d2.addDirectory(d4);
    main.addDirectory(d1);
    main.addDirectory(d2);
    main.addFile(f1);
    d1.addFile(f2);
    d4.addFile(f3);
  }

  @Test
  public void testEchoCurrent() {
    String[] testInput1 = {"String1 String2", ">", "File1.txt"};
    echo1 = new Echo1(testInput1, main, main);
    // Before overwrite
    String expected = f1.getContents();
    assertEquals(expected, "Root file!");

    // After overwrite
    echo1.execute();
    assertEquals("String1 String2", f1.getContents());
  }

  @Test
  public void testEchoAbsolute() {
    String[] testInput1 = {"String1 String2", ">", "/Directory1/FileA.pdf"};
    echo1 = new Echo1(testInput1, main, root);
    // Before overwrite
    assertEquals("I am contained in D1", f2.getContents());

    // After overwrite
    echo1.execute();
    assertEquals("String1 String2", f2.getContents());
  }

  @Test
  public void testEchoRelative() {
    String[] testInput1 = {"String1 String2", ">", "DirectoryB/Fileb.doc"};
    echo1 = new Echo1(testInput1, d2, root);
    // Before overwrite
    assertEquals("Absolute", f3.getContents());

    // After overwrite
    echo1.execute();
    assertEquals("String1 String2", f3.getContents());
  }

  @Test
  public void testEchoCreateFile() {
    String[] testInput1 = {"String1 String2", ">", "newFile1.txt"};
    echo1 = new Echo1(testInput1, main, root);

    // Before adding file
    assertFalse(main.containsFile("newFile1.txt"));
    
    echo1.execute();
    // After adding file
    assertTrue(main.containsFile("newFile1.txt"));
    assertEquals
    ("String1 String2", main.getChildFile("newFile1.txt").getContents());
  }
}
