package hyundai;

import java.util.*;

public class PlayfairCipher {

    static int[] alpha = new int[26];
    static int N = 5;
    static char[][] board = new char[N][N];
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String msg = sc.next();
        String key = sc.next();

        for (int i = 0; i < alpha.length; i++)
            if (i != 'J' - 'A')
                alpha[i] = 1;

        int cnt = 0;
        for (int i = 0; i < key.length(); i++) {
            if (alpha[key.charAt(i) - 'A'] != 0) {
                board[cnt/N][cnt%N] = key.charAt(i);
                alpha[key.charAt(i) - 'A'] = 0;
                cnt++;
            }
        }

        for (int i = 0; i < alpha.length; i++) {
            if (i == 'J' - 'A')
                continue;

            if (alpha[i] != 0) {
                board[cnt/N][cnt%N] = (char)(i + 'A');
                cnt++;
            }
        }

        sb = new StringBuilder(msg);
        int idx = 0;
        while (idx < sb.length() - 1) {
            char curr = sb.charAt(idx);
            char next = sb.charAt(idx+1);
            if (curr == next) {
                if (curr == 'X') { sb.insert(idx+1, 'Q'); }
                else { sb.insert(idx+1, 'X');}
            }
            idx += 2;
        }

        if (sb.length() % 2 == 1)
            sb.append('X');

        idx = 0;
        while (idx < sb.length()) {
            Pos pos = getPos(sb.charAt(idx), sb.charAt(idx+1));
            if (pos.a_i == pos.b_i) { // 같은 행 검사
                sb.setCharAt(idx, board[pos.a_i][(pos.a_j + 1) % N]);
                sb.setCharAt(idx+1, board[pos.b_i][(pos.b_j + 1) % N]);
            } else if (pos.a_j == pos.b_j) { // 같은 열 검사
                sb.setCharAt(idx, board[(pos.a_i + 1) % N][pos.a_j]);
                sb.setCharAt(idx+1, board[(pos.b_i + 1) % N][pos.b_j]);
            } else {
                sb.setCharAt(idx, board[pos.a_i][pos.b_j]);
                sb.setCharAt(idx+1, board[pos.b_i][pos.a_j]);
            }

            idx += 2;
        }

        System.out.println(sb.toString());
    }

    public static class Pos {
        int a_i;
        int a_j;
        int b_i;
        int b_j;
        public Pos(int ai, int aj, int bi, int bj) {
            this.a_i = ai;
            this.a_j = aj;
            this.b_i = bi;
            this.b_j = bj;
        }
    }

    public static Pos getPos(char A, char B) {

        int ai = 0;
        int aj = 0;
        int bi = 0;
        int bj = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == A) {
                    ai = i;
                    aj = j;
                }
                if (board[i][j] == B) {
                    bi = i;
                    bj = j;
                }
            }
        }

        return new Pos(ai, aj, bi, bj);
    }
}
