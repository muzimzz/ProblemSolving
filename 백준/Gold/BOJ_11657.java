package gold;

import java.util.*;
import java.io.*;

public class BOJ_11657 {

    static int N, M;
    static List<List<Node>> adj = new ArrayList<>();
    static long[] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cost = new long[N+1];
        for (int i = 1; i <= N; i++)
            cost[i] = Long.MAX_VALUE;

        for (int i = 0; i <= N; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj.get(s).add(new Node(e, w));
        }

        int start = 1;
        if (bellmanFord(start)) {
            for (int e = 2; e <= N; e++) {
                if (cost[e] == Long.MAX_VALUE) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(cost[e]).append("\n");
                }
            }
        } else {
            sb.append(-1).append("\n");
        }

        System.out.println(sb);

    }

    public static class Node {
        int to;
        int cost;
        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
    
    public static boolean bellmanFord(int start) {
        cost[start] = 0;
        for (int i = 0; i < N-1; i++) {
            for (int s = 1; s <= N; s++) {
                if (cost[s] == Long.MAX_VALUE) continue;
                for (Node nextNode : adj.get(s)) {
                    int next = nextNode.to;
                    long newCost = cost[s] + nextNode.cost;
                    if (cost[next] > newCost)
                        cost[next] = newCost;
                }
            }
        }

        for (int s = 1; s <= N; s++) {
            if (cost[s] == Long.MAX_VALUE) continue;
            for (Node nextNode : adj.get(s)) {
                int next = nextNode.to;
                long newCost = cost[s] + nextNode.cost;
                if (cost[next] > newCost)
                    return false;
            }
        }

        return true;
    }
}
