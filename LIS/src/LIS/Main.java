package LIS;
// question -
// Use an array based stack to solve the “longest increasing subsequence problem”
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int array[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15}; // this is the array i am passing in it should return 6 because {0,2,6,9,11,15}
        int n = array.length; // arrays length
        System.out.println("Length of LIS: " + findLIS(array, n)); // printing it out
		
	}
	
	public static int findLIS(int arr[], int n){
		
		if(arr == null || n==0) {
			return -1; // if its empty or arr.length is 0 than return -1
		}
		
		int lisLength[] = new int[n]; // making a new array list and storing n in it
		
		for(int i = 0; i < arr.length; i++) {
			lisLength[i]=1; // filling in the array with just 1
		}
		
		for(int i = 0; i < n; i++) { // for loop inside a for loop
			for( int j = 0; j<i;j++) {
				if(arr[i]>arr[j] && lisLength[i] < lisLength[j]+1) { // ex: if 1>0 than it goes to next number until it finds a number greater than it and than it stores it
					lisLength[i] = lisLength[j] +1;
				}
			}
			
		}
		//return Arrays.stream(lis).max().orElse(0);
		// the code below finds the max value in the lisLength it will be 6 in this example
		int max = 0;
		for(int i = 0; i < n; i++) {
			if(max<lisLength[i]) {
				max = lisLength[i];
			}
		} // this for loop does the same work as line 38 that i commented out
		return max; // return value
	}
        
}
