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

/**
 * <h1> Class LinkedList </h1>
 * LinkedList is a class uses Node as a wait to create a mutable list. Some 
 * classes such as PushD, PopD and History all use this class to save info into
 * each node. 
 * 
 */

public class LinkedList {

  private Node head; // Linked lists uses a Node
  private int linkedListSize; // Size of linked list
  
  /**
   * Constructor
   * 
   */
  public LinkedList () {
    head = new Node (null);
    linkedListSize = 0;
  }
  
  /**
   * @return LinkedList size 
   * 
   */
  public int getSize () {
    return linkedListSize;
  }
  
  /**
   * @return Head of LinkedList
   * 
   */
  public Node getHead () {
    return head;
  }
  
  /**
   * Adds a node with element and tail to the tail for the LinkedList
   * 
   */
  public void add (Object data) {
    Node tempNode = head;
    while (tempNode.getTail() != null) {
      tempNode = tempNode.getTail();
    }
    tempNode.setTail(new Node (data));
    linkedListSize++;
  }
  
  /**
   * Removes the top most element of the LinkedList and returns it
   * @return top most element of the LinkedList as an Object
   */
  public Object pop () {
    Node tempNode = head;
    Object returnVal;
    // Gets to the last value before null
    for (int i = 1; linkedListSize > i; i++) {
      tempNode = tempNode.getTail();
    }
    returnVal = tempNode.getTail().getElement();
    tempNode.setTail(tempNode.getTail().getTail());
    linkedListSize--;
    return returnVal;
  }
  
  /**
   * Method used for testing purposes
   * @return List of items in a String for testing purposes
   */
  public String getContentsOfList () {
    String returnString = "[";
    Node tempNode = head.getTail();
    
    for (int i = 0; linkedListSize > i; i++) {
      if (linkedListSize == i + 1) {
        returnString += tempNode.getElement().toString() + "]";
      }
      else {
        returnString += tempNode.getElement().toString() + ", ";
      }
      tempNode = tempNode.getTail();
    }
    if (linkedListSize == 0) {
      returnString += "]";
    }
    return returnString;
  }
  
  /**
   * Looks at the top most element; Echo uses this method
   * @return The top most element but does not remove from LinkedList
   */
  public Object peekAtTop () { // Used for echo to get exact input
    Node tempNode = head;
    while (tempNode.getTail() != null) {
      tempNode = tempNode.getTail();
    }
    return tempNode.getElement();
  }
  
  /**
   * Looks at the nth element; PreviousCommand uses this method
   * @return The nth element but does not remove from LinkedList
   */
  public Object peekAtPoint (int point) {
    Node tempNode = head; 
    for (int i = 0; point > i; i++) {
      tempNode = tempNode.getTail();
    }
    return tempNode.getElement();
  }
}
