package gold;

import java.util.*;
import java.io.*;

public class BOJ_1753 {

    static int N, M;
    static List<List<Node>> adj = new ArrayList<>();
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[N + 1];
        for (int i = 1; i <= N; i++)
            dist[i] = Integer.MAX_VALUE;

        for (int i = 0; i <= N; i++)
            adj.add(new ArrayList<>());

        int start = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adj.get(s).add(new Node(e, weight));
        }

        bfs(start);

        for (int i = 1; i <= N; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                sb.append("INF\n");
            else
                sb.append(dist[i]).append("\n");
        }

        System.out.println(sb);

    }

    static class Node {
        int end;
        int weight;
        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    public static void bfs(int start) {
        Queue<Node> q = new PriorityQueue<>((o1, o2) -> {
            return o1.weight - o2.weight;
        });
        q.add(new Node(start, 0));
        dist[start] = 0;
        while (!q.isEmpty()) {
            Node currNode = q.poll();
            int curr = currNode.end;
            int currWeight = currNode.weight;
            if (currWeight > dist[curr])
                continue;
            for (Node nextNode : adj.get(curr)) {
                int next = nextNode.end;
                int newWeight = currWeight + nextNode.weight;
                if (dist[next] > newWeight) {
                    dist[next] = newWeight;
                    q.add(new Node(next, newWeight));
                }
            }
        }
    }
}
