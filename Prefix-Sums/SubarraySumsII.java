//package prefixSums;
import java.io.*;
import java.util.*;
//https://cses.fi/problemset/task/1661/

public class SubarraySumsII {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		
		int n = Integer.parseInt(line[0]);
		long x = Integer.parseInt(line[1]);
		
		line = br.readLine().split(" ");
		//HashMap<Long, Long> nums = new HashMap<>();
		//nums.put((long) 0,(long) 0);
		HashMap<Long, Long> ptl = new HashMap<>();
		long counter = 0;
		long[] nm = new long[n+1];
		ptl.put((long) x, (long) 1);
		for(int i = 1; i < n+1; i++) {
			nm[i] = nm[i-1] + Long.parseLong(line[i-1]);
			if(ptl.get(nm[i]) != null) {
				//System.out.println("increment");
				counter += ptl.get(nm[i]);
			}
			
			//System.out.println(nm[i]);
			if(ptl.get(nm[i] + x) == null) {
				//System.out.println("ADDING: " + (nm[i] + x));
				ptl.put(nm[i] + x, (long) 1);
			}
			else {
				ptl.put(nm[i] + x, ptl.get(nm[i] + x) + (long) 1);
			}
			
			
			
			//if(nums.get(nm[i]) == null) {
			//	nums.put(nm[i], (long)1);
			//}
			//else {
			//	nums.put(nm[i], nums.get(nm[i]) + 1);
			//}
		}
		System.out.println(counter);
	}

}
		//for (Long i : nums.keySet()) {
		//	  System.out.println("key: " + i + " value: " + nums.get(i));
		//	}
		/*
		for(int i : nums) {
			System.out.println(i);
		}
		*/
		/*
		long missing;
		for(int i = 1; i < n+1; i++) {
			
			missing = nm[i] - x;
			System.out.println(missing);
			//if(nums.get(missing) != null)
			//	counter += nums.get(missing);
		}
		*/
		
