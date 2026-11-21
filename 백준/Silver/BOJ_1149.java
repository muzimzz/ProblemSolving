package silver;

import java.util.*;
import java.io.*;

public class BOJ_1149 {

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

        //red, green, blue
        int[] red = new int[N];
        int[] green = new int[N];
        int[] blue = new int[N];
        red[0] = cost[0][0];
        green[0] = cost[0][1];
        blue[0] = cost[0][2];

        for (int i = 1; i < N; i++) {
            red[i] = Math.min(green[i-1], blue[i-1]) + cost[i][0];
            green[i] = Math.min(red[i-1], blue[i-1]) + cost[i][1];
            blue[i] = Math.min(red[i-1], green[i-1]) + cost[i][2];
        }

        System.out.println(Math.min(red[N-1], Math.min(green[N-1], blue[N-1])));
    }

}
