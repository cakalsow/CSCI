package net.multitool.core;

import java.util.*;
/**
 * A basic Account class for our budgeting example. 
 * We will use this much to generate Javadocs
 * and also to begin our JUnit testing (design, test, code).
 * @author Imad Rahal
 * @version August 30, 2017
 */
public class Account {
  /**
   *  a name to identify this account
   */ 
  private String name;
  /**
   * the user assigned to this account
   */ 
  private String owner; 
  /**
   * total amt allocated to this account in cents
   */ 
  private int total; 
  
  /**
   * Default constructor: sets account name and owner to null 
   * and the total balance to 0
   */ 
  public Account(){
    this.name = null;
    this.owner = null;
    this.total = 0;  
  }
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
    this.total = total;  
  }
  
  /**
   * Subtracts the parameter amt from the total balance provided amt doesn't exceed total balance
   * Pre: Parameter amt should be less or equal to current total balance and not negative
   * Post: New total balance is old total balance minus parameter amt
   * @param amt the amount to be deducted from the total balance
   * @throws IllegalArgumentException if paramter amt is more than current total balance or negative
   */ 
  public void debit(int amt){
    if (amt>getTotal() || amt<0)
      throw new IllegalArgumentException("Balance not sufficient OR amt is negative");
    setTotal(getTotal()-amt);
  }
  
  /**
   * Adds the parameter amt to the total balance
   * Pre: Parameter amt should be positive
   * Post: New total balance is old total balance plus parameter amt
   * @param amt the amount to be added to the total balance
   * @throws IllegalArgumentException if paramter amt is negative
   */ 
  public void credit(int amt){  
    if (amt<0)
      throw new IllegalArgumentException("Can't add a negative amount");
    setTotal(getTotal()+amt);
  }
  
  /**
   * A getter method to access the current total balance
   * @return a int value representing the total balance
   */ 
  public int getTotal(){
    return total;
  }
  
  /**
   * A getter method to access the name of the account
   * @return a String value representing the name of the account
   */ 
  public String getName(){
    return name;
  }
  
  /**
   * A getter method to access the owner of the account
   * @return a String value representing owner of the account
   */ 
  public String getOwner(){
    return owner;
  }
  
  /**
   * A setter method to update the current total balance provided parameter amt
   * is NOT negative
   * Pre: Parameter amt should be positive
   * Post: New total balance is equal to the parameter amt
   * @param amt the amount to be deducted from the total balance
   * @throws IllegalArgumentException if parameter amt is negative
   */ 
  public void setTotal(int amt){
    if (amt<0)
      throw new IllegalArgumentException("Balance not sufficient");
    total = amt;
  }
  
} 
