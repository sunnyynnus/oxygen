package helloWorld;

import java.lang.Math; 
import java.math.BigInteger;
import java.util.*;

public class BinaryMultiple
{
    
  public static void main(String[] args)
  {
    BinaryMultiple hw=new BinaryMultiple();
    for(int i=1; i<=2000;i++)
     hw.binaryMultiple(i);
  }
  
  public void binaryMultiple(int num){
    Map<Integer, BigInteger> map= new HashMap<>();
    int[] mod= new int[num+2];
    boolean flag =false;
    mod[0]=1;
    map.put(1, BigInteger.valueOf(1));
    for(int i=1; i<=num+1; i++){
      if(flag) break;

      mod[i]=(10*mod[i-1])%num;
        Set<Integer> keys= new HashSet<>(map.keySet());
        for(int key: keys){
          int tempKey= (key+mod[i])%num;
          BigInteger pow10= BigInteger.valueOf(10).pow(i);
          if(tempKey==0){
            BigInteger val=map.get(key).add(pow10);
            BigInteger factor= val.divide(BigInteger.valueOf(num));
            System.out.println("val= "+val+ "\t factor="+factor);
            flag=true;
          break;
          }
          if(!map.containsKey(tempKey)){
            BigInteger val=map.get(key).add(pow10);
            map.put(tempKey, val);
            
          }
        }
        if(!flag && !map.containsKey(mod[i])){
          map.put(mod[i], BigInteger.valueOf((long)Math.pow(10, i)));
        }
      
  
    }
    
  }
}
