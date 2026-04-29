package gold;

import java.util.*;
import java.io.*;

public class BOJ_16234 {

    static int N, L, R;
    static int[][] board;
    static boolean[][] visited;
    static int[] di = {1, 0, -1, 0};
    static int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        board = new int[N][N];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean flag = true;
        int answer = -1;
        while (flag) {
            answer++;
            visited = new boolean[N][N];
            flag = false;

            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    if (!visited[i][j])
                        if (bfs(i, j))
                            flag = true;
        }

        System.out.println(answer);


    }

    public static boolean bfs(int si, int sj) {
        boolean isMigrated = false;
        Deque<Pos> q = new ArrayDeque<>();
        Pos startPos = new Pos(si, sj);
        visited[si][sj] = true;
        q.offer(startPos);
        List<Pos> tempList = new ArrayList<>();
        tempList.add(startPos);
        int tempSum = board[si][sj];

        while (!q.isEmpty()) {
            Pos curr = q.poll();
            int ci = curr.i;
            int cj = curr.j;
            for (int d = 0; d < 4; d++) {
                int ni = ci+di[d];
                int nj = cj+dj[d];
                if (canGo(ni, nj)) {
                    int diff = Math.abs(board[ci][cj] - board[ni][nj]);
                    if (L <= diff && diff <= R) {
                        isMigrated = true;
                        Pos nextPos = new Pos(ni, nj);
                        visited[ni][nj] = true;
                        q.offer(nextPos);
                        tempList.add(nextPos);
                        tempSum += board[ni][nj];
                    }
                }
            }
        }

        for (Pos pos : tempList) {
            board[pos.i][pos.j] = tempSum / tempList.size();
        }

        return isMigrated;
    }

    public static boolean canGo(int ni, int nj) {
        return 0 <= ni && ni < N && 0 <= nj && nj < N && !visited[ni][nj];
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
