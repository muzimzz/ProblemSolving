package gold;

import java.util.*;
import java.io.*;

public class BOJ_2252 {

    static int N, M;
    static List<List<Integer>> adj = new ArrayList<>();
    static int[] cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= N; i++)
            adj.add(new ArrayList<>());
        cnt = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adj.get(from).add(to);
            cnt[to]++;
        }

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++)
            if (cnt[i] == 0)
                q.add(i);

        while (!q.isEmpty()) {
            int curr = q.poll();
            sb.append(curr).append(" ");
            for (int next : adj.get(curr)) {
                cnt[next]--;
                if (cnt[next] == 0)
                    q.add(next);
            }
        }

        System.out.println(sb);

    }
}
