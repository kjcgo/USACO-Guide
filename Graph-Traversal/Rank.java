package graph_traversal;
import java.io.*;
import java.util.*;
//https://dmoj.ca/problem/acsl1p4
public class Rank {
	static ArrayList<Integer>[] adj;
	static boolean[] visited;
	static boolean cycle;
	static boolean[] cyclicNode;
	static boolean first = true;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int k = Integer.parseInt(line[1]);
		
		//initialize adjacency matrix and arrays
		adj = new ArrayList[n];
		for(int i = 0; i < n; i++) { adj[i] = new ArrayList<Integer>(); }
		cyclicNode = new boolean[n];
		visited = new boolean[n];
		//System.out.println(n + " " + k);
		//get edges
		for(int i = 0; i < k; i++) {
			line = br.readLine().split(" ");
			int a, b, s_a, s_b;
			a = Integer.parseInt(line[0])-1;
			b = Integer.parseInt(line[1])-1;
			s_a = Integer.parseInt(line[2]);
			s_b = Integer.parseInt(line[3]);
			if(s_a > s_b)
				adj[b].add(a);
			else
				adj[a].add(b);
		}
		
		int ans = 0;
		
		//run a dfs from each node
		for(int i = 0; i < n; i++) {
			
			Arrays.fill(visited, false);
			cycle = false;
			if(dfs(i, i)) {
				ans++;
			}
			
		}
		
		
		System.out.println(ans);
	}
	
	static boolean dfs(int node, int start) {
		if(visited[node] && node == start) {
			cycle = true;
			return true;
		}
		if(visited[node]) {
			//ptl.clear();
			return true;
		}
		
		first = false; 
		visited[node] = true; 
		for(int x : adj[node]) 
			dfs(x, start);
		
		//ptl.clear();
		return cycle;
	}
}
