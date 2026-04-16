package silver;

import java.util.*;
import java.io.*;


public class BOJ_2667_DFS {
    static int N;
    static int[][] board;
    static boolean[][] v;
    static int[] di = {0, 1, 0, -1};
    static int[] dj = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
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
                    answerList.add(bfs(i, j));
                }
            }
        }

        answerList.sort(null);
        StringBuilder sb = new StringBuilder();
        sb.append(cnt).append("\n");
        for(int answer : answerList) {
            sb.append(answer).append("\n");
        }
        System.out.println(sb);

    }

    public static int bfs(int si, int sj) {

        int cnt = 1;
        Deque<Pos> q = new ArrayDeque<>();
        q.add(new Pos(si, sj));
        while (!q.isEmpty()) {
            Pos currPos = q.poll();
            int ci = currPos.i;
            int cj = currPos.j;
            for (int d = 0; d < 4; d++) {
                int ni = ci+di[d];
                int nj = cj+dj[d];
                if (0 <= ni && ni < N && 0 <= nj && nj < N && board[ni][nj] == 1 && !v[ni][nj]) {
                    q.add(new Pos(ni, nj));
                    v[ni][nj] = true;
                    cnt++;
                }
            }
        }

        return cnt;
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
