package Gold;

import java.util.*;
import java.io.*;

public class BOJ_14891 {

    static int[][] wheels = new int[4][8];
    static int[] rot;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 4; i++) {
            String w = br.readLine();
            for (int c = 0; c < w.length(); c++) {
                wheels[i][c] = w.charAt(c) - '0';
            }
        }

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            rot = new int[4];

            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            rotOn(n - 1, d);

            for (int r = 0; r < 4; r++) {
                int[] newWheel = new int[8];
                if (rot[r] != 0) {

                    for (int w = 0; w < 8; w++) {
                        newWheel[(w+rot[r]+8) % 8] = wheels[r][w];
                    }

                    for (int w = 0; w < 8; w++) {
                        wheels[r][w] = newWheel[w];
                    }
                }
            }
        }

        int answer = 0;

        for (int i = 0; i < 4; i++) {
            if (wheels[i][0] == 1) {
                answer += (int) Math.pow(2, i);
            }
        }

        System.out.println(answer);
    }

    public static void rotOn(int n, int d) {
        rot[n] = d;

        if (n > 0 && rot[n-1] == 0 && wheels[n][6] != wheels[n-1][2]) {
            rotOn(n-1, -d);
        }

        if (n < 3 && rot[n+1] == 0 && wheels[n][2] != wheels[n+1][6]) {
            rotOn(n+1, -d);
        }
    }
}
