package gold;

import java.util.*;
import java.io.*;

public class BOJ_7576 {
    static int N, M;
    static int[][] board;
    static boolean[][] visited;
    static int[] di = {0, 1, 0, -1};
    static int[] dj = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];

        List<Pos> startPosList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    startPosList.add(new Pos(i, j));
                }
            }
        }

        bfs(startPosList);

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) {
                    answer = -1;
                    break;
                }
                answer = Math.max(answer, board[i][j]);
            }
            if (answer == -1) {
                break;
            }
        }
        if (answer == -1) {
            System.out.println(answer);
        } else {
            System.out.println(answer - 1);
        }

    }

    public static void bfs(List<Pos> startPosList) {
        Deque<Pos> q = new ArrayDeque<>();
        for (Pos start : startPosList) {
            q.add(start);
            visited[start.i][start.j] = true;
        }
        while (!q.isEmpty()) {
            Pos curr = q.poll();
            int ci = curr.i;
            int cj = curr.j;
            for (int d = 0; d < 4; d++) {
                int ni = ci+di[d];
                int nj = cj+dj[d];
                if (0 <= ni && ni < N && 0 <= nj && nj < M && board[ni][nj] == 0 && !visited[ni][nj]) {
                    q.add(new Pos(ni, nj));
                    visited[ni][nj] = true;
                    board[ni][nj] = board[ci][cj] + 1;
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
}
