package graph_traversal;
import java.io.*;
import java.util.*;
//https://usaco.org/index.php?page=viewproblem2&cpid=668
public class Moocast {
	static boolean[] visited;
	static List<Cow>[] adj;
	//static int counter;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("moocast.in"));
		int n = Integer.parseInt(br.readLine());
		String[] line;
		Cow[] cows = new Cow[n];
		visited = new boolean[n];
 		for(int i = 0; i < n; i++) {
			line = br.readLine().split(" ");
			cows[i] = new Cow(i, Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2]));
		}
 		Cow curr;
 		Cow other;
 		
 		
		adj = new List[n];
 		for(int i = 0; i < n; i++) {
 			adj[i] = new ArrayList<Cow>();
 		}
 		
 		boolean[][] canTransmit = new boolean[n][n];
 		
 		for(int i = 0; i < n; i++) {
 			
 			curr = cows[i];
 			
 			for(int j = 0; j < n; j++) {
 				/*
 				if(i == j)
 					continue;
 				*/
 				
 				other = cows[j];
 				//TODO excessive recomputation?
 				//System.out.println("The distance between cow " + i + " and cow " + j + " is " + Math.sqrt(Math.pow((curr.x - other.x), 2) + Math.pow((curr.y - other.y), 2)));
 				if(Math.pow((curr.x - other.x), 2) + Math.pow((curr.y - other.y), 2) <= Math.pow(curr.r, 2)) {
 					//System.out.println("cow " + i + " can reach " + other.id);
 					canTransmit[i][j] = true;
 				}
 			}
 			//max = Math.max(total, max);
 		}
 		int ans = 1;
 		for(int i = 0; i < n; i++) {
 			boolean[] canHear = new boolean[n];
 			ans = Math.max(ans, dfs(i, canHear, canTransmit));
 		}
 		
 		
 		
 		//System.out.println(max);
 		BufferedWriter bw = new BufferedWriter(new FileWriter("moocast.out"));

 		br.close();
 		System.out.println("ANSWER " + ans);
 		bw.write(String.valueOf(ans));
 		bw.close();
	}
	
	static int dfs(int curr, boolean[] canHear, boolean[][] canTransmit) {
		if(canHear[curr]) {
			return 0;
		}
		canHear[curr] = true;
		int ret = 1;
		for(int i = 0; i < canTransmit[curr].length; i++) {
			if(canTransmit[curr][i]) {
				ret += dfs(i, canHear, canTransmit);
			}
		}
		return ret;
	}
}



class Cow {
	int id;
	int x;
	int y;
	int r;
	public Cow(int id, int x, int y, int r) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.r = r;
	}
}
