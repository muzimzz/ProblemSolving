package silver;

import java.util.*;
import java.io.*;

public class BOJ_11650 {

    static int N;
    static int[][] pos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        pos = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pos[i][0] = Integer.parseInt(st.nextToken());
            pos[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(pos, (p1, p2) -> {
           if (p1[0] == p2[0])
               return p1[1] - p2[1];

           return p1[0] - p2[0];
        });

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                sb.append(pos[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
