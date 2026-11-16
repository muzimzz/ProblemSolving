package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3499 {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++)
        {
            int size = Integer.parseInt(br.readLine());
            String[] cards = new String[size];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < size; i++) {
                cards[i] = st.nextToken();
            }

            int mid = size / 2 + size % 2;
            int left = 0, right = mid;

            StringBuilder sb = new StringBuilder();
            while (left < mid || right < size) {
                if (left < mid) {
                    sb.append(cards[left++]).append(" ");
                }

                if (right < size) {
                    sb.append(cards[right++]).append(" ");
                }
            }

            System.out.println("#" + tc + " " + sb);

        }
    }
}
