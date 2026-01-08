//package flood_fill;
//https://cses.fi/problemset/result/15774387/

import java.util.*;
import java.io.*;

public class CountingRooms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");

		int n = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);

		char[][] map = new char[n][m];

		for (int i = 0; i < n; i++) {
			line = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				map[i][j] = line[j].charAt(0);
			}
		}

		/*
		 * for(int i = 0; i < n; i++) { for(int j = 0; j < m; j++) {
		 * System.out.print(map[i][j]); } System.out.println(); }
		 */

		Queue<int[]> pq = new LinkedList<>();


		boolean[][] visited = new boolean[n][m];

		int[][] dir = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

		int counter = 0;
		int[] room = new int[2];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				if (!visited[i][j] && map[i][j] == '.') {
					//System.out.println(i + " " + j);
					counter++;
					
					pq.add(new int[] {i, j});
					
					while (!pq.isEmpty()) {
						room = pq.poll();
						
						if(room[0] < 0 || room[1] < 0 || room[0] > n-1 || room[1] > m-1 || map[room[0]][room[1]] == '#' || visited[room[0]][room[1]]) {
							continue;
						}
						
						visited[room[0]][room[1]] = true;
						
						// look in the four directions
						for (int k = 0; k < 4; k++) {
							pq.add(new int[] {room[0] + dir[k][0], room[1] + dir[k][1]});
						}

					}
					
				}
			}
		}
		System.out.println(counter);
		

	}
}
