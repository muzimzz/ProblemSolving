package Silver;

import java.util.*;
import java.io.*;

public class BOJ_13414 {

    static int K, L, count = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        Set<String> set = new LinkedHashSet<>(); // 학번이 0으로 시작할 경우를 생각해 String으로 구현

        for (int i = 0; i < L; i++) {
            String studentNum = br.readLine();
            // if (set.contains(studentNum)) { set.remove(studentNum); } 
            set.remove(studentNum);
            set.add(studentNum);
        }

        for (String num : set) {
            if (count >= K) break;

            System.out.println(num);
            count++;
        }
    }
}
