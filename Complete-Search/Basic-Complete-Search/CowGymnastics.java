package basic_complete_search;

//https://usaco.org/index.php?page=viewproblem2&cpid=963

import java.io.*;
import java.util.*;

public class CowGymnastics1{
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new FileReader("gymnastics.in"));
		PrintWriter out = new PrintWriter(new FileWriter("gymnastics.out"));

		//get input
		//rounds plus cow count
		String[] line = br.readLine().split(" ");
		int a = Integer.parseInt(line[0]);
		int b = Integer.parseInt(line[1]);
		
		//all the pairs discovered
		ArrayList<int[]> pairs = new ArrayList<>();
		int pr[];
		
		//read the initial line to find the pairs
		line = br.readLine().split(" ");
		for(int i = 0; i < b; i++) {
			for(int j = i+1; j < b; j++) {
				pr = new int[] {Integer.parseInt(line[i]),Integer.parseInt(line[j])};
				pairs.add(pr);
			}
		}
		
		/*
		for(int[] x : pairs) {
			System.out.println(x[0] + " " + x[1]);
		}
		*/
		ArrayList<int[]> toRemove = new ArrayList<>();
		
		String[] inp;
		ArrayList<Integer> lines = new ArrayList<>();
		//for every line
		for(int i = 0; i < a-1; i++) {
			
			 inp = br.readLine().split(" ");
			 for(String x : inp) {
				 lines.add(Integer.parseInt(x));
			 }
			 //System.out.println(inp);
			 
			 //System.out.println("NEW ROW");
			 for(int[] j : pairs) {
				 
				 if(lines.indexOf(j[0]) > lines.indexOf(j[1])) {
					 
					 toRemove.add(j);
					 //System.out.println("Removing " + j[0] + " " + j[1]);
				 }
			 }
			 
			 for(int[] k : toRemove) {
				 pairs.remove(k);
			 }
			 lines.clear();
			 toRemove.clear();
		}
		
		
		//System.out.println(pairs.size());
		
		
		 
		
		
		out.println(pairs.size());
		
		System.out.println(pairs.size());
		out.close();
		br.close();


		
	}
}
