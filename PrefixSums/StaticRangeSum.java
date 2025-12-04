//package prefixSums;

import java.util.Scanner;

// https://judge.yosupo.jp/problem/static_range_sum

public class StaticRangeSum {
	static int N, Q;
	
	public static void main(String[] args) {
		
		//get input
		Scanner scan = new Scanner(System.in);
		
		//get length of list, number of queries
		N = scan.nextInt();
		Q = scan.nextInt();
		
		long[] nums = new long[N];
		
		//populate array of nums
		System.out.println("Enter nums");
		for(int i = 0; i < N; i++) {
			nums[i] = (long)scan.nextInt();
		}
		
		long[] p = pSum(nums);
		
		System.out.println("Enter inputs to solve");
		for(int i = 0; i < Q; i++) {
			int l,r;
			l = scan.nextInt();
			r = scan.nextInt();
			System.out.println(p[r] - p[l]);
		}
		scan.close();
	}
	
	public static long[] pSum(long[]a) {
		
		long[] psums = new long[N+1];
		for(int i = 0; i < N; i++) {
			psums[i+1] = psums[i] + a[i];
		}
		for(long x : psums) {
			System.out.println(x);
		}
		return psums;
		
	}
}
