//package shortestPathsUnweighted;
//https://cses.fi/problemset/task/1667/
import java.util.*;
import java.io.*;
 
public class MessageRoute {
	
	//map each computer to create access to adjacent computers
	private static Map<Integer, LinkedList<Integer>> adj = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);
		
		for(int i = 0; i < m; i++) {
			line = br.readLine().split(" ");
			int a = Integer.parseInt(line[0]);
			int b = Integer.parseInt(line[1]);
			
			//if we haven't found this computer yet
			if(adj.get(a) == null) {adj.put(a, new LinkedList<>()); }
			if(adj.get(b) == null) {adj.put(b, new LinkedList<>()); }
			
			//add to the adjacency matrix
			adj.get(a).add(b);
			adj.get(b).add(a);
			
		}
		
		//for the parent nodes
		int[] prev = new int[n+1], dist = new int[n+1];
		
		//start out at "infinite" distance
		Arrays.fill(dist,  Integer.MAX_VALUE);
		
		//the first computer starts out with a distance of 1 (why?)
		dist[1] = 1;
		
		Queue<Integer> bfs = new LinkedList<>();
		//start from the first computer
		bfs.add(1);
		
		while(!bfs.isEmpty()) {
			
			int top = bfs.poll();
			
			//distance should have been reset from previous iteration
			if(dist[top] == Integer.MAX_VALUE) continue;
			
			if(adj.get(top) != null) {
				for(int e : adj.get(top)) {
					
					//if unvisited, essentially
					if(dist[e] == Integer.MAX_VALUE) {
						
						//the distance to this node is one more computer away
						dist[e] = dist[top] + 1;
						
						//the parent of this node is the polled node
						prev[e] = top;
						
						//search from this node in the next iteration
						bfs.add(e);
					}
				}
			}
		}
		
		//if the target node is unreachable
		if(dist[n] == Integer.MAX_VALUE) {
			System.out.println("IMPOSSIBLE");
		} else {
			
			//print how long the path is
			System.out.println(dist[n]);
			
			//create space for the path
			int[] res = new int[dist[n]];
			
			//***backtrack through the nodes***
			int i = dist[n] - 1;
			for(int x = n; x != 0; x = prev[x]) { res[i--] = x; }
			for(int a : res) System.out.println(a + " ");
		}
	}
}
