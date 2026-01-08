package graph_traversal;

import java.io.*;
import java.util.*;

class BirthdayParty {
	static boolean[] visited;
	static ArrayList<Integer>[] adj;
	static boolean[][] c1;
	static int guests;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line;
		int p, c;
		
		
		boolean stillConnected;

		while (true) {
			line = br.readLine().split(" ");
			p = Integer.parseInt(line[0]);
			c = Integer.parseInt(line[1]);
			
			Edge[] edges = new Edge[c];
			
			if(p == 0 && c == 0) {
				break;
			}
			
			if (p == 1) {
				System.out.println("No");
				continue;
			}
		
			c1 = new boolean[p][p];
			
			// System.out.println(p + " - P");
			
			int q, r;
			for (int i = 0; i < c; i++) {
				line = br.readLine().split(" ");
				q = Integer.parseInt(line[0]);
				r = Integer.parseInt(line[1]);
				c1[r][q] = true;
				c1[q][r] = true;
				edges[i] = new Edge(q, r);
			}
			
			stillConnected = true;
			//simulate removing each person
			for(Edge edge : edges) {
				guests = 0;
				
				c1[edge.a][edge.b] = false;
				c1[edge.b][edge.a] = false;
				
				visited = new boolean[p];
				dfs(0, p);
				if(guests != p) {
					stillConnected = false;
					break;
				}
				c1[edge.a][edge.b] = true;
				c1[edge.b][edge.a] = true;
			}
			if(stillConnected) {
				System.out.println("No");
			}
			else {
				 System.out.println("Yes");
			}
			

		}
		br.close();
	}
	
	static void dfs(int node, int p) {
		//System.out.println("DFS: " + lost + " " +node);
		if(visited[node])
			return;
		
		guests++;
		
		visited[node] = true;
		
		for(int i = 0; i < p; i++) {
			if(c1[node][i]) {
				dfs(i, p);
			}
		}
	}
	
}

class Edge{
	int a;
	int b;
	
	public Edge(int a, int b) {
		this.a = a;
		this.b = b;
	}
}