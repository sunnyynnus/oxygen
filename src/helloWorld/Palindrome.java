// Copyright: Ariba SAP Inc 2016
// Author: Sunny Upendra (sunny.upendra@sap.com)
//
package helloWorld;
public class Palindrome{

  public static void main(String[] args){
    Palindrome pali= new Palindrome();
    System.out.println(pali.getLongestPaliSubstring("forgeeksskeegfor"));
  }

  public String getLongestPaliSubstring(String str){
  
    int maxLen= 1;
    int sptr=0;
    
    for(int i=0; i<str.length(); i++){
      //even length pali
      String epali= getPaliSubstring(str, i, i+1);
      if(epali.length()>maxLen){
        maxLen= epali.length();
        sptr= i-epali.length()/2+1;

      }
      String opali= getPaliSubstring(str, i, i);
      if(opali.length()>maxLen){
        maxLen= opali.length();
        sptr= i-opali.length(); 
      }

    }
    return str.substring(sptr, sptr+maxLen);

  }

  private String getPaliSubstring(String str, int lptr, int rptr){
    
    while(lptr>=0 && rptr<str.length() && str.charAt(lptr)==str.charAt(rptr)){
      lptr--;
      rptr++;
    }
    return str.substring(lptr+1, rptr);
  }
}
