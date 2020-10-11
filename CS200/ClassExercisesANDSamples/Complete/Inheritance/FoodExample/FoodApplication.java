public class FoodApplication{
  
  public static void main(String[] args){
    //(1)
    Vegetable v = new Vegetable();
    System.out.println(v.getCalories());
    System.out.println(v.percentProtein());
    System.out.println(v.percentFat());
    System.out.println(v.percentCarbohydrates());
    System.out.println(v.myName());
    
    // (2) 
    Food f = new Food();
    System.out.println(f.getCalories());
    System.out.println(f.percentProtein());
    System.out.println(f.percentFat());
    System.out.println(f.percentCarbohydrates());
    System.out.println(f.myName());
    //System.out.println(((Vegetable)f).myName());


  }
}