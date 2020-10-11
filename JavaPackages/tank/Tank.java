/*
 * File: Tank.java
 */

package tank;

/** 
 * Tank is an interface for objects that hold a quantity of some substance
 * up to a maximum capacity.
 * 
 * @author John Miller and J. Andrew Holey
 * @version January 9, 2009
 */
public interface Tank
{
  
  /**
   * checks if tank is empty
   *
   *
   * @return true if empty, false if not
   */
  public boolean isEmpty();
  
  /**
   * checks if tank is full
   *
   *
   * @return true if tank is full, false if not
   */
  public boolean isFull();
  
  /**
   * return max capacity of tank
   *
   *
   * @return double value of capacity of tank
   */
  public double getCapacity();
  
  /**
   * return level of contents stored in the tank
   *
   *
   * @return double value of level of contents in tank
   */
  public double getLevel();
 
  /**
   * increases contents of the tank
   *
   * pre: check if what's being added exceeds the tank capacity
   * post: it increases the tank's contents by the number added, assuming it does not exceed the capacity
   *
   * @param double amount to be added to the tank
   * @throws IllegalArgumentException if precondition is violated
   */
  public void add(double amount);
  
  /**
   * decreases contents of the tank
   *
   * pre: contents in the tank do not drop below zero
   * post: decreases double amount from level
   *
   * @param double amount to be removed from the tank
   * @throws IllegalArgumentException if precondition is violated
   */
  public void remove(double amount);

}
