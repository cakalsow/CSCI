package core;

/**
 * A basic Account class for budgeting purposes. 
 * 
 * @author Imad Rahal
 * @version August 25, 2017
 */
public class Account {
  /**
   *  a name to identify this account
   */ 
  private String name;
  /**
   * the user assigned to this account
   */ 
  protected String owner; 
  /**
   * total amt allocated to this account in cents
   */ 
  int total; 
  
  /**
   * Default constructor: sets account name and owner to null 
   * and the total balance to 0
   */ 
  public Account(){
    this.name = null;
    this.owner = null;
    this.total = 0;}

  /**
   * Another constructor which sets account name, owner to the three parameters
   * Pre: Parameter total should not be negative
   * @param name The name of the account
   * @param owner The name of owner of the account
   * @param total The intitial balance of the account
   * @throws IllegalArgumentException if paramter total is negative
   */
  public Account(String name, String owner, int total){
    if (total<0)
      throw new IllegalArgumentException("Balance can't be negative");
    this.name = name;
    this.owner = owner;
    this.total = total;}
   
  /**
   * A getter method to access the current total balance
   * @return a int value representing the total balance
   */ 
  public int getTotal(){
    return total;}
  
  /**
   * A getter method to access the name of the account
   * @return a String value representing the name of the account
   */ 
  public String getName(){
    return name;}
  
  /**
   * A getter method to access the owner of the account
   * @return a String value representing owner of the account
   */ 
  public String getOwner(){
    return owner;}

  /**
   * Adds the parameter amt to the total balance
   * Pre: Parameter amt should be positive
   * @param amt the amount to be added to the total balance
   * @return the total balance as the old total balance plus parameter amt
   * @throws IllegalArgumentException if paramter amt is negative
   */ 
  public int credit(int amt){  
    if (amt<0)
      throw new IllegalArgumentException("Can't add a negative amount");
    total += amt;
    return total;
  }

  /**
   * Subtracts the parameter amt from the total balance provided amt doesn't exceed total balance
   * Pre: Parameter amt should be less or equal to current total balance and not negative
   * Post: New total balance is old total balance minus parameter amt
   * @param amt the amount to be deducted from the total balance
   * @throws IllegalArgumentException if paramter amt is more than current total balance or negative
   */ 
  public void debt(int amt){
    if (amt>getTotal() || amt<0)
      throw new IllegalArgumentException("Balance not sufficient OR amt is negative");
    total -= amt;
  }
} 