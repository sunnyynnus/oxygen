package helloWorld;

import java.util.*;

public class DigitChar{
      public static void main(String []args){

      String str="22016";
      System.out.println(countf(str));
      convertToChar(str);
     }
     
     
   public static int countf(String str){
       if(str==null|| (str.length()>0 && str.charAt(0)=='0')){
           return 0;
       }
       if(str.length()<=1){
           return 1;
       }
       if(str.length()>=2){
           int ch= Integer.valueOf(str.substring(0,2));
           if(ch==10 || ch==20){
               return countf(str.substring(2));
           } else if(ch<=26){
               return countf(str.substring(1))+countf(str.substring(2));
           } else{
               return countf(str.substring(1));
           }
       } else{
            return countf(str.substring(1));
       }
       
   }
   public static void convertToChar(String str){
      convertToChar(str, "");
   }

   private static void convertToChar(String str, String word){
       if(str==null|| (str.length()>0 && str.charAt(0)=='0')){
           return;
       }
       if(str.length()<=1){
           System.out.println(word+convert(str));
           return ;
       }
       if(str.length()>=2){
           int ch= Integer.valueOf(str.substring(0,2));
           if(ch==10 || ch==20){
             convertToChar(str.substring(2), word+convert(ch));
           } else if(ch<=26){
               convertToChar(str.substring(1), word+convert(str.charAt(0)));
               convertToChar(str.substring(2), word+convert(str.substring(0,2)));
           } else{
               convertToChar(str.substring(1), word+convert(str.charAt(0)));
           }
       } else{
            convertToChar(str.substring(1), word+convert(str.charAt(0)));
       }
       
   }
   
   private static String convert(char ch){
       int val=(int)ch+96-48;
       return Character.toString((char)val);
   }
   
   private static String convert(int ch){
       int val=ch+96;
       return Character.toString((char)val);
   }
   private static String convert(String str){
       if("".equals(str)){
           return "";
       }
       int val=Integer.parseInt(str);
       return Character.toString((char)(val+96));
   }
}
