//package prefixSums;
import java.io.*;
import java.util.*;

//https://usaco.org/index.php?page=viewproblem2&cpid=595

public class SumToSevens {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("div7.in"));
		int n = Integer.parseInt(br.readLine());
		long[] cows = new long[n];
		for(int i = 0; i < n; i++) {
			cows[i] = Long.parseLong(br.readLine());
		}
		
		String ans = String.valueOf(solve(prefixSums(cows, n), n));
		BufferedWriter bw = new BufferedWriter(new FileWriter("div7.out"));
		bw.write(ans);
		
		bw.close();
		br.close();
	}
	
	public static long[] prefixSums(long[] x, int n) {
		
		long[] sums = new long[n+1];
		sums[0] = 0;
		//System.out.print(sums[0] + "    ");
		for(int i = 1; i < n + 1; i++) {
			sums[i] = (sums[i-1] + x[i-1]) % 7;
			//System.out.print(sums[i] + "    ");
		}
		//System.out.println();
		
		return sums;
	}
	
	
	public static long solve(long[] x, int n) {
		int[] first = new int[7];
		long max = 0;
		Arrays.fill(first, -1);
		
		for(int i = 0; i < n; i++) {
			if(first[(int)x[i]] == -1) {
				first[(int)x[i]] = i;
			}
			
			else {
				max = Math.max(max, i - first[(int)x[i]]);
			}
		}
		
		return max;
	}
}
