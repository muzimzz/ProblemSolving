package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15650 {

    static int N, M;
    static int[] input;
    static int[] answer;
    // static boolean[] selected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        input = new int[N];
        // selected = new boolean[N];
        answer = new int[M];

        for (int i = 0; i < N; i++) {
            input[i] = i+1;
        }

        dfs(0, 0);

        System.out.println(sb);
    }

    public static void dfs(int idx, int start) {
        if (idx >= M) {
            for (int a : answer)
                sb.append(a).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            answer[idx] = input[i];
            dfs(idx + 1, i + 1);

        }
    }
}

