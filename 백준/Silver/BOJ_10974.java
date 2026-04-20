package silver;

import java.io.*;
import java.util.*;

public class BOJ_10974 {

    static int N;
    static boolean[] visited;
    static int[] numArr;
    static int[] answerArr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        answerArr = new int[N];
        numArr = new int[N];
        for (int i = 0; i < N; i++) {
            numArr[i] = i+1;
        }

        dfs(0);

        System.out.println(sb);
    }

    public static void dfs(int idx) {

        if (idx == N) {
            for (int n : answerArr) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answerArr[idx] = numArr[i];
                dfs(idx + 1);
                visited[i] = false;
            }
        }
    }
}
