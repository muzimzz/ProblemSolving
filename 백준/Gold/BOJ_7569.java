package gold;

import java.io.*;
import java.util.*;

public class BOJ_7569 {

    static int N, M, H;
    static int[][][] board;
    static int[] di = {0, 1, 0, -1, 0, 0};
    static int[] dj = {1, 0, -1, 0, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        board = new int[H][N][M];

        List<Pos> startPosList = new ArrayList<>();

        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    board[h][i][j] = Integer.parseInt(st.nextToken());
                    if (board[h][i][j] == 1) {
                        startPosList.add(new Pos(h, i, j));
                    }
                }
            }
        }

        bfs(startPosList);

        int answer = 0;
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[h][i][j] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    answer = Math.max(answer, board[h][i][j]);
                }
            }
        }

        System.out.println(answer - 1);
    }

    public static void bfs(List<Pos> startPosList) {
        Deque<Pos> q = new ArrayDeque<>();
        for (Pos start : startPosList) {
            q.add(start);
        }
        while (!q.isEmpty()) {
            Pos curr = q.poll();
            int ch = curr.h;
            int ci = curr.i;
            int cj = curr.j;
            for (int d = 0; d < 6; d++) {
                int nh = ch+dh[d];
                int ni = ci+di[d];
                int nj = cj+dj[d];
                if (0 <= ni && ni < N && 0 <= nj && nj < M && 0 <= nh && nh < H && board[nh][ni][nj] == 0) {
                    q.add(new Pos(nh, ni, nj));
                    board[nh][ni][nj] = board[ch][ci][cj] + 1;
                }
            }
        }
    }

    public static class Pos {
        int i;
        int j;
        int h;
        public Pos( int h, int i, int j) {
            this.h = h;
            this.i = i;
            this.j = j;
        }
    }
}
