package Lv1;

import java.util.*;
import java.io.*;

class P_68644 {
    public int[] solution(int[] numbers) {

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if (i == j) continue;
                set.add(numbers[i] + numbers[j]);
            }
        }

        List<Integer> list = new ArrayList<>(set);
        list.sort(null);

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
