import java.io.*;

//https://codeforces.com/gym/102951/problem/A

public class MaximumDistance {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] coords = new int[N][2];
		String[] hold;
		
		hold = br.readLine().split(" ");
		//get x vals
		for(int i = 0; i < N; i++) {
			
			coords[i][0] = Integer.parseInt(hold[i]);
			
		}
		hold = br.readLine().split(" ");
		//get y vals
		for(int i = 0; i < N; i++) {
			coords[i][1] = Integer.parseInt(hold[i]);
		}
		
		double a;
		double b;
		double max = 0;
		//compare every coord with each other
		for(int i = 0; i < N; i++) {
			for(int j = i+1; j < N; j++) {
				 a = Math.abs(coords[i][0] - coords[j][0]);
				 b = Math.abs(coords[i][1] - coords[j][1]);
				 
				 //System.out.println("a is " + a + " b is " + b);
				 //System.out.println(Math.pow((Math.pow(a, 2) + Math.pow(b, 2)), .5));
				 
				 max = Math.max(max, (Math.pow(a, 2) + Math.pow(b, 2)));
				 
			}
		}
		
		System.out.println((int)Math.round(max));
		
		
		
	}
}
