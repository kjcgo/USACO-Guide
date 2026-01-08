//package graph_traversal;

//https://usaco.org/index.php?page=viewproblem2&cpid=644

import java.util.*;
import java.io.*;

public class ClosingTheFarm {
	static boolean[] visited;
	static boolean[] closed;
	static int counter = 0;
	static ArrayList<Integer>[] adj;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("closing.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("closing.out"));
		
		String[] line = br.readLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);
		
		//initiate arrays
		visited = new boolean[n];
		closed = new boolean[n];
		
		//make adjacency list
		adj = new ArrayList[n];
		
		for(int i = 0; i < n; i++) { adj[i] = new ArrayList<Integer>(); }
		
		int a, b;
		
		for(int i = 0; i < m; i++) {
			line = br.readLine().split(" ");
			a = Integer.parseInt(line[0]) - 1;
			b = Integer.parseInt(line[1]) - 1;
			
			adj[a].add(b);
			adj[b].add(a);
		}
		
		int[] order = new int[n];
		
		for(int i = 0; i < n; i++) {
			order[i] = Integer.parseInt(br.readLine()) - 1;
		}
		
		for(int i = 0; i < n; i++) {
			Arrays.fill(visited, false);
			
			//System.out.println("Calling dfs for node n-1");
			dfs(order[n-1]);
			
			//System.out.println(counter);
			
			if(counter == n-i) 
				bw.write("YES\n");
			else
				bw.write("NO\n");
			
			closed[order[i]] = true;
			
			counter = 0;
			
		}
		
		br.close();
		bw.close();
	}
	
	static void dfs(int node) {
		
		if(visited[node] || closed[node])
			return;
		//System.out.println("visiting node... " + node);
		counter++;
		
		visited[node] = true;
		for(int x : adj[node]) {
			dfs(x);
		}
	}
}
