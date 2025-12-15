//package basic_complete_search;

//https://usaco.org/index.php?page=viewproblem2&cpid=712

import java.io.*;
import java.util.*;

public class WhyDidTheCowCrossTheRoadII {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("circlecross.in"));
		String[] temp = br.readLine().split("");
		int[] cows = new int[52];
		//int counter = 0;

		
		for(int i = 0; i < 52; i++) {
			cows[i] = (int) temp[i].charAt(0) - 65;
		}

		//if match has not been found
		boolean[] matched = new boolean[26];
		
		HashSet<Pair> cross = new HashSet<>();
		
		List<Integer> ptl = new ArrayList<>();
		
		for(int i = 0; i < 52; i++) {
			ptl.clear();
			for(int j = i+1; j < 52; j++) {
				if(cows[i] == cows[j])
					break;
				if(!ptl.contains(cows[j]) && !matched[cows[j]]) {
					ptl.add(cows[j]);
				}
				else
					ptl.remove(Integer.valueOf(cows[j]));
			}
			for(int x : ptl) {
				
				cross.add(new Pair(cows[i], x));
			}
			matched[cows[i]] = true;
		}
		
		
		/*
		for(Pair x : cross) {
			System.out.println(x.cow1 + " " + x.cow2);
		}
		*/
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("circlecross.out"));
		bw.write(String.valueOf(cross.size()));
		
		bw.close();
		br.close();
		
		
	}
	
	
}
class Pair {
	int cow1;
	int cow2;

	public Pair(int cow1, int cow2) {
		if(cow1 <= cow2) {
			this.cow1 = cow1;
			this.cow2 = cow2;
		}
		else {
			this.cow2 = cow1;
			this.cow1 = cow2;
			
		}
		
	}
	
	@Override
	public boolean equals(Object obj) {
		return (obj instanceof Pair && cow1 == ((Pair)obj).cow1 && cow2 == ((Pair)obj).cow2);	
	}
	
	@Override
	public int hashCode() {
	    return 31 * cow1 + cow2;
	}
	
}







/*
 * BufferedReader br = new BufferedReader(new FileReader("circlecross.in"));
		String[] cows = br.readLine().split("");
		
		List<List<Integer>> pairs = new ArrayList<>();
		
		boolean[] checked = new boolean[26];
		int counter = 0;
		int[] temp = new int[2];
		
		//(int) cows[x].charAt(0) - 65
		if(!cows[0].equals(cows[1]) && !cows[0].equals(cows[51])) {
			temp[0] = (int) cows[0].charAt(0) - 65;
			temp[1] = (int) cows[1].charAt(0) - 65;
			Arrays.sort(temp);
			pairs.add(List.of(temp[0], temp[1]));
			
		}
		checked[0] = true;
		
		
		for(int i = 1; i < 52 - 1; i++) {
			
			temp[0] = (int) cows[i].charAt(0) - 65;
			temp[1] = (int) cows[i+1].charAt(0) - 65;
			System.out.println(temp[0] + " " + temp[1]);
			
			if(!checked[temp[0]] && temp[0] != temp[1]){
				Arrays.sort(temp);
				if(!pairs.contains(List.of(temp[0], temp[1]))) {
					pairs.add(List.of(temp[0], temp[1]));
				}
				
			}
			checked[temp[0]] = true;

		}
		BufferedWriter bw = new BufferedWriter(new FileWriter("circlecross.out"));
		for(List<Integer> x : pairs) {
			System.out.println(x.get(0) + " " + x.get(1));
			
		}
		System.out.println(pairs.size());
		bw.write(String.valueOf(pairs.size()));
		br.close();
		bw.close();
		
		
 */
