package Silver;

import java.util.*;
import java.io.*;

public class BOJ_13335 {

    static int n, w, L;
    static Deque<Integer> trucks;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());   // 트럭 대수
        w = Integer.parseInt(st.nextToken());   // 다리 길이
        L = Integer.parseInt(st.nextToken());   // 최대 하중

        trucks = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trucks.offer(Integer.parseInt(st.nextToken()));
        }

        int answer = 0;
        int tw = 0;     // ToTalWeight
        Deque<Integer> bridge = new ArrayDeque<>();
        for (int i = 0; i < w; i++) {
            bridge.offer(0);
        }

        while (!trucks.isEmpty()) {
            answer += 1;
            tw -= bridge.poll();
            if (tw + trucks.peek() <= L) {
                int weight = trucks.poll();
                tw += weight;
                bridge.offer(weight);
            } else {
                bridge.offer(0);
            }
        }

        System.out.println(answer + w);

    }

}
