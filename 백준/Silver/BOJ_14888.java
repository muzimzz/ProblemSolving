package silver;

import java.io.*;
import java.util.*;

public class BOJ_14888 {

    static int N;
    static int[] arr;
    static int[] op = new int[4];
    static int minAnswer = 1_000_000_000;
    static int maxAnswer = -1_000_000_000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++)
            op[i] = Integer.parseInt(st.nextToken());

        dfs(1, arr[0]);

        System.out.println(maxAnswer);
        System.out.println(minAnswer);
    }

    public static void dfs(int idx, int sum) {
        if (idx >= N) {
            maxAnswer = Math.max(maxAnswer, sum);
            minAnswer = Math.min(minAnswer, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i]--;
                if (i == 0) {
                    dfs(idx + 1, sum + arr[idx]);
                } else if (i == 1) {
                    dfs(idx + 1, sum - arr[idx]);
                } else if (i == 2) {
                    dfs(idx + 1, sum * arr[idx]);
                } else {
                    dfs(idx + 1, sum / arr[idx]);
                }
                op[i]++;
            }
        }
    }
}