package Lv2;

import java.util.*;
import java.io.*;

public class P_12980 {

    public static int solution(int n) {
        int ans = 0;

        while (n > 0) {
            if (n % 2 == 0)
                n /= 2;
            else {
                n--;
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(solution(N));
    }


}
