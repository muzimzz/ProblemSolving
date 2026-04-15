package gold;

import java.io.*;

public class BOJ_15927 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int answer = 0;
        int left = 0;
        int right = str.length() - 1;

        boolean isPal = true;
        boolean allSame = true;

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) != str.charAt(i+1)) {
                allSame = false;
                break;
            }
        }

        if (allSame) {
            answer = -1;
        }

        if (!allSame) {
            while (left <= right) {
                if (str.charAt(left) != str.charAt(right)) {
                    isPal = false;
                    break;
                }
                left += 1;
                right -= 1;
            }

            if (!isPal) {
                answer = str.length();
            } else {
                answer = str.length() - 1;
            }
        }

        System.out.println(answer);
    }
}
