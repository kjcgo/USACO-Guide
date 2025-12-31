package prefixSums;
import java.io.*;
//https://usaco.org/index.php?page=viewproblem2&cpid=572

public class BreedCounting {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("bcount.in"));
		String[] line = br.readLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int q = Integer.parseInt(line[1]);
		
		
		long[] holst = new long[n+1];
		long[] guer = new long[n+1];
		long[] jer = new long[n+1];
		
		int cow = 0;
		for(int i = 1; i < n+1; i++) {
			cow = Integer.parseInt(br.readLine());
			holst[i] += holst[i-1];
			guer[i] += guer[i-1];
			jer[i] += jer[i-1];
			
			if(cow == 1) {
				holst[i]++;
			}
			else if(cow == 2) {
				guer[i]++;
			}
			else
				jer[i]++;
			
		}
	
		BufferedWriter bw = new BufferedWriter(new FileWriter("bcount.out"));
		int a, b;
		for(long i = 0; i < q; i++) {
			line = br.readLine().split(" ");
			a = Integer.parseInt(line[0]) - 1;
			b = Integer.parseInt(line[1]);
			
			bw.write(String.valueOf((holst[b] - holst[a]) + " " + (guer[b] - guer[a]) + " " + (jer[b] - jer[a]) + "\n"));
		
		}
		
		br.close();
		
		
		bw.close();		
	}
	
	
}
