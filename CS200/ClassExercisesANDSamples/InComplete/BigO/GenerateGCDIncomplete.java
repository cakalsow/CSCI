class GenerateGCDIncomplete{

  private static int badGCDCount = 0;
  private static int goodGCDCount = 0;
  
  public static int badGCD(int a, int b){
    int min = Math.min(a,b);
    for(int i = min; i > 0; i--){
      badGCDCount++;
      if (a%i==0 && b%i==0) 
        return i;
    }
    return 1;
  }
  
  public static int goodGCDIterative(int a, int b){
    //COMPLETE ME USING A WHILE LOOP **********************************************************************************
    // please remember to increment goodGCDCount properly
    return a;
  }

  public static int goodGCDRecurive(int a, int b){
    //COMPLETE ME USING RECURCION ***********************************************************************************
    // please remember to increment goodGCDCount properly
    return a;
  }
  
  
  public static void main(String args[]){
    badGCDCount= 0;
    System.out.println("badGCD Found GCD of GCD(11200,5500)           --- "+badGCD(11200,5500)+ 
                       " --- after " + badGCDCount + " comparisons");
    goodGCDCount= 0;
    System.out.println("goodGCDIterative Found GCD of GCD(11200,5500) --- "+goodGCDIterative(11200,5500)+ 
                       " --- after " + goodGCDCount + " comparisons");
    goodGCDCount= 0;
    System.out.println("goodGCDRecurive Found GCD of GCD(11200,5500)  --- "+goodGCDRecurive(11200,5500)+ 
                       " --- after " + goodGCDCount + " comparisons");
    
    badGCDCount= 0;
    System.out.println("badGCD Found GCD of GCD(11200,5501)           --- "+badGCD(11200,5501)+ 
                       " --- after " + badGCDCount + " comparisons");
    goodGCDCount= 0;
    System.out.println("goodGCDIterative Found GCD of GCD(11200,5501) --- "+goodGCDIterative(11200,5501)+ 
                       " --- after " + goodGCDCount + " comparisons");
    goodGCDCount= 0;
    System.out.println("goodGCDRecurive Found GCD of GCD(11200,5501)  --- "+goodGCDRecurive(11200,5501)+ 
                       " --- after " + goodGCDCount + " comparisons");
    
  }
  
  
  
  
  
  
} 
