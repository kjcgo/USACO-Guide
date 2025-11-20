//package basic_complete_search;
//https://usaco.org/index.php?page=viewproblem2&cpid=736

import java.util.*;
import java.io.*;

public class BovineGenomics {
	

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("cownomics.in"));
		String[] line = br.readLine().split(" ");

		int n = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);

		
		
		// stores info for gene locations
		char[][] spotGenes = new char[m][n];
		char[][] plainGenes = new char[m][n];
		
		boolean pl = false;
		
		String ln;
		for (int k = 0; k < 2; k++) {
			
			for (int i = 0; i < n; i++) {
				ln = br.readLine();
				if (!pl) {
					for(int j = 0; j < m; j++) {
						spotGenes[j][i] = ln.charAt(j);
					}
				} else {
					for(int j = 0; j < m; j++) {
						plainGenes[j][i] = ln.charAt(j);
					}
				}
			}
			pl = true;
		}
		
		int counter = 0;
		
		for(int i = 0; i < m; i++) {
			if(different(spotGenes[i], plainGenes[i]))
				counter++;
		}
		
		PrintWriter pw = new PrintWriter(new FileWriter("cownomics.out"));
		pw.println(counter);
		
		pw.close();
		
		br.close();
		
	}
	
	public static boolean different(char[] a, char[] b) {
		

		Set<Character> uniqueA = new HashSet<>();
		for(char c : a) {

			uniqueA.add(c);
		}
		Set<Character> uniqueB = new HashSet<>();
		for(char c : b) {

			uniqueB.add(c);
		}
		return(Collections.disjoint(uniqueB, uniqueA));
		
		
	}
}
