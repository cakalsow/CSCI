/** 
 * Class that models a Vegetable
 * @author Koffman & Wolfgang
 * @version 08/31/2009
 */

public class Vegetable extends Food {
  
  private static final double VEG_PROTEIN_CAL = 0.35;
  private static final double VEG_FAT_CAL = 0.15;
  private static final double VEG_CARBO_CAL = 0.50;
  private static final String VEG_NAME = "VEGETABLE";
  
  public double percentProtein() {
    return VEG_PROTEIN_CAL;
  }
  
  public double percentFat() {
    return VEG_FAT_CAL;
  }
 
  public double percentCarbohydrates() {
    return VEG_CARBO_CAL;
  }
  
  public String myName() {
    return VEG_NAME;
  }
}


