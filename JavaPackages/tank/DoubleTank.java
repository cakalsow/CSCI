package tank;
    /**
   * class DoubleTank implements interface Tank
   * @authors Kayli and Channa
   */
public class DoubleTank implements Tank
{
  private double level, capacity;
  public final static double DEFAULT_CAPACITY = 250.0;
  
    /**
   * constructor which sets level to 0.0 and capacity to default
   */
  public DoubleTank()
{
    level = 0.0;
    capacity = DEFAULT_CAPACITY;
    
  }
    /**
   * constructor which sets level to 0.0 and user can set capacity
   * @param double capacity sets value of capacity as long as it's greater than zero
   */
  public DoubleTank(double capacity) throws IllegalArgumentException
  {
    level = 0.0;
    if (capacity > 0)
    {
      this.capacity = capacity;
    }
    else
    {
      throw new IllegalArgumentException("Capacity must be greater than zero.");
    }
  }
  
      /**
   * toString method which returns current level and capacity of tank
   * @return String which says current level and capacity
   */
  public String toString()
  {
    return ("DoubleTank--level: " + level + ", capacity: " + capacity);
  }
  
  /**
   * checks if tank is empty
   *
   *
   * @return true if empty, false if not
   */
  public boolean isEmpty()
  {
    return (level == 0.0);
  }
  
  /**
   * checks if tank is full
   *
   *
   * @return true if tank is full, false if not
   */
  public boolean isFull()
  {
    return (level == capacity);
  }
  
  /**
   * return max capacity of tank
   *
   *
   * @return double value of capacity of tank
   */
  public double getCapacity()
  {
    return capacity;
  }
  
  /**
   * return level of contents stored in the tank
   *
   *
   * @return double value of level of contents in tank
   */
  public double getLevel()
  {
    return level;
  }
 
  /**
   * increases contents of the tank
   *
   * pre: check if what's being added exceeds the tank capacity
   * post: it increases the tank's contents by the number added, assuming it does not exceed the capacity
   *
   * @param double amount to be added to the tank
   * @throws IllegalArgumentException if precondition is violated
   */
  public void add(double amount) throws IllegalArgumentException
  {
    if (amount < 0)
    {
      throw new IllegalArgumentException("Amount must be greater than zero.");
    }
    else if (amount + level <= capacity)
    {
      level = amount + level;
    }
    else
    {
      throw new IllegalArgumentException("Exceeds max capacity.");
    }
  }
  
  /**
   * decreases contents of the tank
   *
   * pre: contents in the tank do not drop below zero
   * post: decreases double amount from level
   *
   * @param double amount to be removed from the tank
   * @throws IllegalArgumentException if precondition is violated
   */
  public void remove(double amount)
  {
        if (amount < 0)
    {
      throw new IllegalArgumentException("Amount must be greater than zero.");
    }
    else if (level - amount >= 0)
    {
      level = level - amount;
    }
    else
    {
      throw new IllegalArgumentException("Level in tank cannot be below zero.");
    }
  }

}
  
