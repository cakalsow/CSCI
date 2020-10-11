import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*  A class to test Maze.java.
 @author Koffman and Wolfgang
 */

public class MazeDriver extends JFrame implements GridColors, ActionListener {
  
  // data field
  private TwoDimGrid theGrid; // a 2-D grid of buttons
  private JButton solveButton, resetButton; 
  
  
  /** Builds the GUI */
  private MazeDriver(TwoDimGrid aGrid) {
    theGrid = aGrid;
    getContentPane().add(aGrid, BorderLayout.CENTER);
    JTextArea instruct = new JTextArea(2, 20);
    instruct.setText("Toggle a button to change its color" +
                     "\nPress SOLVE when ready");
    getContentPane().add(instruct, BorderLayout.EAST);
    solveButton = new JButton("SOLVE MAZE");
    resetButton = new JButton("RESET MAZE");
    solveButton.addActionListener(this);
    resetButton.addActionListener(this);
    getContentPane().add(solveButton, BorderLayout.SOUTH);
    getContentPane().add(resetButton, BorderLayout.NORTH);
    pack(); //Causes this Window to be sized to fit the preferred size and layouts of its subcomponents.
    show();
  }
  
  public void actionPerformed(ActionEvent e) {
    if(e.getSource().equals(solveButton)){
      Maze m = new Maze(theGrid);
      boolean found = m.findMazePath(0,0);
      if (found)
        JOptionPane.showMessageDialog(null, "Success - reset maze and try again");
      else
        JOptionPane.showMessageDialog(null, "No path - reset maze and try again");
    }
    else
      theGrid.reset();
  }
  
  public static void main(String[] args) {
    /** no file name given */
    String reply = JOptionPane.showInputDialog("Enter number of rows");
    int nRows = Integer.parseInt(reply);
    reply = JOptionPane.showInputDialog("Enter number of columns");
    int nCols = Integer.parseInt(reply);
    TwoDimGrid aGrid = new TwoDimGrid(nRows, nCols);
    new MazeDriver(aGrid);
  }
}
