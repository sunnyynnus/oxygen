package helloWorld;

import java.util.*;
public class IntToWords{

    static String[] ones= {"","ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE","TEN", "ELEVEN",
        "TWELVE", "THIRTEEN", "FOURTEEN", "FIFTEEN", "SIXTEEN", "SEVENTEEN", "EIGHTEEN", "NINETEEN"};
    static String[] tens= {"TWENTY", "THIRTY", "FORTY", "FIFTY", "SIXTY", "SEVENTY", "EIGHTY", "NINETY"};
    static Map<Integer, String> hundreds= new HashMap<>();
    static{
     hundreds.put(100,"HUNDERD");
     hundreds.put(1000, "THOUSAND");
     hundreds.put(1000000, "MILLION");
    }
    
     public static void main(String []args){
        int num= 9955000;
        System.out.println(f(num));
     }
     
     public static String f(int num){
          if(num<100){
              return getBasics(num);
          }
          int temp=getbase(num);
          return f(num/temp)+" "+ IntToWords.hundreds.get(temp)+ " "+f(num%temp);
    }
     
     private static int getbase(int num){
         if(num>=1000000){
             return 1000000;
         }
         if(num>=1000){
             return 1000;
         }
         if(num>=100){
             return 100;
         }
         return 0;
     }
     
  
     private static String getBasics(int num){
          if(num<20){
             return ones[num]; 
         }
          int ones= num%10;
          int tens= (num/10)%10;
          if(ones==0){
              return IntToWords.tens[tens-2];
          } else{
                return IntToWords.tens[tens-2]+ "-"+ IntToWords.ones[ones];
          } 
 
     }
}
