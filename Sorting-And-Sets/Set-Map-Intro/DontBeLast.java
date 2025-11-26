package introToSetsAndMaps;

//https://usaco.org/index.php?page=viewproblem2&cpid=687

import java.io.*;
import java.util.*;

public class DontBeLast {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("notlast.in"));
		int n = Integer.parseInt(br.readLine());
		
		HashMap<String, Integer> cows = new HashMap<>();
		
		String[] names = new String[] {"Bessie", "Elsie", "Daisy", "Gertie", "Annabelle", "Maggie", "Henrietta"};
		
		for(int i = 0; i < 7; i++) {
			cows.put(names[i], 0);
		}
		
		String[] inp;
		for(int i = 0; i < n; i++) {
			
			inp = br.readLine().split(" ");
			
			if(cows.containsKey(inp[0])) {
				//System.out.println("Adding " + inp[0]);
				cows.put(inp[0], cows.get(inp[0]) + Integer.parseInt(inp[1]));
				
			}
				
			else {
				//System.out.println("Adding " + inp[0]);
				cows.put(inp[0], Integer.parseInt(inp[1]));
			}
			
		}
		
		int least = Integer.MAX_VALUE;
		int sLeast = Integer.MAX_VALUE;
		
		
		String cLeast = "Tie";
		
		for(Map.Entry<String, Integer> mapElement: cows.entrySet()) {
			//System.out.println(mapElement.getKey() + " has " + mapElement.getValue());
			if(mapElement.getValue() < least) {
				least = mapElement.getValue();
			}		
		}
		
		for(Map.Entry<String, Integer> mapElement: cows.entrySet()) {
			
			if(mapElement.getValue() != least) {
				
				if(mapElement.getValue() == sLeast) {
					//System.out.println("TIES "+ mapElement.getValue() + " " + mapElement.getKey());

					cLeast = "Tie";
				}
				if(mapElement.getValue() < sLeast) {
					//System.out.println(mapElement.getValue() + " " + mapElement.getKey());
					sLeast = mapElement.getValue();
					cLeast = mapElement.getKey();
				}
				
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("notlast.out"));
		
		bw.write(cLeast);
		
		System.out.println(cLeast);
		bw.close();
		br.close();
		
		
		
	}
}
