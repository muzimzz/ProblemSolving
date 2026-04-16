package silver;

import java.util.*;
import java.io.*;

public class BOJ_11725 {

    static int N;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] parent;
    static Stack<Integer> stack;
    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        // graph = new int[N+1];
        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++)
            graph[i] = new ArrayList<>();

        visited = new boolean[N+1];
        parent = new int[N+1];
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int Anode = Integer.parseInt(st.nextToken());
            int Bnode = Integer.parseInt(st.nextToken());
            graph[Anode].add(Bnode);
            graph[Bnode].add(Anode);
        }

        // dfs(1)

        stack = new Stack<>();
        // dfs_stack(1);

        q = new ArrayDeque<>();
        bfs(1);

        // N: 최대 100,000 -> 출력이 많을수록 StringBuilder가 빠름
        for (int i = 2; i <= N; i++) {
            // System.out.println(parent[i]);
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int i) {
        visited[i] = true;
        for (int next : graph[i]) {
            if (!visited[next]) {
                parent[next] = i;
                dfs(next);
            }
        }
    }

    public static void dfs_stack(int root) {
        stack.push(root);
        visited[root] = true;

        while (!stack.isEmpty()) {
            int curr = stack.pop();

            for (int next : graph[curr]) {
                if (!visited[next]) {
                    parent[next] = curr;
                    visited[next] = true;
                    stack.push(next);
                }
            }
        }
    }

    public static void bfs(int root) {
        q.add(root);
        visited[root] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int next : graph[curr]) {
                if (!visited[next]) {
                    parent[next] = curr;
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}
