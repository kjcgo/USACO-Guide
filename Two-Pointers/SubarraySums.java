package twoPointers;
import java.io.*;
//import java.util.*;
//https://cses.fi/problemset/task/1660/
public class SubarraySums {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//make prefix sums
		//iterate over prefix sums
		//increment counter
//		Scanner scan = new Scanner(System.in);
	 	//String[] input = br.readLine().split(" ");
		String[] line = br.readLine().split(" ");
	 	long n = Long.parseLong(line[0]);
	 	long x = Long.parseLong(line[1]);

	 	long[] prefix = new long[(int) (n+1)];
	 	line = br.readLine().split(" ");
	 	for(int i = 1; i < n+1; i++) {
	 		prefix[i] = prefix[i-1] + Long.parseLong(line[i-1]);
	 	}
	 	int counter = 0;
	 	int l = 0; 
	 	int r = 1;
	 	while(l < n + 1 && r < n+1) {
	 		if(prefix[r] - prefix[l] == x) {
	 			counter++;
	 			l++;
	 		}
	 		else if(prefix[r] - prefix[l] > x) {
	 			l++;
	 		}
	 		else {
	 			r++;
	 		}
	 		
	 	}
	 	System.out.println(counter);

	}
	
	
}
