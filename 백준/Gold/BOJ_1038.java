package Gold;

import java.util.*;
import java.io.*;

public class BOJ_1038 {

    static int N;
    static Queue<Long> q;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        q = new ArrayDeque<>();
        long answer = -1;

        for (long i = 0; i <= 9; i++) {
            q.offer(i);
        }

        int index = 0;
        while (!q.isEmpty()) {

            long num = q.poll();

            if (index == N) {
                answer = num;
                break;
            }

            long n = num % 10;
            for (int i = 0; i < n; i++) {
                q.offer(num * 10 + i);
            }

            index++;
        }

        System.out.println(answer);

    }
}
