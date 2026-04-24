package gold;

import java.util.*;
import java.io.*;

public class BOJ_1717 {

    static int N, M;
    static int[] root;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        root = new int[N+1];
        for (int i = 0; i <= N; i++)
            root[i] = i;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (cmd == 0) { // union
                union(a, b);
            } else {    // validation
                if (find(a) == find(b))
                    sb.append("yes").append("\n");
                else
                    sb.append("no").append("\n");
            }

        }


        System.out.println(sb);
    }

    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        root[rootB] = rootA;
    }

    public static int find(int n) {
        while (n != root[n]) {
            n = root[n];
        }
        return n;
    }
}