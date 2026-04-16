package Lv1;

import java.util.*;

public class P_64061 {
    public int solution(int[][] board, int[] moves) {

        int answer = 0;

        Deque<Integer> box = new ArrayDeque<>();

        for (int move : moves) {
            int item = go(board, move-1);
            if (item == -1) {
                continue;
            } else if (!box.isEmpty() && item == box.peek()) {
                box.pop();
                answer += 2;
            } else {
                box.push(item);

            }
        }

        return answer;
    }

    public int go(int[][] board, int pos) {

        for(int i = 0; i < board.length; i++) {
            if (board[i][pos] == 0) {
                continue;
            } else {
                int item = board[i][pos];
                board[i][pos] = 0;
                return item;
            }
        }

        return -1;
    }
}
