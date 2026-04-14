package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17609 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            int answer = solve(0, str.length() - 1, 0, str);
            System.out.println(answer);
        }
    }

    static int solve(int left, int right, int diffCount, String str) {

        while (left < right) {
            if (diffCount >= 2) {
                return 2;
            }

            if (str.charAt(left) != str.charAt(right)) {
                int leftSolve = solve(left+1, right, diffCount+1, str);
                int rightSolve = solve(left, right-1, diffCount+1, str);
                return Math.min(leftSolve, rightSolve);
            }
            left += 1;
            right -= 1;
        }

        return diffCount;
    }

}
