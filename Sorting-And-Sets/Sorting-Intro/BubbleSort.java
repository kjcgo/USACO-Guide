package introToSorting;
import java.io.*;

// https://www.hackerrank.com/challenges/ctci-bubble-sort/problem
// what a challenge :O

public class BubbleSort {
	static int[] a;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		a = new int[n];
		String[] nums = br.readLine().split(" ");
		int count = 0;
		
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(nums[i]);
		}
		
		for (int i = 0; i < n; i++) {
		    
		    for (int j = 0; j < n - 1; j++) {
		        // Swap adjacent elements if they are in decreasing order
		        if (a[j] > a[j + 1]) {
		        	count++;
		            swap(j, j + 1);
		        }
		    }
		    
		}
		
		System.out.println("Array is sorted in " + count +  " swaps.\n" + 
		"First Element: " + a[0] + "\nLast Element: " + a[n-1]);
	}
	
	public static void swap(int x, int y) {
		
		//System.out.println(x + " " + y);
		
		int temp = a[y];
		a[y] = a[x];
		a[x] = temp;
	}
}
