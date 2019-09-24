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

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;

import a2.Directory;
import a2.File;
import a2.GetURLFile;

public class GetTest {

  private String URLTest1;
  private String URLTest2;
  private String URLTest3;
  private Directory main, d1, d2, d3, d4;
  private Directory root;
  private File f1, f2, f3, f4;

  @Before
  public void setUp() 
  {
    URLTest1 = "https://mcs.utm.utoronto.ca/~zingarod/236/ps/ps1.tex";
    URLTest2 = "https://mcs.utm.utoronto.ca/"
        + "~zingarod/108/lectures/lecture17/songs.txt";
    URLTest3 = "https://www.google.ca/File1.txt";
    
    root = new Directory();
    main = root;
    d1 = new Directory("Directory1", main);
    d2 = new Directory("Directory2", main);
    d3 = new Directory("DirectoryA", d1);
    d4 = new Directory("DirectoryB", d2);
    f1 = new File("File1.txt", main, "Root file!");
    f2 = new File("FileA.pdf", d1, "I am contained in D1");
    f3 = new File("Fileb.doc", d4, "Absolute");
    f4 = new File("songs.txt", main, "some contents"); 
    d1.addDirectory(d3);
    d2.addDirectory(d4);
    main.addDirectory(d1);
    main.addDirectory(d2);
    main.addFile(f1);
    main.addFile(f4);
    d1.addFile(f2);
    d4.addFile(f3);
  }

  @Test
  public void testValidfile() {
    GetURLFile temp = new GetURLFile (URLTest1, main, root);
    
    assertEquals (main.containsFile("ps1.tex"), false); // Checks before execute
    temp.execute(); // Executes Get command
    assertEquals (main.containsFile("ps1.tex"), true); // Should exist
  }
  
  @Test
  public void testValidfileContents() {
    GetURLFile temp = new GetURLFile (URLTest2, main, root);
    
    assertEquals (main.containsFile("songs.txt"), true); // Checks if file exist
    temp.execute(); // Executes command
    assertEquals (main.containsFile("songs.txt"), true); // Still exists
    
    String expected = "Game Songs and Ratings\n"
        + "#These are Dan's ratings\n"
        + "#Visit Dan in office hours to discuss\n"
        + "Final Fantasy VI, Terra's Theme, 10\n"
        + "Skyrim, Town 4, 8\n"
        + "Ys V, Vanishing World, 11\n"
        + "Pokemon Red, Lavender Town, 9\n"
        + "Zelda Skyward Sword, Ancient Harbour, 10";
    
    assertEquals (expected, main.getChildFile("songs.txt").getContents());
    // Must contain the expected string
  }
  
  @Test
  public void testInvalidfile() {
    GetURLFile temp = new GetURLFile (URLTest3, main, root);
    
    assertEquals (main.containsFile("File1.txt"), true);
    // Checks for contents of file
    assertEquals (main.getChildFile("File1.txt").getContents(), "Root file!");
    temp.execute(); // Executes command
    assertEquals (main.getChildFile("File1.txt").getContents(), "Root file!");
    // Checks to make sure contents did not change
  }
  
  
  @Test
  public void testOverwriteContentsOfFile() {
    GetURLFile temp = new GetURLFile (URLTest2, main, root);
    
    assertEquals (main.containsFile("songs.txt"), true);
    assertEquals ("some contents", 
        main.getChildFile("songs.txt").getContents()); 
    // Checks for correct contents
    temp.execute(); // Executes command
    assertEquals (main.containsFile("songs.txt"), true);
    // Checks if file still exists
    String expected = "Game Songs and Ratings\n"
        + "#These are Dan's ratings\n"
        + "#Visit Dan in office hours to discuss\n"
        + "Final Fantasy VI, Terra's Theme, 10\n"
        + "Skyrim, Town 4, 8\n"
        + "Ys V, Vanishing World, 11\n"
        + "Pokemon Red, Lavender Town, 9\n"
        + "Zelda Skyward Sword, Ancient Harbour, 10";
    
    assertEquals (expected, main.getChildFile("songs.txt").getContents());
    // Overwritten contents should be the expected string
  }
}
