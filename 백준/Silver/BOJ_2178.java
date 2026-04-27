package silver;

import java.util.*;
import java.io.*;

public class BOJ_2178 {

    static int N, M;
    static int[][] board;
    static int[][] dist;
    static int[] di = {1, 0, -1, 0};
    static int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++)
                board[i][j] = row.charAt(j) - '0';
        }

        int answer = bfs(0, 0);
        System.out.println(answer);
    }

    static class Pos {
        int i;
        int j;
        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static int bfs(int si, int sj) {
        Deque<Pos> q = new ArrayDeque<>();
        dist[si][sj] = 1;
        q.add(new Pos(si, sj));
        while (!q.isEmpty()) {
            Pos curr = q.poll();
            int ci = curr.i;
            int cj = curr.j;
            System.out.println(ci + " " + cj);
            if (ci == N-1 && cj == M-1)
                return dist[ci][cj];

            for (int d = 0; d < 4; d++) {
                int ni = ci+di[d];
                int nj = cj+dj[d];
                if (0 <= ni && ni < N && 0 <= nj && nj < M && dist[ni][nj] == 0 && board[ni][nj] == 1) {
                    dist[ni][nj] = dist[ci][cj] + 1;
                    q.add(new Pos(ni, nj));
                }
            }
        }
        return -1;
    }
}
