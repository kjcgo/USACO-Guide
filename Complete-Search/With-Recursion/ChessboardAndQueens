package basic_complete_search;
import java.io.*;
import java.util.*;

//https://cses.fi/problemset/task/1624
//https://usaco.guide/CPH.pdf#page=60 - referenced
//recursion is confusing >_<

public class ChessboardAndQueens {
	final static int n = 8;
	
	final static boolean[] rows = new boolean[n];
	final static boolean[] diag1 = new boolean[n * 2 -1];
	final static boolean[] diag2 = new boolean[n * 2 -1];
	
	
	//if a square is avaialble
	static boolean avail[][] = new boolean[n][n];
	
	static int counter = 0;
	
	
	
	public static void main(String[] args) throws IOException {
		for(int i = 0; i < n; i++) {
			Arrays.fill(avail[i], true);
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] check;
		for(int i = 0; i < n; i++) {
			check = br.readLine().split("");
			for(int j = 0; j < n; j++) {
				if(check[j].equals("*")) {
					avail[i][j] = false;
				}
			}
		}
		solve(0);
		
		System.out.println(counter);
		
	}
	
	//we are at some row, trying to place a queen at some column
	static void solve(int c) {
		//System.out.println(c);
		if(c == n) {
			counter++;
			return;
		}
		
		for(int r = 0; r < n; r++) {
			
			boolean row_open = !rows[r];
			boolean diag_open = !diag1[r+c] && !diag2[r-c+n-1];
			if(avail[r][c] && row_open && diag_open)	{
				rows[r] = diag1[r+c] = diag2[r - c + n-1] = true;
				solve(c+1);
				
				rows[r] = diag1[r+c] = diag2[r - c + n-1] = false;
				
			}		
			
			/*
			for(int a = 0; a < n; a++) {
				Arrays.fill(avail[a], true);
			}
			*/
			
			
		}
		
	}
	
}
