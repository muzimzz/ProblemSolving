package gold;

import java.util.*;
import java.io.*;

public class BOJ_1987 {

    static int N, M;
    static char[][] board;
    static boolean[][] visited;
    static boolean[] used = new boolean[26];
    static int answer = 0;
    static int[] di = {1, 0, -1, 0};
    static int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        visited[0][0] = true;
        used[board[0][0] - 'A'] = true;
        dfs(0, 0, 1);
        System.out.println(answer);
    }

    public static void dfs(int ci, int cj, int cnt) {
        answer = Math.max(answer, cnt);
        for (int d = 0; d < 4; d++) {
            int ni = ci+di[d];
            int nj = cj+dj[d];
            if (canGo(ni, nj)) {
                visited[ni][nj] = true;
                used[board[ni][nj] - 'A'] = true;
                dfs(ni, nj, cnt+1);
                visited[ni][nj] = false;
                used[board[ni][nj] - 'A'] = false;
            }
        }
    }

    public static boolean canGo(int ni, int nj) {
        return 0 <= ni && ni < N && 0 <= nj && nj < M && !visited[ni][nj] && !used[board[ni][nj] - 'A'];
    }

}
