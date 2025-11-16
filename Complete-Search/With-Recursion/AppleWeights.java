package basic_complete_search;
import java.io.*;

//1.  adding weight to either the first or second set
//2. store sum1 and sum2 with sum of values in each
//3. return difference at end

// Resources: 
// https://cses.fi/problemset/result/15310028/
// code is from - https://usaco.guide/bronze/complete-rec
// very helpful video explaination - https://www.youtube.com/watch?v=fjqJVMJlykw 
// simulating the decision tree! iterate over the list, decide to put the ith apple
// in either group 1 or group 2. Once we have done this with every apple, return the difference


public class AppleWeights {
	static int n; 
	static int[] weights;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String[] line = br.readLine().split(" ");
		
		weights = new int[n];
		
		for(int i = 0; i < n; i++) {
			weights[i] = Integer.parseInt(line[i]);
		}
		
		// starting with the first apple. the sum of both sets are 0
		System.out.println(recurseApples(0, 0, 0));
	}
	
	static long recurseApples(int index, long sum1, long sum2) {
		//if we have reached the end of the list
		if(index == n) {
			return Math.abs(sum1 - sum2);
		}
		//increasing the index so we add the next apple next time
		//add new weight to either sum1 or sum2
		return Math.min(recurseApples(index + 1, sum1 + weights[index], sum2), 
				recurseApples(index + 1, sum1, sum2 + weights[index]));

	}
}
