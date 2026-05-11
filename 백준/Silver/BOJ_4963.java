package silver;

import java.util.*;
import java.io.*;

public class BOJ_4963 {

    static int N, M;
    static int[][] board;
    static boolean[][] visited;
    static int[] di = new int[] {1, 1, 1, 0, -1, -1, -1, 0};
    static int[] dj = new int[] {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            board = new int[N][M];
            visited = new boolean[N][M];

            if (N == 0 && M == 0)
                break;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;
            for (int i = 0; i < N; i ++) {
                for (int j = 0; j < M; j++) {
                    if (canGo(i, j)) {
                        bfs(i, j);
                        answer++;
                    }
                }
            }

            System.out.println(answer);
        }

    }

    public static void bfs(int si, int sj) {
        Deque<Pos> q = new ArrayDeque<>();
        q.offer(new Pos(si, sj));
        visited[si][sj] = true;
        while (!q.isEmpty()) {
            Pos curr = q.poll();
            int ci = curr.i;
            int cj = curr.j;
            for (int d = 0; d < 8; d++) {
                int ni = ci + di[d];
                int nj = cj + dj[d];
                if (canGo(ni, nj)) {
                    q.offer(new Pos(ni, nj));
                    visited[ni][nj] = true;
                }
            }
        }


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
        return 0 <= ni && ni < N && 0 <= nj && nj < M && board[ni][nj] == 1 && !visited[ni][nj];
    }
}
