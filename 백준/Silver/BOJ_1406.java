package silver;

import java.util.*;
import java.io.*;

public class BOJ_1406 {

    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String originStr = br.readLine();

        // sb.append(originStr);
        // int curIdx = originStr.length();
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        for (int i = 0; i < originStr.length(); i++) {
            left.add(originStr.charAt(i));
        }

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            char cmd = st.nextToken().charAt(0);
            if (cmd == 'L' && !left.isEmpty()) right.add(left.pop());
            if (cmd == 'D' && !right.isEmpty()) left.add(right.pop());
            if (cmd == 'B' && !left.isEmpty()) left.pop();
            if (cmd == 'P') {
                char addChar = st.nextToken().charAt(0);
                left.add(addChar);
            }

//            if (cmd == 'L' && curIdx > 0) curIdx--;
//            if (cmd == 'D' && curIdx < sb.length()) curIdx++;
//            if (cmd == 'B' && curIdx > 0) {
//                sb.delete(curIdx-1, curIdx);
//                curIdx--;
//            }
//            if (cmd == 'P') {
//                char addChar = st.nextToken().charAt(0);
//                sb.insert(curIdx, addChar);
//                curIdx++;
//            }
        }

        while (!right.isEmpty()) left.add(right.pop());

        for (char c : left)
            sb.append(c);

        System.out.println(sb);
    }
}
