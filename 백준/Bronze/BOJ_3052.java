package bronze;

import java.util.*;
import java.io.*;

public class BOJ_3052 {

    static int SIZE = 10;
    static int NUM = 42;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < SIZE; i++) {
            int n = Integer.parseInt(br.readLine());
            set.add(n % NUM);
        }

        System.out.println(set.size());
    }
}
