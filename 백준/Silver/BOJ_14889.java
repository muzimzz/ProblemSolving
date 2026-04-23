package silver;

import java.util.*;
import java.io.*;

public class BOJ_14889 {
    
    static int N;
    static int[][] board;
    static boolean[] selected;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        selected = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(0, 0);
        System.out.println(answer);
        
    }
    
    public static void dfs(int idx, int start) {
        
        if (idx >= N/2) {
            answer = Math.min(answer, calculate());
            return;
        }
        
        for (int i = start; i < N; i++) {
            selected[i] = true;
            dfs(idx + 1, i + 1);
            selected[i] = false;
        }
    }

    static public int calculate() {

        int scoreA = 0;
        int scoreB = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                    if (selected[i] && selected[j])
                        scoreA += board[i][j];
                    else if (!selected[i] && !selected[j])
                        scoreB += board[i][j];
            }
        }

        return Math.abs(scoreA - scoreB);
    }

}
