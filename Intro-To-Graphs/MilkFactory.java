package intro_to_graphs;
import java.io.*;
//https://usaco.org/index.php?page=viewproblem2&cpid=940

public class MilkFactory {
	public static void main(String[] args) throws IOException {
	
		//get input
		BufferedReader br = new BufferedReader(new FileReader("factory.in"));
		int n = Integer.parseInt(br.readLine());
		
		int[] out = new int[n+1];
		
		//create adj matrix
		String[] line;
		for(int i = 0; i < n-1; i++) {
			line = br.readLine().split(" ");
			out[Integer.parseInt(line[0])]++;
		}
		
		int ans = -1;
		int x;
		
		for(int i = 1; i < n+1; i++) {
			//System.out.println(out[i]);
			x = out[i];
			if(x == 0 && ans == -1) {
				ans = i;
				//System.out.println("FIRST");
				continue;
			}
			if(x == 0 && ans != -1) {
				ans = -1;
				//System.out.println("SECOND");
				break;
			}
		}
		BufferedWriter bw = new BufferedWriter(new FileWriter("factory.out"));
		bw.write(String.valueOf(ans));
		
		br.close();
		bw.close();
	}

}
