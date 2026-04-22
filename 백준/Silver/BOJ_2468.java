package silver;

import java.util.*;
import java.io.*;

public class BOJ_2468 {

    static int N;
    static int[][] board;
    static int[][] newBoard;
    static boolean[][] visited;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};
    static int minBoard = 100, maxBoard = 1; // 강수량: 1이상 100이하
    static int answer = 1;  // 최소(아무 땅도 잠기지 않았을 경우): 1

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // Input
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        newBoard = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                minBoard = Math.min(minBoard, board[i][j]);
                maxBoard = Math.max(maxBoard, board[i][j]);
            }
        }

        // Logic
        for (int rain = minBoard; rain < maxBoard; rain++) {

            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    newBoard[i][j] = Math.max(0, board[i][j] - rain);
                }
            }

            int temp = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && newBoard[i][j] > 0) {
                        bfs(i, j);
                        temp++;
                    }
                }
            }

            answer = Math.max(temp, answer);
        }
        System.out.println(answer);
    }

    public static void bfs(int si, int sj) {

        Queue<Pos> q = new ArrayDeque<>();
        visited[si][sj] = true;
        q.add(new Pos(si, sj));

        while (!q.isEmpty()) {
            Pos curr = q.poll();
            int ci = curr.i;
            int cj = curr.j;
            for (int d = 0; d < 4; d++) {
                int ni = ci+di[d];
                int nj = cj+dj[d];
                if (canGo(ni, nj)) {
                    visited[ni][nj] = true;
                    q.add(new Pos(ni, nj));
                }
            }
        }
    }

    public static boolean canGo(int ni, int nj) {
        return 0 <= ni && ni < N && 0 <= nj && nj < N && !visited[ni][nj] && newBoard[ni][nj] > 0;
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
