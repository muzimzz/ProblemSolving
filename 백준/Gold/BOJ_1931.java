package gold;

import java.util.*;
import java.io.*;

public class BOJ_1931 {

    static int N, startTime, endTime;
    static int[][] time;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        time = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int answer = 0, curTime = 0;
        for (int i = 0; i < N; i++) {
            startTime = time[i][0];
            endTime = time[i][1];
            if (curTime <= startTime) {
                answer++;
                curTime = endTime;
            }
        }

        System.out.println(answer);

    }
}