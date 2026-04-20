package gold;

import java.util.*;
import java.io.*;

public class BOJ_1339 {

    static int N;
    static int[] alpha = new int[26];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < N; tc++) {
            String word = br.readLine();
            int L = word.length();
            for (int i = 0; i < L; i++) {
                char c = word.charAt(i);
                alpha[c-'A'] += Math.pow(10, L - (i + 1));
            }
        }

        Arrays.sort(alpha);

        int answer = 0;
        int count = 9;

        for (int i = 25; i >= 0; i--) {
            if (alpha[i] != 0)
                answer += alpha[i] * (count--);

            if (count == 0)
                break;
        }

        System.out.println(answer);
    }
}
