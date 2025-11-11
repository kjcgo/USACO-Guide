//https://usaco.org/index.php?page=viewproblem2&cpid=963

import java.io.*;
import java.util.*;


public class CowGymnastics {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		
		int a = Integer.parseInt(line[0]);
		int b = Integer.parseInt(line[1]);
		
		ArrayList<int[]> pairs = new ArrayList<>();
		ArrayList<int[]> newPairs = new ArrayList<>();
		
		int[] pr = new int[2];
		
		//read the initial line to find the pairs
		line = br.readLine().split(" ");
		for(int i = 0; i < b; i++) {
			for(int j = i+1; j < b; j++) {
				pr = new int[] {Integer.parseInt(line[i]),Integer.parseInt(line[j])};
				pairs.add(pr);
			}
		}
		for(int[] x : pairs) {
			newPairs.add(x.clone());
		}

		/*
		
		*/
		
		String inp;
		//for every line
		for(int i = 0; i < a-1; i++) {
			 inp = br.readLine().replaceAll(" ", "");
			 //System.out.println(inp);
			 
			 //System.out.println("NEW ROW");
			 for(int j = 0; j < pairs.size(); j++) {
				 
				 //if the index of the first in the pair in the string
				 //is greater than the index of the second in the pair in the string
				 //remove from valid pairs
				 //System.out.println(pairs.get(j)[0] + " " + pairs.get(j)[1]);
				 
				 //System.out.println("INDEXES");
				 //System.out.println(pairs.get(j)[0] +" "+  pairs.get(j)[1]);
				 
				 //System.out.println("Here " + inp.indexOf((char)pairs.get(j)[0]+ '0'));
				 //System.out.println("here again " + inp.indexOf((char)pairs.get(j)[1] + '0'));
				 
				 if(inp.indexOf((char)pairs.get(j)[0]+ '0') > inp.indexOf((char)pairs.get(j)[1] + '0')) {
					
					 //System.out.println("removing " + pairs.get(j)[0] + " " + pairs.get(j)[1]);
					 int q = pairs.get(j)[0];
					 int r = pairs.get(j)[1];
					 newPairs.removeIf(arr -> arr[0] == q && arr[1] == r);
					 
					 //System.out.println("removed");
				 }
			 }
		}
		
		/*
		 for(int[] x : newPairs) {
				System.out.println(x[0] + " " + x[1]);
			}
		*/
		System.out.println(newPairs.size());
		
	}
}
