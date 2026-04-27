package silver;

import java.util.*;
import java.io.*;

public class BOJ_2606 {

    static int N, M;
    static List<List<Integer>> adj = new ArrayList<>();
    static boolean[] visited;
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adj.get(start).add(end);
            adj.get(end).add(start);
        }

        dfs(1);
        System.out.println(answer);
    }

    static public void dfs(int curr) {

        visited[curr] = true;
        answer++;
        for (int next : adj.get(curr)) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next);
            }
        }
    }
}
