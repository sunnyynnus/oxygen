package helloWorld;

public class Island{

  public static void main(String[] args){
    char[][] arr= { 
                    {'0', '0', '0'},
                    {'X', 'X', '0'},
                    {'X', 'X', 'X'},
                    {'0', 'X', '0'},
                    {'X', '0', 'X'},
                    {'X', '0', '0'}
                  };
    System.out.println( getCountOfBiggestIsland(arr));
  }

  public static int  getCountOfBiggestIsland(char[][] arr){
    int m= arr.length;
    int n= arr[0].length;
    int maxCount=0;
    boolean[][] flag= new boolean[m][n];
    for(int i=0; i<m; i++){
      for(int j=0; j<n ; j++){
        int count= getCount(arr, i , j, flag);
        System.out.println("count= "+count);
        maxCount= maxCount> count ? maxCount : count;
      }
    }
    return maxCount;
  }

  private static int getCount(char[][] arr, int i, int j, boolean[][] flag){
    
    if(i<0 || i>= arr.length || j<0 || j>=arr[0].length || flag[i][j]){
      return 0;
    }

    if(arr[i][j]=='X'){
      flag[i][j]=true;
      return 1+getCount(arr, i-1, j, flag)+getCount(arr, i+1, j, flag)+getCount(arr, i, j-1, flag)+getCount(arr, i, j+1, flag);
    }
    return 0;
  }
}

