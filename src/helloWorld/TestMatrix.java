/**
 * 
 */
package helloWorld;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunny
 *
 */
public class TestMatrix {

	static int rowNums=4;
	static int colNums=6;
	static int matrix[][]=new int[rowNums][colNums];
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createMatrix();
		displayMatrix();
		testSetRowColToZero();
		displayMatrix();
	}
	
	private static void createMatrix()
	{
		for(int i =0;i<rowNums;i++)
	    {
	        for(int j=0;j<colNums;j++)
	        {
	           matrix[i][j]=1;
	            
	          
	        }
	    }
		matrix[1][2]=0;
		matrix[2][1]=0;
	}

	private static void displayMatrix()
	{
		for(int i =0;i<rowNums;i++)
	    {
			
	        for(int j=0;j<colNums;j++)
	        {
	           System.out.print(matrix[i][j] +"\t");
	            
	          
	        }
	        System.out.println("\n");
	    }	
			System.out.println("************************");
	}
	private static void testSetRowColToZero()
	{
	    
	    List<MatRowCol> list =new ArrayList<MatRowCol>();
	    for(int i =0;i<rowNums;i++)
	    {
	        for(int j=0;j<colNums;j++)
	        {
	            if(matrix[i][j]==0)
	            {
	            	
	               
	               list.add(new MatRowCol(i,j));
	                
	            }
	        
	        }
	    }
	    
	    for(int k=0;k<list.size();k++)
	    {
	    updateRowAndColToZero(list.get(k).row, list.get(k).col);
	    }
	}

	private static void updateRowAndColToZero(int row, int col)
	{
	//	System.out.println(row+" "+col+"yo"+rowNums+" "+colNums);
	    for(int j=0;j<colNums;j++)
	    {
	        matrix[row][j]=0;
	    }
	     for(int i=0;i<rowNums;i++)
	    {
	        matrix[i][col]=0;
	    }

	}

	private static class MatRowCol{
	 int row;
	 int col;
	 MatRowCol(int row, int col)
	 {
		 this.row=row;
		 this.col=col;
	 }
	}
}
