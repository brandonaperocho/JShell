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

import org.junit.Test;
import org.junit.Before;

import a2.ChangeDirectory;
import a2.Directory;
import a2.MakeDirectory;

public class MakeDirectoryTest {
  // A root directory and current working directory are created.
  Directory root;
  Directory main;

  @Before
  public void setUp() {
    root = new Directory();
    main = root;
  }

  // Creating an absolute path from root
  @Test
  public void testMakeWithinRootAbs() {
    MakeDirectory temp = new MakeDirectory("/a", main, root);
    main = temp.constructDir();
    assertEquals("/a", main.getChildDirectory("a").getFullPath());
  }

  // Creating an absolute path for a path longer than 1 from root
  @Test
  public void testMakeAbs() {
    main = new MakeDirectory("/a", main, root).constructDir();
    main = new MakeDirectory("/a/b", main, root).constructDir();
    Directory new1 = new ChangeDirectory(main, root, "/a/b").execute();
    assertEquals("/a/b", new1.getFullPath());
  }

  // Creating an absolute path with the use of . and ..
  @Test
  public void testMakeAbsWithDots() {
    main = new MakeDirectory("/a", main, root).constructDir();
    main = new MakeDirectory("/a/b", main, root).constructDir();
    main = new MakeDirectory("/a/b/../../a/c", main, root).constructDir();
    Directory new1 = new ChangeDirectory(main, root, "/a/c").execute();
    assertEquals("/a/c", new1.getFullPath());
  }

  // Creating a local directory in root
  @Test
  public void testMakeWithinRootLocal() {
    MakeDirectory temp = new MakeDirectory("a", main, root);
    main = temp.constructDir();
    assertEquals("/a", main.getChildDirectory("a").getFullPath());
  }

  // Creating a local directory while outside of root
  @Test
  public void testMakeWithinPathLocal() {
    main = new MakeDirectory("a", main, root).constructDir();
    main = new MakeDirectory("/a/b", main, root).constructDir();
    Directory new1 = new ChangeDirectory(main, root, "/a/b").execute();
    main = new1;
    main = new MakeDirectory("hey", main, root).constructDir();
    Directory new2 = new ChangeDirectory(main, root, "/a/b/hey").execute();
    assertEquals("/a/b/hey", new2.getFullPath());
  }

  // Creating a relative path while in a path of length > 1
  @Test
  public void testMakeWithinPathRelative() {
    main = new MakeDirectory("a", main, root).constructDir();
    main = new MakeDirectory("/a/b", main, root).constructDir();
    Directory new1 = new ChangeDirectory(main, root, "/a/b").execute();
    main = new1;
    main = new MakeDirectory("c", main, root).constructDir();
    main = new MakeDirectory("c/d", main, root).constructDir();
    Directory new2 = new ChangeDirectory(main, root, "/a/b/c/d").execute();
    assertEquals("/a/b/c/d", new2.getFullPath());
  }

  // Creating an absolute path directory in a completely different directory
  // than the current directory
  @Test
  public void testMakeOutsidePathAbs() {
    main = new MakeDirectory("a", main, root).constructDir();
    main = new MakeDirectory("1", main, root).constructDir();
    main = new MakeDirectory("/a/b", main, root).constructDir();
    Directory new1 = new ChangeDirectory(main, root, "/a/b").execute();
    main = new1;
    main = new MakeDirectory("/1/2", main, root).constructDir();
    Directory new2 = new ChangeDirectory(main, root, "/1/2").execute();
    assertEquals("/1/2", new2.getFullPath());
  }

}
