package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class SWEA_1249 {

    public static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[] di = {0, 1, 0, -1};
        int[] dj = {1, 0, -1, 0};

        for (int tc = 1; tc <= T; tc++) {

            N = Integer.parseInt(br.readLine());

            int[][] board = new int[N][N];
            int[][] dist = new int[N][N];

            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    board[i][j] = line.charAt(j) - '0';
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }

            int si = 0, sj = 0 ;
            dist[si][sj] = 0;

            Deque<int[]> q = new ArrayDeque<>();
            q.add(new int[]{si, sj});

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int ci = cur[0], cj = cur[1];
                for (int d = 0; d < 4; d++) {
                    int ni = ci+di[d], nj = cj+dj[d];
                    if (canGo(ni ,nj) && dist[ni][nj] > dist[ci][cj] + board[ni][nj]) {
                        q.add(new int[]{ni, nj});
                        dist[ni][nj] = dist[ci][cj] + board[ni][nj];
                    }
                }
            }

            System.out.println("#" + tc + " " + dist[N-1][N-1]);

        }

    }

    public static boolean canGo(int i, int j) {

        return i >= 0 && i < N && j >= 0 && j < N;
    }
}
