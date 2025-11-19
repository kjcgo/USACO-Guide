package introToSorting;
import java.io.*;
import java.util.*;

//https://codeforces.com/contest/863/status

public class Kayaking {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		ArrayList<Integer> people = new ArrayList<>();
		ArrayList<Integer> origPeople = new ArrayList<>();
		String[] inp = br.readLine().split(" ");
		
 		for(int i = 0; i < a * 2; i++) {
			people.add(Integer.parseInt(inp[i]));
			origPeople.add(Integer.parseInt(inp[i]));
		}
 		Collections.sort(origPeople);
 		int totDiff = 0;
 		int bestDiff = Integer.MAX_VALUE;
 		
 		//remove every possible combo of people
 		for(int i = 0; i < (a*2); i++) {
 			for(int j = i+1; j < (a*2); j++) {
 				Collections.sort(people);
 				totDiff = 0;
 				//System.out.println("i " + i + " j " + j);
 				people.remove(i);
 				people.remove(j-1);
 				/*
 				for(int x : people)
 					System.out.println(x);
 				*/
 				for(int k = 0; k < people.size() - 1; k+=2) {
 					
 					totDiff += people.get(k+1) - people.get(k);
 					//System.out.println("totDiff " + totDiff);
 					
 				}
 				bestDiff = Math.min(bestDiff, totDiff);
 				
 				
 				
 				people.clear();
 				people.addAll(origPeople);
 				
 				
 			}
 		}
 		
 		System.out.println(bestDiff);
	}

}
