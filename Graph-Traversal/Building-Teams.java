//package graph_traversal;
//https://cses.fi/problemset/result/15835753/ 

import java.io.*;
import java.util.*;
 
public class BuildingTeams {
	
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		Kattio io = new Kattio();
		int n = io.nextInt();
		int m = io.nextInt();
 
		
		int[] teams = new int[n+1];
		List<Integer>[] adj = new ArrayList[n+1];
		for(int i = 0; i < n+1; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		//int a, b;
		for(int i = 0; i < m; i++) {
			int a = io.nextInt();
			int b = io.nextInt();
			adj[a].add(b);
			adj[b].add(a);
		}
		boolean valid = true;
	search:
		for(int i = 1; i < n+1; i++) {
			if(teams[i] == 0){
				teams[i] = 1;
			
				ArrayDeque<Integer> q = new ArrayDeque<Integer>();
				q.add(i);
				//System.out.println("NEW LOOP");
				
				
				while(!q.isEmpty()) {
					int current = q.poll();
					//System.out.println("VISITING " + current);
					
					//teams[current] = curr;
					int nColor = teams[current] == 1 ? 2 : 1;
					
					for (int next : adj[current]) {
						if (teams[next] != 0) {
							if (teams[next] != nColor) {
								valid = false;
								break search;
							}
						} else {
							teams[next] = nColor;
							q.push(next);
						}
					}
				}
				
			}
		}
		if(valid) {
			for(int i = 1; i < n+1; i++) {
				io.print(teams[i] + " ");
			}
		}
		else {
			io.println("IMPOSSIBLE");
		}
		io.close();
	}
	
	
}
 
class Kattio extends PrintWriter {
	private BufferedReader r;
	private StringTokenizer st;
	// standard input
	public Kattio() { this(System.in, System.out); }
	public Kattio(InputStream i, OutputStream o) {
		super(o);
		r = new BufferedReader(new InputStreamReader(i));
	}
	// USACO-style file input
	public Kattio(String problemName) throws IOException {
		super(problemName + ".out");
		r = new BufferedReader(new FileReader(problemName + ".in"));
	}
	// returns null if no more input
	public String next() {
		try {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(r.readLine());
			return st.nextToken();
		} catch (Exception e) { }
		return null;
	}
	public int nextInt() { return Integer.parseInt(next()); }
	public double nextDouble() { return Double.parseDouble(next()); }
	public long nextLong() { return Long.parseLong(next()); }
}
