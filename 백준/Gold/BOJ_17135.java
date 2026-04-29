package gold;

import java.util.*;
import java.io.*;

public class BOJ_17135 {

    static int N, M, D;
    static int[][] board;
    static int size = 3;
    static int[] position = new int[size];
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        board = new int[N+1][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(0, 0);
        System.out.println(answer);
    }

    public static void comb(int start, int idx) {
        if (idx == size) {  // 정답처리
            answer = Math.max(answer, simulation());
            return;
        }

        for (int i = start; i < M; i++) {
            position[idx] = i;
            comb(i+1, idx+1);
        }
    }

    public static int simulation() {

        int[][] tempBoard = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tempBoard[i][j] = board[i][j];
            }
        }

        int killed = 0;

        for (int tc = 0; tc < N; tc++) {
            List<Pos> target = new ArrayList<>();
            for (int p = 0; p < size; p++) {
                int curPos = position[p];
                int minDist = D + 1;
                int ti = -1;
                int tj = -1;
                for (int j = 0; j < M; j++) {
                    for (int i = N - 1; i >= 0; i--) {
                        int dist =  N-i + Math.abs(curPos - j);
                        if (dist < minDist && tempBoard[i][j] == 1) {
                            ti = i;
                            tj = j;
                            minDist = dist;
                        }
                    }
                }
                if (ti != -1) target.add(new Pos(ti, tj));
            }

            for (Pos pos : target) {
                if (tempBoard[pos.i][pos.j] == 1) {
                    tempBoard[pos.i][pos.j] = 0;
                    killed++;
                }
            }

            for (int i = N-1; i >= 0; i--) {
                for (int j = 0; j < M; j++) {
                    if (i == 0) tempBoard[i][j] = 0;
                    else tempBoard[i][j] = tempBoard[i-1][j];
                }
            }
        }
        return killed;
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
