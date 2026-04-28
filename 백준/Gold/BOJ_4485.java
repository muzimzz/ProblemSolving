package gold;

import java.util.*;
import java.io.*;

public class BOJ_4485 {

    static int N;
    static int[][] cost;
    static int[][] board;
    static int[] di = {0, 1, 0, -1};
    static int[] dj = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0)
                break;
            board = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("Problem " + tc + ": ").append(bfs(0, 0)).append("\n");
            tc++;
        }

        System.out.println(sb);
    }

    public static int bfs(int si, int sj) {
        cost = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                cost[i][j] = Integer.MAX_VALUE;
            }
        }

        cost[si][sj] = board[si][sj];
        Deque<Pos> q = new ArrayDeque<>();
        q.add(new Pos(si, sj));

        while (!q.isEmpty()) {
            Pos curr = q.poll();
            int ci = curr.i;
            int cj = curr.j;
            if (board[ci][cj] > cost[ci][cj])
                continue;
            for (int d = 0; d < 4; d++) {
                int ni = ci+di[d];
                int nj = cj+dj[d];
                if (canGo(ni, nj)) {
                    int newCost = cost[ci][cj] + board[ni][nj];
                    if (cost[ni][nj] > newCost) {
                        cost[ni][nj] = newCost;
                        q.add(new Pos(ni, nj));
                    }
                }
            }
        }

        return cost[N-1][N-1];

    }

    public static class Pos {
        int i;
        int j;
        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static boolean canGo(int ni, int nj) {
        return 0 <= ni && ni < N && 0 <= nj && nj < N;
    }
}
