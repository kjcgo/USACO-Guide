package intro_to_greedy;

import java.io.*;

//https://usaco.org/index.php?page=viewproblem2&cpid=989


public class Race {
	static int K;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("race.in"));
		String[] input = br.readLine().split(" ");
		
		K = Integer.parseInt(input[0]);
		N = Integer.parseInt(input[1]);
		String st = "";
		for(int i = 0; i < N; i++) {
			st += ans(Integer.parseInt(br.readLine())) + "\n";
		}

		BufferedWriter bw = new BufferedWriter(new FileWriter("race.out"));
		bw.write(st);
		
		bw.close();
		br.close();
		
	}
	
	static long ans(long x) {
		long time = 0;
		long dist = 0;
		long speed = 0;
		
		while(dist < K) {
			
			//a second passes
			time++;
			
			//if it's ok increase the speed
			if(ok(dist, speed + 1, x)) {
				//System.out.println("increase");
				speed++;
			}
			//if it's ok stay the same speed
			else if(ok(dist, speed, x)) {
				//System.out.println("same");
				;
			}
			//decrease if necessary
			else {
				//System.out.println("decrease");
				if(speed > 0)
					speed--;
			}
			dist += speed;
			//System.out.println(dist);
			//if we've passed the finish
			if(dist >= K)
				return time;
			
		}
		return -1;
	}
	
	//is it ok to be going at a *potential* speed given our *current* distance
	static boolean ok(long dist, long speed, long limit) {
		//System.out.println("distance needed to slow down at " + speed + " speed and" +  dist + "  distance");
		
		//System.out.println(sumDiff(limit, speed));
		
		return sumDiff(limit, speed) <= K - dist;
		
				
	}
	
	static long sum(long x) {
		return (x*x + x) / 2;
	}
	
	static long sumDiff(long x, long y) {
		return sum(y) - sum(x - 1);
		
	}
}
