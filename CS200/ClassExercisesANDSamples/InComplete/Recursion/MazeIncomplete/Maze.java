import java.awt.*;

/** Class that solves maze problems with backtracking.
  *   @author Koffman and Wolfgang
  * */

public class Maze implements GridColors {
  
  /** The maze */
  private TwoDimGrid maze;
  
  public Maze(TwoDimGrid m) {
    maze = m;
  }
  
  
  /** Attempts to find a path through point (col, row).
    pre: Possible path cells are in LEGAL color (i.e. WHITE);
    barrier cells are in ILLEGAL (i.e. RED) color.
    post: If a path is found, all cells on it are set to the
    PATH color (i.e. GREEN); all cells that were visited but are
    not on the path are in the BADCHOICE (i.e. GRAY) color.
    @param col The col-coordinate of current point
    @param row The row-coordinate of current point
    @return If a path through (col, row) is found, true; otherwise, false
    */
  public boolean findMazePath(int col, int row) {
    if (col < 0 || row < 0 || col >= maze.getNCols() || row >= maze.getNRows())
    {
     System.out.println("I am at (row, col) = (" + row + "," + col + ") ----- OUT OF BOUNDS");
     return false;
    }
    else if (!maze.getColor(col, row).equals(LEGAL)){
     System.out.println("I am at (row, col) = (" + row + "," + col + ") ----- Cell is on barrier (RED), already on path (GREEN) or dead end (GRAY)");
     return false;
    }
    else if (col == maze.getNCols() - 1 && row == maze.getNRows() - 1)
    {
     System.out.println("I am at (row, col) = (" + row + "," + col + ") ----- I WON");
     maze.recolor(col, row, PATH);
     return true;
    }
    else
    {
     System.out.println("I am at (row, col) = (" + row + "," + col + ")");
     maze.recolor(col, row, PATH);
     if (findMazePath( col - 1, row) || findMazePath(col, row - 1) || findMazePath(col, row + 1) || findMazePath(col + 1, row))
     {
      return true;
     }
     else
     {
      maze.recolor(col, row, BADCHOICE);
      return false;
     }
    }
    /*
     * Base cases:
     *    Failure: (col,row) is out of bounds ==> return false
     *    Failure: (col,row) is not a legal move ==> return false
     *    Success: (col,row)=(n-1,n-1) ==> return true after coloring cell green
     * General case:
     *    Color cell green and check if there is another cell to move to from current
     *    If yes, return true
     *    Else, color gray and return false ... dead end
     */
  }
}