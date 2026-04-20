package gold;

import java.io.*;
import java.util.*;

public class BOJ_1941 {

    static int N = 5;
    static int SIZE = 7;
    static char[][] board = new char[N][N];
    static int[][] newBoard;
    static boolean[][] visited;
    static boolean[] selected = new boolean[N*N];
    static int[] temp = new int[SIZE];
    static int answer;
    static int[] di = new int[] {0, 1, 0, -1};
    static int[] dj = new int[] {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        dfs(0, 0);

        System.out.println(answer);
    }

    public static void dfs(int start, int idx) {
        // System.out.println(Arrays.toString(temp));
        if (idx >= SIZE) {
            int c = 0;
            for (int t : temp) {
                if (board[t/N][t%N] == 'S')
                    c++;
            }
            if (c >= 4 && bfs(temp))
                answer++;

            return;
        }

        for (int i = start; i < N*N; i++) {
            if (!selected[i]) {
                selected[i] = true;
                temp[idx] = i;
                dfs(i+1, idx+1);
                selected[i] = false;
            }
        }
    }

    public static boolean bfs(int[] arr) {
        newBoard = new int[N][N];
        visited = new boolean[N][N];
        Queue<Integer> q = new ArrayDeque<>();
        for (int a : arr) {
            newBoard[a/N][a%N] = 1;
        }

        int start = arr[0];
        q.add(start);
        int cnt = 1;
        visited[start/N][start%N] = true;
        while (!q.isEmpty()) {
            int curr = q.poll();
            int ci = curr / N;
            int cj = curr % N;
            for (int d = 0; d < 4; d++) {
                int ni = ci+di[d];
                int nj = cj+dj[d];
                if (0 <= ni && ni < N && 0 <= nj && nj < N && newBoard[ni][nj] == 1 && !visited[ni][nj]) {
                    visited[ni][nj] = true;
                    q.add(ni*N + nj);
                    cnt++;
                }
            }
        }

        if (cnt == SIZE) {
            return true;
        } else return false;
    }
}
