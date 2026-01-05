package graph_traversal;
import java.util.*;
import java.io.*;
//https://cses.fi/problemset/task/1666/
public class BuildingRoads {
	
	static boolean[] visited;
	static ArrayList<Integer>[] adj;
	static ArrayList<Integer> connect = new ArrayList<>();
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);
		
		//1 indexed, 0th element filler
		visited = new boolean[n+1];
		adj = new ArrayList[n+1];
		for(int i = 0; i < n+1; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		
		//make adjacency list
		int a, b;
		for(int i = 0; i < m; i++) {
			line = br.readLine().split(" ");
		
			a = Integer.parseInt(line[0]);
			b = Integer.parseInt(line[1]);
			adj[a].add(b);
			adj[b].add(a);
		}
		
		
		//do dfs from the first city
		int counter = 0;
		
		
		for(int i = 1; i < n+1; i++) {
			if(visited[i])
				continue;
			counter++;
			connect.add(i);
			dfs(i);
		}
		System.out.println(--counter);
		for(int i = 0; i < counter; i++) {
			System.out.println(connect.get(i) + " " + connect.get(i+1));
		}
		
	}
	
	//TODO check the logic here
	static void dfs(int current) {
		if(visited[current]) {
			return;
		}
		visited[current] = true;
		for(int neighbor : adj[current]) {
			dfs(neighbor);
		}
	}
}
