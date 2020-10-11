import javax.swing.*;

public class TowersofHanoi
{
 public static void showMoves(int n, char start, char dest, char temp)
 {
  if (n == 0)
  {
   return; 
  }
  else
  {
   showMoves(n - 1, start, temp, dest);
   System.out.println("Move disk " + n + " from peg " + start + " to peg " + dest);
   showMoves(n - 1, temp, dest, start);
  }
 }
 public static void main(String args[])
 {
  TowersofHanoi.showMoves(5, 'A', 'C', 'B'); 
 }
}