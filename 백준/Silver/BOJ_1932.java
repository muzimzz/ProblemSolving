package silver;

import java.util.*;
import java.io.*;

public class BOJ_1932 {

    static int N;
    static int[][] board;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    board[i][j] += board[i-1][j];
                } else {
                    board[i][j] += Math.max(board[i-1][j-1], board[i-1][j]);
                }
            }
        }

        int answer = board[N-1][0];
        for (int value : board[N-1]) {
            answer = (Math.max(value, answer));
        }

        System.out.println(answer);

    }
}
