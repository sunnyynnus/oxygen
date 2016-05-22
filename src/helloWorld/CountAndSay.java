package helloWorld;

public class CountAndSay{

     public static void main(String []args){
        new CountAndSay().countAndSaySeed("1");
     }
     
     public void countAndSaySeed(String str){
         System.out.println(str);
         for(int i=0; i<10; i++){
             str= countAndSay(str);
             System.out.println(str);
         }
     }
     
     private String countAndSay(String str){
         
         char prev= str.charAt(0);
         int count=1;
         String out="";
         for(int i=1; i<str.length(); i++){
             char cur= str.charAt(i);
             if(prev==cur){
                 count++;
             } else{
                 out+=String.valueOf(count)+prev;
                 prev=cur;
                 count=1;
             }
         }
         out+=String.valueOf(count)+str.charAt(str.length()-1);
         return out;
     }
}
