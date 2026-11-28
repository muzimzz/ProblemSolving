package Silver;

import java.util.*;
import java.io.*;

public class BOJ_1347 {

    static char[][] board = new char[101][101];
    static int[][] dir = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        int d = 0;

        N = Integer.parseInt(br.readLine());
        String cmd = br.readLine();

        for (int i = 0; i <= 100; i++)
            for (int j = 0; j <= 100; j++)
                board[i][j] = '#';

        int ci = 50, cj = 50;
        int si = 50, sj = 50, ei = 50, ej = 50;
        board[ci][cj] = '.';
        for (int i = 0; i < cmd.length(); i++) {
            char c = cmd.charAt(i);

            if (c == 'R') {         // 우회전
                d = (d + 1) % 4;
            } else if (c == 'L') {  // 좌회전
                d = (d + 3) % 4;
            } else {                // 직진
                ci += dir[d][0];
                cj += dir[d][1];
                board[ci][cj] = '.';

                si = Math.min(si, ci);
                ei = Math.max(ei, ci);
                sj = Math.min(sj, cj);
                ej = Math.max(ej, cj);
            }
        }

        sb = new StringBuilder();
        for (int i = si; i <= ei; i++) {
            for (int j = sj; j <= ej; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }

        System.out.print(sb);

    }
}
