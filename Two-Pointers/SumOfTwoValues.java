package twoPointers;
import java.io.*;
import java.util.*;
//https://cses.fi/problemset/task/1640/
public class SumOfTwoValues {
	
	static HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int x = Integer.parseInt(line[1]);
		
		line = br.readLine().split(" ");
		for(int i = 0; i < n; i++) {
			hm.put(Integer.parseInt(line[i]), i);
		}
		
		int target = -1;
		for(int l = 0; l < n; l++) {
			target = x - Integer.parseInt(line[l]);
			if(hm.get(target) != null && hm.get(target) != l) {
				System.out.println(hm.get(target) + 1 + " " + (l+1));
				return;
			} 
		}
		System.out.println("IMPOSSIBLE");
	}
}
