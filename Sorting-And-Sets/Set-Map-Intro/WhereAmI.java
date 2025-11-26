//package introToSetsAndMaps;

//https://usaco.org/index.php?page=viewproblem2&cpid=964

import java.util.*;
import java.io.*;

public class WhereAmI {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("whereami.in"));
		int n = Integer.parseInt(br.readLine());
		//System.out.println("n is " + n);
		String str = br.readLine();
		
		br.close();
		
		Set<String> seq = new HashSet<>();
		boolean end = true;
		for(int k = 1; k < n+1; k++) {
			end = true;
			//System.out.println("k is " + k);
			for(int i = 0; i < n-k+1; i++) {
				//System.out.println(str.substring(i, i+k));
				if(seq.contains(str.substring(i, i+k))) {
					end = false;
					break;
					
				}
				
				seq.add(str.substring(i, i+k));
				
			}
			if(end) {
				try (BufferedWriter bw = new BufferedWriter(new FileWriter("whereami.out"))) {
		            bw.write(String.valueOf(k));
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
				break;
			}
			
			seq.clear();
		}
		
			
		
		
	}

}
