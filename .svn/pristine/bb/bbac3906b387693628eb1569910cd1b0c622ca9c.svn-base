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
import a2.HandleCase;
import a2.LinkedList;

public class HandleCaseTest {
  // These are all created so we are given access to the constructor.
  String[] userInput;
  Directory mainD;
  Directory rootD;
  LinkedList hisLL;
  LinkedList ppDLL;

  @Before
  public void setUp() {
    // We set these variables up so that we can provide them as arguments in
    // the constructor.
    rootD = new Directory();
    mainD = new Directory();
    hisLL = new LinkedList();
    ppDLL = new LinkedList();
  }
  // For these tests we are interested in the boolean value -> of if they were
  // found in the Hashtable that was first initialized at the constructor.
  // If they are found then the program will work as needed.

  // Test if findCommand is TRUE when man is the command.
  @Test
  public void testManAsFirstInput() {
    String[] userInput = {"man", "hey", "there"};
    HandleCase temp = new HandleCase(userInput, mainD, rootD, hisLL, ppDLL);
    assertEquals(true, temp.findCommand());
    assertEquals(false, temp.findDirCommand());
  }

  // Test if findCommand is TRUE when history is the command.
  @Test
  public void testHistoryAsFirstInput() {
    String[] userInput = {"history", "hey", "there"};
    HandleCase temp = new HandleCase(userInput, mainD, rootD, hisLL, ppDLL);
    assertEquals(true, temp.findCommand());
    assertEquals(false, temp.findDirCommand());
  }

  // Test if findCommand is TRUE when echo is the command.
  @Test
  public void testEchoAsFirstInput() {
    String[] userInput = {"echo", "hey", "there"};
    HandleCase temp = new HandleCase(userInput, mainD, rootD, hisLL, ppDLL);
    assertEquals(true, temp.findCommand());
    assertEquals(false, temp.findDirCommand());
  }

  // Test if findCommand is TRUE when cat is the command.
  @Test
  public void testCatAsFirstInput() {
    String[] userInput = {"cat", "hey", "there"};
    HandleCase temp = new HandleCase(userInput, mainD, rootD, hisLL, ppDLL);
    assertEquals(true, temp.findCommand());
    assertEquals(false, temp.findDirCommand());
  }

  // Test if findDirCommand is TRUE when popd is the command.
  @Test
  public void testPopdAsFirstInput() {
    String[] userInput = {"popd", "hey", "there"};
    HandleCase temp = new HandleCase(userInput, mainD, rootD, hisLL, ppDLL);
    assertEquals(false, temp.findCommand());
    assertEquals(true, temp.findDirCommand());
  }

  // Test if findDirCommand is TRUE when pushd is the command.
  @Test
  public void testPushdAsFirstInput() {
    String[] userInput = {"pushd", "hey", "there"};
    HandleCase temp = new HandleCase(userInput, mainD, rootD, hisLL, ppDLL);
    assertEquals(false, temp.findCommand());
    assertEquals(true, temp.findDirCommand());
  }

  // Test if findCommand is TRUE when pwd is the command.
  @Test
  public void testPwdAsFirstInput() {
    String[] userInput = {"pwd", "hey", "there"};
    HandleCase temp = new HandleCase(userInput, mainD, rootD, hisLL, ppDLL);
    assertEquals(true, temp.findCommand());
    assertEquals(false, temp.findDirCommand());
  }

  // Test if findCommand is TRUE when pwd is the command.
  @Test
  public void testLsAsFirstInput() {
    String[] userInput = {"ls", "hey", "there"};
    HandleCase temp = new HandleCase(userInput, mainD, rootD, hisLL, ppDLL);
    assertEquals(true, temp.findCommand());
    assertEquals(false, temp.findDirCommand());
  }

  // Test if findDirCommand is TRUE when cd is the command.
  @Test
  public void testCdAsFirstInput() {
    String[] userInput = {"cd", "hey", "there"};
    HandleCase temp = new HandleCase(userInput, mainD, rootD, hisLL, ppDLL);
    assertEquals(false, temp.findCommand());
    assertEquals(true, temp.findDirCommand());
  }

  // Test if findDirCommand is TRUE when pushd is the command.
  @Test
  public void testMkdirAsFirstInput() {
    String[] userInput = {"mkdir", "hey", "there"};
    HandleCase temp = new HandleCase(userInput, mainD, rootD, hisLL, ppDLL);
    assertEquals(false, temp.findCommand());
    assertEquals(true, temp.findDirCommand());
  }

  // Test if the command is not valid. (not within the Hashtable)
  @Test
  public void testInvalidAsFirstInput() {
    String[] userInput = {"thisIsNotRight", "hey", "there"};
    HandleCase temp = new HandleCase(userInput, mainD, rootD, hisLL, ppDLL);
    assertEquals(false, temp.findCommand());
    assertEquals(false, temp.findDirCommand());
  }

  // Test if the command is empty string. (not within the Hashtable)
  @Test
  public void testEmptyAsFirstInput() {
    String[] userInput = {"", "hey", "there"};
    HandleCase temp = new HandleCase(userInput, mainD, rootD, hisLL, ppDLL);
    assertEquals(false, temp.findCommand());
    assertEquals(false, temp.findDirCommand());
  }
}
