package prefixSums;
//https://usaco.org/index.php?page=viewproblem2&cpid=691
//import java.util.*;

import java.io.*;

public class HoofPaperScissors {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("hps.in"));
		int n = Integer.parseInt(br.readLine());
		
		int[][] moves = new int[3][n+1];
		/*
		int[] h = new int[n + 1];
		int[] p = new int[n + 1];
		int[] s = new int[n + 1];
		*/
		
		for (int i = 1; i < n+1; i++) {
			moves[0][i] += moves[0][i-1];
			moves[1][i] += moves[1][i-1];
			moves[2][i] += moves[2][i-1];
			
			/*
			h[i] += h[i - 1];
			p[i] += p[i - 1];
			s[i] += s[i - 1];
			*/
			
			switch (br.readLine().charAt(0)) {
			case 'H':
				moves[0][i]++;
				break;
			case 'P':
				moves[1][i]++;
				break;
			case 'S':
				moves[2][i]++;
				break;
			}

			
		}
		//if starting with h as wins
		
		//find wins if staying with this move
		int curr_wins = 0; int pos_wins = 0; int ans = 0;
		
			for(int i = 1; i < n+1; i++) {
				curr_wins = Math.max(Math.max(moves[0][i], moves[1][i]), moves[2][i]);
			
				pos_wins = Math.max(Math.max(moves[0][n] - moves[0][i], moves[1][n] - moves[1][i]), moves[2][n] - moves[2][i]);
			//System.out.println(curr_wins);
				ans = Math.max(ans, pos_wins + curr_wins);
		}
		//System.out.println(ans);
		BufferedWriter bw = new BufferedWriter(new FileWriter("hps.out"));
		bw.write(String.valueOf(ans));
		bw.close();
		/*
		int curr_wins = 0; int pos_wins = 0;
		
		for(int i = 1; i < n; i++) {
			curr_wins = h[i];
			//System.out.println("S: " + (s[n] - s[i]) + " P: " + (p[n]-p[i]));
			pos_wins = Math.max(p[n] - p[i], s[n] - s[i]);
			//System.out.println(curr_wins + " " + pos_wins);
			if(pos_wins > curr_wins) {
				break;
			}
			//when pos_wins is greater than curr_wins, break and add
		}
		System.out.println(pos_wins + curr_wins);
		*/
		//find wins if switching to another move
		
		br.close();
	}
}
