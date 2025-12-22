//package intro_to_graphs;
//https://usaco.org/index.php?page=viewproblem2&cpid=965

import java.util.*;
import java.io.*;

public class LivestockLineup {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("lineup.in"));
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<String> cows = new ArrayList<>();
		cows.add("Beatrice");
		cows.add("Belinda");
		cows.add("Bella");
		cows.add("Bessie");
		cows.add("Betsy");
		cows.add("Blue");
		cows.add("Buttercup");
		cows.add("Sue");
		
		
		ArrayList<Integer>[] adj = new ArrayList[8];
		for (int i = 0; i < 8; i++) {
		    adj[i] = new ArrayList<>();
		}
		
		int a = -1;
		int b = -1;
		String[] line = new String[]{};
		for(int i = 0; i < n; i++){
			line = br.readLine().split(" ");
			
			a = cows.indexOf(line[0]);
			b = cows.indexOf(line[line.length - 1]);
			adj[a].add(b);
			adj[b].add(a);
			//System.out.println(a + " " + b);
		}
		
		
		String ans = "";
		boolean[] visited = new boolean[8];
		
		for(int i = 0; i < 8; i++){
			//if it is the start of a chain, adj[i].size() will be 1
			//if it is inside a chain, adj[i].size() will be 2
			//if it is not part of a chain, adj[i].size() will be 0
			
			if(!visited[i] && adj[i].size() <= 1) {
				
				visited[i] = true;
				ans += cows.get(i) + "\n";
				
				//if the start of a chain
				if(adj[i].size() == 1) {
					
					//previous is the current cow, at is the cow's partner
					int prev = i;
					int at = adj[i].get(0);
					
					//while we are in the middle of a chain
					while(adj[at].size() == 2) {
						
						//add the next cow
						visited[at] = true;
						ans += cows.get(at) + "\n";
						
						//middle cows have two neighbors
						int s = adj[at].get(0);
						int t = adj[at].get(1);
						
						//the temp variable is s if t equals the prev and vice versa
						//can't be the previous cow, go to the next cow
						int temp = t == prev ? s : t;
						
						prev = at;
						at = temp;
					}
					
					visited[at] = true;
					ans += cows.get(at) + "\n";
					
				}
				
			}
			
 		}
		BufferedWriter bw = new BufferedWriter(new FileWriter("lineup.out"));
		bw.write(ans);
		
		br.close();
		bw.close();
		
		System.out.println(ans);
	}
}
