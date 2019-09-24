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

import java.util.Hashtable;

/**
 * <h1>ManCMD</h1> Depending on the command entered, gives the user a manual
 * that describes the command.
 */
public class ManCMD implements Command {
  /**
   * The string to be printed to represent the command's manual.
   */
  private String manual;
  /**
   * A Hashtable full of possible commands as keys.
   */
  private Hashtable<String, String> cmdManuals;
  /**
   * The command that is provided by the user.
   */
  private String argument;

  /**
   * Constructor --> Constructs a Hashtable that contains all string values.
   * 
   * @param arg - a String that represents the command entered
   */
  public ManCMD(String arg) {
    // We add all the possible commands to this Hashtable, and the
    // corresponding methods.
    argument = arg;
    cmdManuals = new Hashtable<String, String>();
    cmdManuals.put("man", getManManual());
    cmdManuals.put("echo", getEchoManual());
    cmdManuals.put("history", getHistoryManual());
    cmdManuals.put("cat", getCatManual());
    cmdManuals.put("popd", getPopdManual());
    cmdManuals.put("pushd", getPushdManual());
    cmdManuals.put("pwd", getPwdManual());
    cmdManuals.put("ls", getLsManual());
    cmdManuals.put("cd", getCdManual());
    cmdManuals.put("mkdir", getMkdirManual());
    cmdManuals.put("exit", getExitManual());
    cmdManuals.put("mv", getMvManual());
    cmdManuals.put("cp", getCpManual());
    cmdManuals.put("get", getGetManual());
    cmdManuals.put("grep", getGrepManual());
    cmdManuals.put("!number", getNumberManual());

  }

  // ==========================================================================

  /**
   * Verifies if the argPro (command/input) is in the main Hashtable
   * 
   * @param argPro - String representation of command entered
   * @return boolean - If argPro is a key in the created Hashtable
   */
  public boolean verify(String argPro) {
    // Check if only 2 items are in array of input. 2nd is in the Hashtable.
    if (cmdManuals.containsKey(argPro)) {
      return true;
    } else {
      return false;
    }
  }

  // ==========================================================================

  /**
   * Implemented from Command; used to run manCMD class
   */
  public String execute() {
    // All the possible printouts to the JShell.
    if (verify(argument)) {
      return (cmdManuals.get(argument));
    } else {
      return ("Invalid command, please try again");
    }
  }

  // ==========================================================================

  /**
   * Returns the string representation of the manual for man.
   * 
   * @return manual -> String representation of man manual
   * 
   */
  public String getManManual() {
    manual = "man -- Print documentation for a command (CMD). An example "
        + "is as follows. /# man CMD";
    return manual;
  }

  // ==========================================================================

  /**
   * Returns the string representation of the manual for echo.
   * 
   * @return manual -> String representation of echo manual
   * 
   */
  public String getEchoManual() {
    manual = "echo -- If only first arg is provided, it will be"
        + " printed onto the JShell. An example is as follows. /# echo "
        + "\"ayyy\"\necho (>) -- Put STRING into OUTFILE. If OUTFILE "
        + " doesn't exist, create a new file called OUTFILE. Otherwise"
        + " replace contents of OUTFILE with STRING. An example is as "
        + "follows. /# echo \"ayyy\" > newFile\necho (>>) -- Append STRING "
        + "to OUTFILE. If OUTFILE "
        + " doesn't exist, create a new file called OUTFILE. Otherwise"
        + " append STRING to OUTFILE. An example is as follows. /# echo "
        + "\"ayyy\" > newFile";
    return manual;
  }

  // ==========================================================================

  /**
   * Returns the string representation of the manual for history.
   * 
   * @return manual -> String representation of history manual
   * 
   */
  public String getHistoryManual() {
    manual = "history -- Will print out recent commands, of "
        + "amount specified by argument, or all by default. An example is"
        + " as follows. /# history 4";
    return manual;
  }

  // ==========================================================================

  /**
   * Returns the string representation of the manual for cat.
   * 
   * @return manual -> String representation of cat manual
   * 
   */
  public String getCatManual() {
    manual = "cat -- Display the contents of the files provided"
        + " into the JShell. An example is as follows. /# cat seeFile";
    return manual;
  }

  // ==========================================================================

  /**
   * Returns the string representation of the manual for popd.
   * 
   * @return manual -> String representation of popd manual
   * 
   */
  public String getPopdManual() {
    manual = "popd -- Remove the last entry of dir stack, and "
        + "make it your current directory. An example is as follows. /# "
        + "popd";
    return manual;
  }

  // ==========================================================================

  /**
   * Returns the string representation of the manual for pushd.
   * 
   * @return manual -> String representation of pushd manual
   * 
   */
  public String getPushdManual() {
    manual = "pushd -- Save the current directory to the dir "
        + "stack, and then change the new current directory to the one "
        + "provided as an argument. An example is as follows. /# pushd "
        + "newDIR";
    return manual;
  }

  // ==========================================================================

  /**
   * Returns the string representation of the manual for pwd.
   * 
   * @return manual -> String representation of pwd manual
   * 
   */
  public String getPwdManual() {
    manual = "pwd -- Prints the FULL directory path of the"
        + " current directory. An example is as follows. /# pwd";
    return manual;
  }

  // ==========================================================================

  /**
   * Returns the string representation of the manual for ls.
   * 
   * @return manual -> String representation of ls manual
   * 
   */
  public String getLsManual() {
    manual = "ls -- Prints the content of the current directory"
        + " or directory/file that is provided as an argument. An example"
        + " is as follows. /# ls testFile";
    return manual;
  }

  // ==========================================================================

  /**
   * Returns the string representation of the manual for cd.
   * 
   * @return manual -> String representation of cd manual
   * 
   */
  public String getCdManual() {
    manual = "cd -- Changes current directory to the one "
        + "provided. Can be relative to current dir or full path. An"
        + " example is as follows. /# cd newDIR";
    return manual;
  }

  // ==========================================================================

  /**
   * Returns the string representation of the manual for mkdir.
   * 
   * @return manual -> String representation of mkdir manual
   * 
   */
  public String getMkdirManual() {
    manual = "mkdir -- Creates directories. An example is as "
        + "follows. /# mkdir newDIR";
    return manual;
  }

  // ==========================================================================

  /**
   * Returns the string representation of the manual for exit.
   * 
   * @return manual -> String representation of exit manual
   * 
   */
  public String getExitManual() {
    manual = "exit -- Quit the program. An example is as follows. /# exit";
    return manual;
  }

  // ==========================================================================

  /**
   * Returns the string representation of the manual for mv.
   * 
   * @return manual -> String representation of mv manual
   * 
   */
  public String getMvManual() {
    manual = "mv -- Moves file/directory from OldPath to NewPath. It will be "
        + "removed from OldPath. An example is as follows. /# mv /1 /2";
    return manual;
  }

  // ==========================================================================

  /**
   * Returns the string representation of the manual for cp.
   * 
   * @return manual -> String representation of cp manual
   * 
   */
  public String getCpManual() {
    manual = "cp -- Copies a file/directory from OldPath to NewPath. It will "
        + "NOT be removed from OldPath. An example is as follows. /# cp /1 /2";
    return manual;
  }

  // ==========================================================================

  /**
   * Returns the string representation of the manual for get.
   * 
   * @return manual -> String representation of get manual
   * 
   */
  public String getGetManual() {
    manual = "get -- Gets a file from a URL and adds it to the current "
        + "directory. An example is as follows. /# get http://www.google."
        + "ca/results/a1.txt";
    return manual;
  }

  // ==========================================================================

  /**
   * Returns the string representation of the manual for grep.
   * 
   * @return manual -> String representation of grep manual
   * 
   */
  public String getGrepManual() {
    manual = "grep -- Returns lines in files that contain a certain regex. Can"
        + " be used recursively or just for one file. An example is as "
        + "follows. /# grep \"[0-9]+\" /1/2/file.txt";
    return manual;
  }

  // ==========================================================================

  /**
   * Returns the string representation of the manual for !number.
   * 
   * @return manual -> String representation of !number manual
   * 
   */
  public String getNumberManual() {
    manual = "!number -- Recalls the (number)th command in history, and then"
        + "will execute it. An example is as follows. /# !5";
    return manual;
  }
}
