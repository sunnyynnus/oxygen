package helloWorld;
/**
 * famous  min egg trial count problem
 * 
**/
public class EggTrialCount{
  
  public static void main(String[] args){
    System.out.println(getMinTrial(2, 100));
  }

  public static int getMinTrial(int numEggs, int numFloors){
    return getMinTrial(numEggs, numFloors, new int[numEggs+1][numFloors+1]);
  }

  private static int getMinTrial(int numEggs, int numFloors, int[][] M){
    
    if(numFloors==1 || numFloors==0 || numEggs==1){
      return numFloors;
    }

    if(M[numEggs][numFloors] !=0){
      return M[numEggs][numFloors];
    }
    int temp = Integer.MAX_VALUE;
    int min = temp;
    for(int i=1; i<=numFloors; i++){
      temp= Math.max(getMinTrial(numEggs, numFloors-i, M), getMinTrial(numEggs-1, i-1, M));
      min = Math.min(min, temp);
    }

    M[numEggs][numFloors]= min+1;
    return M[numEggs][numFloors];
  }
}
