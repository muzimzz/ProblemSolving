package Silver;

import java.util.*;
import java.io.*;

public class BOJ_1713 {
    static int N;
    static int C;

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        C = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        List<int[]> list = new ArrayList<>();

        for (int c = 0; c < C; c++) {

            int cmd = Integer.parseInt(st.nextToken());
            boolean flag = true;

            for (int[] student : list) {
                if (student[0] == cmd) {
                    student[1]++;
                    flag = false;
                    break;
                }
            }

            if (flag) {

                if (list.size() == N) {
                    int min = 1000;
                    int min_idx = 0;

                    for (int i = 0; i < N; i++) {
                        if (min > list.get(i)[1]) {
                           min = list.get(i)[1];
                           min_idx = i;
                        }
                    }

                    list.remove(min_idx);
                }

                list.add(new int[] {cmd, 1});
            }
        }

        list.sort((a, b) -> {
            return a[0] - b[0];
        });


        for (int[] student : list) {
            System.out.print(student[0] + " ");
        }
    }
}
