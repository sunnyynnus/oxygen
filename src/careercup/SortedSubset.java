package careercup;

import java.util.*;

/* Given sorted array A, and number k, find count of subsets A' of A
 such that min(A') + max(A') < k */

public class SortedSubset{

	public static void main(String[] args){
		int[] arr = {-1, 1, 2, 3, 4, 9, 19, 29, 39, 49};
		int k = 35;
		SortedSubset obj = new SortedSubset();
		System.out.println("count = "+obj.getAllSubsetsCountBruteForce(arr, k));
	}

	public long getAllSubsetsCountBruteForce(int[] arr, int k){
		
		long count = 0;
		long maxPossibleCount = (long)Math.pow(2, arr.length) - 1;
		
		if(2*arr[arr.length-1] < k){
			return maxPossibleCount;
		}
		
		if(2*arr[0] > k){
			return 0;
		}
			
		while(maxPossibleCount > 0){
			String binaryNum = Long.toBinaryString(maxPossibleCount);
			// min(A') index
			int leftMostSetBitPosition = arr.length - binaryNum.length();
			// max(A') index
			int rightMostSetBitPosition = leftMostSetBitPosition + binaryNum.lastIndexOf("1");
			
			if(arr[leftMostSetBitPosition]+arr[rightMostSetBitPosition] < k){
				count++;
			}
			maxPossibleCount--;
		}
		
		return count;
	}

}
