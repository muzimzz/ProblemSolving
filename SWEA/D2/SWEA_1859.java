package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class SWEA_1859 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            int N = Integer.parseInt(br.readLine());
            int[] price = new int[N];
            int[] maxPrice = new int[N];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                int p = Integer.parseInt(st.nextToken());
                price[i] = p;
                maxPrice[i] = p;
            }

            int max = price[N-1];

            for (int i = N-2; i >= 0; i--) {
                if (max > maxPrice[i]) {
                    maxPrice[i] = max;
                } else {
                    max = maxPrice[i];
                }
            }

            long answer = 0;    // 자료형 주의

            for (int i = 0; i < N; i++) {
                answer += maxPrice[i] - price[i];
            }

            StringBuilder sb = new StringBuilder();

            sb.append("#").append(tc).append(" ").append(answer);
            System.out.println(sb);

        }   // for tc
    }
}
