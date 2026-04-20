package silver;

import java.util.*;
import java.io.*;

public class BOJ_15649 {

    static int N, M;
    static int[] input;
    static int[] answer;
    static boolean[] selected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        input = new int[N];
        selected = new boolean[N];
        answer = new int[M];

        for (int i = 0; i < N; i++) {
            input[i] = i+1;
        }

        dfs(0);

        System.out.println(sb);
    }

    public static void dfs(int idx) {
        if (idx >= M) {
            for (int a : answer)
                sb.append(a).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!selected[i]) {
                selected[i] = true;
                answer[idx] = input[i];
                dfs(idx + 1);
                selected[i] = false;
            }
        }
    }
}
