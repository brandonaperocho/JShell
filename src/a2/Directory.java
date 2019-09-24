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
package a2;
import java.util.LinkedList;

/**
 * Directory class. Stores list of sub files and folders of a directory
 * Provides accessor and mutator methods for commands to use to work with 
 * subfiles and subfolders
 * Stores basic information about the directory: name, full path, parent
 */
public class Directory {
  
  private Directory parent; // directory in which this dir. is contained
  private String name; // Directory name
  private String pathname; //Full directory path
  //List of all directories contained in this dir.
  private LinkedList<Directory> subDirs;
  //List of all files contained in this dir.
  private LinkedList<File> subFiles;
  
  /**
   * Constructor
   * @param dirName
   * @param dirParent
   * String argument is directory name. Directory argument is parent.
   * Sets full path to parent directory's full path + directory name
   */
  public Directory(String dirName, Directory dirParent){
    name = dirName;
    parent = dirParent;
    if (!parent.getName().equals("/")){
      //only add slash if parent is not root
      pathname = parent.getFullPath() + "/" + name;
    }else{
      pathname = parent.getFullPath() + name;
    }
    subDirs = new LinkedList<Directory>();
    subFiles = new LinkedList<File>();
  }
  
  /**
   * Constructor with no arguments
   * To be used for root directory, which has no parent and default name
   * Full path is simply the directory's name.
   */
  public Directory(){
    name = "/";
    pathname = name;
    subDirs = new LinkedList<Directory>();
    subFiles = new LinkedList<File>();
  }
  
  /**
   * Returns the name of the directory (string)
   * @return
   */
  public String getName(){
    return name;
  }
  
  /**
   * Returns the full path of directory
   * @return
   */
  public String getFullPath(){
    return pathname;
  }
  
  /**
   * Changes the parent of the directory to that specified in argument
   * Changes full path to reflect change.
   * @param newParent
   */
  public void changeParent(Directory newParent){
    parent = newParent;
    if (!parent.getName().equals("/")){
      pathname = parent.getFullPath() + "/" + name;
    }else{
      pathname = parent.getFullPath() + name;
    }
  }
  
  /**
   * Returns the directory's parent, to help with cd
   * @return
   */
  public Directory getParent(){
    return parent;
  }
  
  /**
   * Returns a string array containing the names of all sub-directories, files
   * @return
   */
  public String[] getContents(){
    //initialize array to be size of total number of files + directories
    int arraySize = subDirs.size() + subFiles.size();
    int count = 0; // will keep track of index where dirs end and files begin
    String[] s = new String[arraySize];
    for (int i=0; i<subDirs.size(); i++){
      s[i] = subDirs.get(i).getName(); //add  each dir name to array
      count ++; //keep track of number of directories added
    }
    //files begin at index of last directory + 1: count
    for (int j=0; j<subFiles.size(); j++){
      s[j+count] = subFiles.get(j).getName(); // add each file name to array
    }
    return s;
  }
  
  /**
   * Return true if this directory contains a sub directory of name dirName
   * Return false if it does not
   * Will enable mkdir, mv, cp to ensure no duplicates are added
   * @param dirName
   * @return
   */
  public boolean containsDirectory(String dirName){
    for (int i=0; i<subDirs.size(); i++){
      //check if each directory's name is equal to the name specified
      if (subDirs.get(i).getName().equals(dirName)){
        return true;
      }
    }return false;
  }
  
  /**
   * Returns the directory of name specified, that is a child of this directory
   * Returns null if name specified does not exist.
   * @param dirName
   * @return
   */
  public Directory getChildDirectory(String dirName){
    for (int i=0; i<subDirs.size(); i++){
      if (subDirs.get(i).getName().equals(dirName)){
        return subDirs.get(i);
      }
    }return null;
  }
  
  /**
   * Return true if this directory contains a sub file of name filename
   * Return false if it does not
   * Will enable echo, mv, cp to ensure no duplicates are added
   * @param filename
   * @return
   */
  public boolean containsFile(String filename){
    //check if each file's name is equal to name specified
    for (int j=0; j<subFiles.size(); j++){
      if (subFiles.get(j).getName().equals(filename)){
        return true;
      }
    }return false;
  }
  
  /**
   * Returns the file of the specified name, that is a child of this directory
   * Returns null if file does not exist
   * @param filename
   * @return
   */
  public File getChildFile(String filename){
    for (int j=0; j<subFiles.size(); j++){
      if (subFiles.get(j).getName().equals(filename)){
        return subFiles.get(j);
      }
    }return null;
  }
  
  /**
   * Add directory d to list of sub directories (for mkdir, mv, cp)
   * @param d
   */
  public void addDirectory(Directory d){
    subDirs.add(d);
  }
  
  /**
   * Add file f to list of sub files (for echo, mv, cp)
   * @param f
   */
  public void addFile(File f){
    subFiles.add(f);
  }
  
  /**
   * Remove directory of name dirName from list of sub directories
   * For mv, cp
   * @param dirName
   */
  public void removeDirectory(String dirName){
    for (int i = 0; i < subDirs.size(); i++){
      //check if each directory name is equal to name specified
      if (subDirs.get(i).getName().equals(dirName)){
        subDirs.remove(i); // if true, remove directory and return
        return;
      }
    }
  }
  
  /**
   * Remove file of name filename from list of sub files (for mv, cp)
   * @param filename
   */
  public void removeFile(String filename){
    for (int j=0; j<subFiles.size(); j++){
      //check if each file name is equal to name specified
      if (subFiles.get(j).getName().equals(filename)){
        subFiles.remove(j); // if true, remove file and return
        return;
      }
    }
  }
  
  public int getNumberDirectories(){
    return subDirs.size();
  }
  
}
