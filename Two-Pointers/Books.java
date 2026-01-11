package twoPointers;
import java.util.*;
import java.io.*;
//https://codeforces.com/problemset/problem/279/B
public class Books {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);
		
		line = br.readLine().split(" ");
		
		int r = -1;
		int minutes = 0;
		int ans = 0;
		//minutes += Integer.parseInt(line[0]);
		
		for(int l = 0; l < n; l++) {
			
			
			//minutes += Integer.parseInt(line[l]);
			
			while(r + 1 < n && minutes + Integer.parseInt(line[r+1]) <= m) {
				r++;
				minutes += Integer.parseInt(line[r]);
				//System.out.println(minutes);
			}
			//System.out.println("L IS " + l + " R IS " + r);
			minutes -= Integer.parseInt(line[l]);
			ans = Math.max(ans, r-l + 1);
			
			
		}
		
		System.out.println(ans);

	}
	
}
