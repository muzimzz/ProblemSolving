package silver;

import java.util.*;
import java.io.*;

public class BOJ_2667_BFS {
    static int N;
    static int[][] board;
    static boolean[][] v;
    static int[] di = {0, 1, 0, -1};
    static int[] dj = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        v = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            // String[] arr = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                board[i][j] = line.charAt(j) - '0';
                // board[i][j] = Integer.parseInt(arr[j]);
            }
        }

        int cnt = 0;
        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!v[i][j] && board[i][j] == 1) {
                    v[i][j] = true;
                    cnt++;
                    answerList.add(dfs(i, j));
                    // sb.append(dfs(i, j)).append("\n");
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cnt).append("\n");
        answerList.sort(null);
        for (int answer : answerList) {
            sb.append(answer).append("\n");
        }
        System.out.println(sb);

    }

    public static int dfs(int ci, int cj) {
        int cnt = 1;
        for (int d = 0; d < 4; d++) {
            int ni = ci+di[d];
            int nj = cj+dj[d];

            if (0 <= ni && ni < N && 0 <= nj && nj < N && !v[ni][nj] && board[ni][nj] == 1) {
                v[ni][nj] = true;
                cnt += dfs(ni, nj);
            }
        }

        return cnt;
    }
}
