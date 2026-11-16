package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_2001 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            int answer = 0;

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] board = new int[N+1][N+1];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i+1][j+1] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] sumBoard = new int[N+1][N+1];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sumBoard[i+1][j+1] = board[i+1][j+1];
                }
            }


            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < N + 1; j++) {
                    sumBoard[i][j] = sumBoard[i-1][j] + sumBoard[i][j-1] + sumBoard[i][j] - sumBoard[i-1][j-1];
                } // for j
            } // for i

            for (int i = M; i < N + 1; i++) {
                for (int j = M; j < N + 1; j++) {
                    answer = Math.max(answer, sumBoard[i][j] - sumBoard[i][j-M] - sumBoard[i-M][j] + sumBoard[i-M][j-M]);
                }
            }

            StringBuilder sb = new StringBuilder();

            sb.append("#").append(tc).append(" ").append(answer);
            System.out.println(sb);

            // System.out.println(Arrays.deepToString(board));
            // System.out.println(Arrays.deepToString(sumBoard));
        }

    }
}
