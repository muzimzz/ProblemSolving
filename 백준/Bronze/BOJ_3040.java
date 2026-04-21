package bronze;

import java.util.*;
import java.io.*;

public class BOJ_3040 {

    static int N = 9;
    static int[] input = new int[N];
    static int[] answer = new int[7];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < N; i++)
            input[i] = Integer.parseInt(br.readLine());

        dfs(0, 0, 0);

        System.out.println(sb);
    }

    public static void dfs(int idx, int start, int sum) {

        if (idx == 7) {
            if (sum == 100) {
                for (int a : answer) {
                    sb.append(a).append("\n");
                }

            }
            return;
        }

        for (int i = start; i < N; i++) {
            answer[idx] = input[i];
            dfs(idx+1, i+1, sum + input[i]);
        }
    }
}
