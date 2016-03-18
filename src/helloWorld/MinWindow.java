package helloWorld;

public class MinWindow{

  public static void main(String[] args){
    MinWindow mw= new MinWindow();
    String input= "acbbaca";
    String target= "aba";
    System.out.println(mw.getMinLengthString(input, target));
  }

  public String getMinLengthString(String input, String target){
    
    int targetLength= target.length();
    int[] found= new int[256];
    int[] required= new int[256];
    int sptr=0;
    //int endPtr= Integer.MAX_VALUE;
    int counter =0;
    int reqSP= sptr;
    int reqEP= Integer.MAX_VALUE;

    for(int i=0; i<targetLength; i++){
      char ch = target.charAt(i);
      required[ch]++;
    }

    for(int i=0; i<input.length(); i++){
      char ch= input.charAt(i);
      // dont care
      if(required[ch]==0){
        continue;
      }
      
      found[ch]++;
      
      if(found[ch] <= required[ch]){
        counter++;
      }
      //got a window
      if(counter==targetLength){
        // increase sptr if possible
        while(required[input.charAt(sptr)]==0 || found[input.charAt(sptr)]> required[input.charAt(sptr)]){
          found[input.charAt(sptr)]--;
          sptr++;
        }
        
        //can't get better deal
        if((i-sptr)==targetLength-1){
          return input.substring(i, sptr+1);
        }

        if((i-sptr) < (reqEP-reqSP)){
          reqSP= sptr;
          reqEP= i;
        }
      }

    }
    return reqEP== Integer.MAX_VALUE ? null : input.substring(reqSP, reqEP+1);

  }

}
