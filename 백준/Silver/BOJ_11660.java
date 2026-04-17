package silver;

import java.util.*;
import java.io.*;

public class BOJ_11660 {

    static int N, T, x1, x2, y1, y2;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;


        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        board = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                // board[i][j] = Integer.parseInt(st.nextToken());
                board[i][j] = board[i-1][j] + board[i][j-1] - board[i-1][j-1] + Integer.parseInt(st.nextToken());
            }
        }

//      for (int i = 1; i <= N; i++)
//          for (int j = 1; j <= N; j++)
//              board[i][j] += board[i-1][j] + board[i][j-1] - board[i-1][j-1];


        sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());;
            y1 = Integer.parseInt(st.nextToken());;
            x2 = Integer.parseInt(st.nextToken());;
            y2 = Integer.parseInt(st.nextToken());;

            int sum = board[x2][y2] - board[x1-1][y2] - board[x2][y1-1] + board[x1-1][y1-1];
            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}