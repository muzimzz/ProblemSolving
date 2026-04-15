package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1978 {

    static int N, answer = 0;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        for (int num : list) {
            answer += isPrime(num);
        }

        System.out.println(answer);
    }

    public static int isPrime(int num) {
        if (num == 1) return 0;
        // for (int i = 2; i < num; i++) {
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) return 0;
        }
        return 1;
    }
}
