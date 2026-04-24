package gold;

import java.util.*;
import java.io.*;

public class BOJ_24391 {

    static int N, M;
    static int[] root;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        root = new int[N + 1];
        for (int i = 1; i <= N; i++)
            root[i] = i;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        int answer = 0;
        st = new StringTokenizer(br.readLine());
        int curr = Integer.parseInt(st.nextToken());

        while (st.hasMoreTokens()) {
            int next = Integer.parseInt(st.nextToken());
            if (find(next) != find(curr))
                answer++;

            curr = next;
        }
        System.out.println(answer);
    }

    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        root[rootA] = rootB;
    }

    // while
    public static int find(int n) {
        while (n != root[n]) {
            root[n] = root[root[n]];    // 다음 탐색 시간 절약, 없으면 TLE
            n = root[n];
        }

        return n;
    }

    // recursion
//    public static int find(int n) {
//        if (n == root[n]) return n;
//        else return root[n] = find(root[n]);
//    }
}
