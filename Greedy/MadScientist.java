// https://usaco.org/current/data/sol_breedflip_bronze_feb20.html
// https://usaco.org/index.php?page=viewproblem2&cpid=1012

//package intro_to_greedy;

import java.io.*;


public class MadScientist {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("breedflip.in"));
		int n = Integer.parseInt(br.readLine());
		String A = br.readLine();
		String B = br.readLine();
		br.close();
		
		boolean match;
		boolean start = false;
		int counter = 0;
		
		for(int i = 0; i < n; i++) {
			
			match = A.charAt(i) == B.charAt(i);
			if(!match) {
				start = true;
			}
			
			if(match && start) {
				start = false;
				match = false;
				counter++;
			}
		}
		
		if(start) {
			counter++;
		}
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("breedflip.out"));
		bw.write(Integer.toString(counter));
		bw.close();
		
	}
}
