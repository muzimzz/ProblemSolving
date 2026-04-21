package silver;

import java.util.*;
import java.io.*;

public class BOJ_2961 {

    static int N, answer = Integer.MAX_VALUE;
    static int[][] input;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        input = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 1, 0, 0);
        System.out.println(answer);
    }

    public static void dfs(int idx, int sour, int bitter, int count) {
        if (idx == N) {
            if (count != 0) {
                answer = Math.min(answer, Math.abs(sour - bitter));
            }
            return;
        }

        dfs(idx + 1, sour * input[idx][0], bitter + input[idx][1], count+1);
        dfs(idx + 1, sour, bitter, count);
    }
}
