package silver;

import java.util.*;
import java.io.*;

public class BOJ_1181 {

    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        List<String> list = new ArrayList<>(set);

        list.sort((o1, o2) -> {
            if (o1.length() == o2.length())
                return o1.compareTo(o2);

            return o1.length() - o2.length();
        });

        for (String s : list) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);

    }
}
