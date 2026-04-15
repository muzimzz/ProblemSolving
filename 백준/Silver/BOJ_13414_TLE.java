package silver;

import java.util.*;
import java.io.*;

public class BOJ_13414_TLE {

    static int K, L;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        // 1 ≤ L ≤ 500,000)
        for (int i = 0; i < L; i++) {
            int studentNum = Integer.parseInt(br.readLine());
            // remove(index)는 IndexOutOfBoundsException 발생
            // remove(value)는 값을 못 찾으면 false return
            // 따라서 if (list.contains()) { REMOVE } 할 필요 없음
            // list.remove: 처음부터 끝까지 순회하며 삭제 -> O(N)
            // 총 O(N^2): TLE
            list.remove((Integer) studentNum);
            list.add(studentNum);
        }

        for (int i = 0; i < K; i++) {
            System.out.println(list.get(i));
        }
    }
}
