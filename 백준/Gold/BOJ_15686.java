package gold;

import java.util.*;
import java.io.*;

public class BOJ_15686 {

    static int N, M, target, minChickenDist = Integer.MAX_VALUE;
    static int[][] board;
    static int[] answer;
    static List<Pos> chickenList;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][N];

        chickenList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 2) {
                    chickenList.add(new Pos(i, j));
                }
            }
        }

        target = chickenList.size()-M;
        answer = new int[target];
        dfs(0, 0);

        System.out.println(minChickenDist);
    }

    public static class Pos {
        int i;
        int j;
        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void dfs(int idx, int start) {

        if (idx >= target) {
            for (int a : answer) {
                 Pos pos = chickenList.get(a);
                 board[pos.i][pos.j] = 0;
            }

            minChickenDist = Math.min(minChickenDist, bfs());

            for (int a : answer) {
                Pos pos = chickenList.get(a);
                board[pos.i][pos.j] = 2;
            }

            return;
        }

        for (int i = start; i < chickenList.size(); i++) {
            answer[idx] = i;
            dfs(idx+1, i+1);
        }
    }

    public static int bfs() {
        int[] di = {1, 0, -1, 0};
        int[] dj = {0, 1, 0, -1};
        int ci, cj, ni, nj;
        int[][] dist;
        int distSum = 0;
        Deque<Pos> q = new ArrayDeque();
        List<Pos> houseList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) {
                    houseList.add(new Pos(i, j));
                }
            }
        }

        for (Pos housePos : houseList) {
            dist = new int[N][N];
            q.add(housePos);
            dist[housePos.i][housePos.j] = 1;
            while (!q.isEmpty()) {
                if (distSum >= minChickenDist) {
                    return distSum;
                }
                Pos curr = q.poll();
                ci = curr.i;
                cj = curr.j;
                if (board[ci][cj] == 2) {
                    distSum += dist[ci][cj] - 1;
                    q.clear();
                    break;
                }
                for (int d = 0; d < 4; d++) {
                    ni = ci+di[d];
                    nj = cj+dj[d];
                    if (0 <= ni && ni < N && 0 <= nj && nj < N && dist[ni][nj] == 0) {
                        dist[ni][nj] = dist[ci][cj] + 1;
                        q.add(new Pos(ni, nj));
                    }
                }
            }
        }

        return distSum;

    }
}
