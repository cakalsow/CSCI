import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/** Program to illustrate counting cells in a blob
*   @author Koffman and Wolfgang
* */

public class BlobDriver extends JFrame implements GridColors, ActionListener {

  // data field
  /** a 2-D grid of buttons */
  private TwoDimGrid theGrid;
  private JButton solveButton, resetButton; 
  public static void main(String[] args) {
        String reply = JOptionPane.showInputDialog("Enter number of rows");
        int nRows = Integer.parseInt(reply);
        reply = JOptionPane.showInputDialog("Enter number of columns");
        int nCols = Integer.parseInt(reply);
        TwoDimGrid aGrid = new TwoDimGrid(nRows, nCols);
        new BlobDriver(aGrid);
  }

  /** Builds the GUI
   *  @param aGrid - The TwoDimGrid that contains the blob */
  private BlobDriver(TwoDimGrid aGrid) {
    theGrid = aGrid;
    getContentPane().add(aGrid, BorderLayout.CENTER);
    Blob aBlob = new Blob(aGrid);
    JTextArea instruct = new JTextArea(2, 10);
    instruct.setText("Toggle a button to change its color"
                     + "\nPress SOLVE when ready");
    getContentPane().add(instruct, BorderLayout.NORTH);
    solveButton = new JButton("SOLVE MAZE");
    resetButton = new JButton("RESET MAZE");
    solveButton.addActionListener(this);
    resetButton.addActionListener(this);
    getContentPane().add(solveButton, BorderLayout.SOUTH);
    getContentPane().add(resetButton, BorderLayout.NORTH);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    pack();
    show();
  }

  /** Respond to pressing SOLVE button
   *  @param e -- Not used */
  public void actionPerformed(ActionEvent e) {
    if(e.getSource().equals(solveButton)){    
      String reply = JOptionPane.showInputDialog("Enter col coordinate of blob cell");
      int col = Integer.parseInt(reply);
      reply = JOptionPane.showInputDialog("Enter row coordinate of blob cell");
      int row = Integer.parseInt(reply);
      Blob aBlob = new Blob(theGrid);
      JOptionPane.showMessageDialog(null, "For blob at ("
                                  + col + "," + row + ") "
                                  + "\ncount is "
                                  + aBlob.countCells(col, row)
                                  + "\nReset blob and try again");
    }
    else
      theGrid.reset();
  }
}
