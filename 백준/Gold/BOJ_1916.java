package gold;

import java.sql.Array;
import java.util.*;
import java.io.*;

public class BOJ_1916 {
    static int N, M;
    static List<Node>[] graph;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++)
            graph[i] = new ArrayList<>();

        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken()) - 1;
            int E = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());
            if (graph[S].get(E).cost > cost)
                graph[S].add(new Node(E, cost));



        }


    }



    public static class Node {
        int target;
        int cost;

        public Node(int curr, int cost) {
            this.target = target;
            this.cost = cost;
        }
    }
}