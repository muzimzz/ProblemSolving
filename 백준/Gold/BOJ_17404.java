package gold;

import java.util.*;
import java.io.*;

public class BOJ_17404 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] cost = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		// red가 마지막 집
		int[] red = new int[N];
		int[] green = new int[N];
		int[] blue = new int[N];
		
		red[0] = 1001;
		green[0] = cost[0][1];
		blue[0] = cost[0][2];
		
		for (int i = 1; i < N-1; i++) {
			red[i] = Math.min(green[i-1], blue[i-1]) + cost[i][0];  
			green[i] = Math.min(red[i-1], blue[i-1]) + cost[i][1]; 
			blue[i] = Math.min(red[i-1], green[i-1]) + cost[i][2]; 
		}
		
		int ans_red = Math.min(green[N-2], blue[N-2]) + cost[N-1][0];

		
		//green이 마지막 집
		red = new int[N];
		green = new int[N];
		blue = new int[N];
		
		red[0] = cost[0][0];
		green[0] = 1001;
		blue[0] = cost[0][2];
		
		for (int i = 1; i < N-1; i++) {
			red[i] = Math.min(green[i-1], blue[i-1]) + cost[i][0];  
			green[i] = Math.min(red[i-1], blue[i-1]) + cost[i][1]; 
			blue[i] = Math.min(red[i-1], green[i-1]) + cost[i][2]; 
		}
		
		int ans_green = Math.min(red[N-2], blue[N-2]) + cost[N-1][1];
		
		// blue가 마지막 집
		red = new int[N];
		green = new int[N];
		blue = new int[N];
		
		red[0] = cost[0][0];
		green[0] = cost[0][1];
		blue[0] = 1001;
		
		for (int i = 1; i < N-1; i++) {
			red[i] = Math.min(green[i-1], blue[i-1]) + cost[i][0];  
			green[i] = Math.min(red[i-1], blue[i-1]) + cost[i][1]; 
			blue[i] = Math.min(red[i-1], green[i-1]) + cost[i][2]; 
		}
		
		int ans_blue = Math.min(green[N-2], red[N-2]) + cost[N-1][2];
		
		System.out.println(Math.min(ans_blue, Math.min(ans_red, ans_green)));
		
	}

}
