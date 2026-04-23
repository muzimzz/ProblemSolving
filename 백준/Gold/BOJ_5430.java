package gold;

import java.util.*;
import java.io.*;

public class BOJ_5430 {

    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());


        for (int tc = 0; tc < T; tc++) {
            String cmd = br.readLine();
            int L = Integer.parseInt(br.readLine());
            Deque<Integer> q = new ArrayDeque<>();
            String str = br.readLine();
            // str = str.substring(1, str.length() - 1);
            st = new StringTokenizer(str, ",[]");
            for (int i = 0; i < L; i++) {
                q.add(Integer.parseInt(st.nextToken()));
            }

            boolean flag = true;
            int Rtotal = 0;
            for (int i = 0; i < cmd.length(); i++) {
                if (cmd.charAt(i) == 'R') {
                    Rtotal++;
                } else if (cmd.charAt(i) == 'D') {
                    if (q.isEmpty()) {
                        flag = false;
                        break;
                    } else {
                        if (Rtotal % 2 == 0)
                            q.poll();
                        else
                            q.pollLast();
                    }
                }
            }

            if (flag) {
                sb.append("[");
                while (!q.isEmpty()) {
                    if (Rtotal % 2 == 0) sb.append(q.poll());
                    else sb.append(q.pollLast());

                    if (!q.isEmpty()) sb.append(",");
                }
                sb.append("]\n");
            } else {
                sb.append("error\n");
            }
        }
        System.out.println(sb);
    }
}
