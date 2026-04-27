package silver;

import java.util.*;
import java.io.*;

public class BOJ_1260 {

    static int N, M, V;
    static StringBuilder sb = new StringBuilder();
    static List<List<Integer>> nodes = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= N; i++)
            nodes.add(new ArrayList<>());

        for (int i = 0; i < M;  i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            nodes.get(start).add(end);
            nodes.get(end).add(start);
        }

        for (List<Integer> node : nodes)
            node.sort(null);

        visited = new boolean[N + 1];
        dfs(V);
        sb.append("\n");
        visited = new boolean[N + 1];
        bfs(V);

        System.out.println(sb);
    }

    public static void dfs(int curr) {
        visited[curr] = true;
        sb.append(curr).append(" ");
        for (int next : nodes.get(curr)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    public static void bfs(int start) {
        Deque<Integer> q = new ArrayDeque<>();
        visited[start]= true;
        sb.append(start).append(" ");
        q.add(start);

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int next : nodes.get(curr)) {
                if (!visited[next]) {
                    visited[next] = true;
                    sb.append(next).append(" ");
                    q.add(next);
                }
            }
        }
    }
}
