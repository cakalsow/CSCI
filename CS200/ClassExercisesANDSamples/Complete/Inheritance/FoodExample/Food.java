/** 
 * Abstract class that models a kind of food.
 * @author Koffman & Wolfgang
 * @version 08/31/2009
 */

public abstract class Food {
  /**
   * Number of calories consumed
   */ 
  private double calories=0.0;

  /** 
   * Abstract method to calculate the percent of protein in a Food object. 
   * @return a double value representing the percentage of proteins
   */
  public abstract double percentProtein();

  /** 
   * Abstract method to calculate the percent of fat in a Food object. 
   * @return a double value representing the percentage of fats
   */
  public abstract double percentFat();

  /** 
   * Abstract method to calculate the percent of carbohydrates in a Food object. 
   * @return a double value representing the percentage of carbohydrates
   */
  public abstract double percentCarbohydrates();

  /**
   * Accessor method to return number of calories in Food object
   * @return a double value representing the calories
   */ 
  public double getCalories() {
    return calories;
  }
  /**
   * Mutator method to set number of calories in Food object
   * @param cal a double value representing the new value assigned to instance variable calories
   */ 
  public void setCalories(double cal) {
    calories = cal;
  }
}
