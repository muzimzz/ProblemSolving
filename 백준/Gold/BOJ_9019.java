package gold;

import java.util.*;
import java.io.*;

public class BOJ_9019 {

    static int T;
    static int A, B;
    static String[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            visited = new String[10000];
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            bfs(A);
            sb.append(visited[B]).append("\n");
        }

        System.out.println(sb);
    }

    public static void bfs(int A) {
        Queue<Integer> q = new ArrayDeque<>();
        visited[A] = "";
        q.add(A);
        while (!q.isEmpty() && visited[B] == null) {
            int c = q.poll();

            int D = (c * 2) % 10000;
            int S = (c + 9999) % 10000;
            int L = (c % 1000 * 10) + c / 1000;
            int R = (c % 10 * 1000) + c / 10;

            if (visited[D] == null) {
                q.add(D);
                visited[D] = visited[c]+"D";
            }
            if (visited[S] == null) {
                q.add(S);
                visited[S] = visited[c]+"S";
            }

            if (visited[L] == null) {
                q.add(L);
                visited[L] = visited[c]+"L";
            }

            if (visited[R] == null) {
                q.add(R);
                visited[R] = visited[c]+"R";
            }
        }
    }
}
