import java.awt.*;

/** Class that solves problem of counting abnormal cells.
  *   @author Koffman and Wolfgang
  * */

public class Blob implements GridColors {
  
  /** The grid */
  private TwoDimGrid grid;
  
  /** Constructors */
  public Blob(TwoDimGrid grid) {
    this.grid = grid;
  }
  
  /** Finds the number of cells in the blob at (col,row).
    pre: Abnormal cells are in ABNORMAL color;
    Other cells are in LEGAL color.
    post: All cells in the blob are in the PATH color.
    @param col The col-coordinate of a blob cell
    @param row The row-coordinate of a blob cell
    @return The number of cells in the blob that contains (col, row)
    */
  public int countCells(int col, int row) {
    if (col < 0 || col >= grid.getNCols() || row < 0 || row >= grid.getNRows())
    {
     return 0; 
    }
    else if (!grid.getColor(col, row).equals(ABNORMAL))
    {
      return 0;
    }
    else
    {
     grid.recolor(col, row, PATH);
     return 1 + countCells(col - 1, row + 1) + countCells(col, row + 1) + countCells(col + 1, row + 1) +
       countCells(col - 1, row) + countCells(col + 1, row) + countCells(col - 1, row - 1) +
       countCells(col, row - 1) + countCells(col + 1, row - 1);
    }
  }
}
