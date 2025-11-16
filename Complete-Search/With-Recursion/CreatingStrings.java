package basic_complete_search;

import java.io.*;

public class CreatingStrings {
	
	//how many of each letter appears
	static int[] letters = new int[26];
	static String[] myString;
	static boolean[] counted;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		myString = br.readLine().split("");
		counted = new boolean[myString.length];
		for(String x : myString) {
			letters[(int)x.charAt(0) - 97]++;			
		}
		
		int denom = 0;
		for(int x : letters) {
			if(x > 1) {
				denom += factorial(x);
			}
		}
		if(denom != 0)
				System.out.println(factorial(myString.length) / denom);
		else 
			System.out.println(factorial(myString.length));
		
		solve("");
	}
	
	static void solve(String s) {
		
		//if we've generated a full viable answer
		if(s.length() == myString.length) {
			System.out.println(s);
		}
		
		for(int i = 0; i < 26; i++) {
			if(letters[i] > 0) {
				letters[i]--;
				solve(s + (char)(i + 'a'));
				letters[i]++;
			} 
		}
	}
	
	static int factorial(int x) {
		if(x == 1) {
			return 1;
		}
		else {
			return x * factorial(x-1);
		}
	}
	
}
