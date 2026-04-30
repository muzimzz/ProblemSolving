package gold;

import java.util.*;
import java.io.*;

public class BOJ_2580 {

    static int[][] board = new int[9][9];
    static List<Pos> zeroPos = new ArrayList<>();
    static boolean flag = false;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 0)
                    zeroPos.add(new Pos(i, j));
            }
        }

        dfs(0);
    }

    public static void dfs(int idx) {

        if (flag)
            return;

        if (idx == zeroPos.size()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j]).append(" ");
                }
                sb.append("\n");
            }

            System.out.println(sb);
            flag = true;
            return;
        }

        Pos curr = zeroPos.get(idx);
        int ci = curr.i;
        int cj = curr.j;

        for (int num = 1; num <= 9; num++) {

            if (check(ci, cj, num)) {
                board[ci][cj] = num;
                dfs(idx + 1);
                board[ci][cj] = 0;
            }
        }

    }

    public static boolean check(int ci, int cj, int num) {
        for (int idx = 0; idx < 9; idx++)
            if (board[idx][cj] == num || board[ci][idx] == num)
                return false;

        for (int i = ci - ci%3; i < ci + 3 - ci%3; i++) {
            for (int j = cj - cj%3; j < cj + 3 - cj%3; j++) {
                if (board[i][j] == num)
                    return false;
            }
        }

        return true;
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
