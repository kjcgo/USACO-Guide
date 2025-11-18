//package introToSorting;
// https://cses.fi/problemset/task/1621
import java.io.*;
import java.util.*;
 
public class DistinctNumbers {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int counter = 1;
		Integer[] nums = new Integer[n];
		
		String[] inp = br.readLine().split(" ");
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(inp[i]);
		}
		
		Arrays.sort(nums);
		for(int i = 0; i < n-1; i++) {
			if(!nums[i].equals(nums[i+1])) {
				counter++;
			}
		}
		
		System.out.println(counter);
	}
}
