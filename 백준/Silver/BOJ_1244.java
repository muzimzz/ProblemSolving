package silver;

import java.util.*;
import java.io.*;

public class BOJ_1244 {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        arr[0] = -1;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int light = Integer.parseInt(st.nextToken());
            if (gender == 1) {
                for (int l = light; l <= N; l += light) {
                    arr[l] = arr[l] == 1 ? 0 : 1;
                }
            } else {
                arr[light] = arr[light] == 1 ? 0 : 1;
                int left = light-1, right = light+1;
                while (left >= 1 && right <= N && arr[left] == arr[right]) {
                    arr[left] = arr[left] == 1 ? 0 : 1;
                    arr[right] = arr[right] == 1 ? 0 : 1;
                    left--;
                    right++;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(arr[i] + " ");
            if (i % 20 == 0) {
                sb.append("\n");
            }
        }

        System.out.println(sb);

    }
}
