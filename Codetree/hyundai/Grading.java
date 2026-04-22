package hyundai;

import java.util.*;
import java.io.*;

public class Grading {

    static int N;
    static int[] totalScore;
    static Member[][] arr;
    static Member[] totalArr;

    public static void main(String[] args) throws IOException {
        input();

        for (int tc = 0; tc < 3; tc++) {
            // 점수 순으로 정렬
            Arrays.sort(arr[tc], (o1, o2) -> {
                return o2.score - o1.score;
            });

            // set Member.score
            for (int i = 0; i < N; i++) {
                if (i != 0 && arr[tc][i-1].score == arr[tc][i].score)
                    arr[tc][i].rank = arr[tc][i-1].rank;
                else arr[tc][i].rank = i+1;
            }

            // 다시 id 순으로 정렬
            Arrays.sort(arr[tc], (o1, o2) -> {
                return o1.id - o2.id;
            });
        }

        for (int i = 0; i < N; i++) {
            totalArr[i] = new Member(i, totalScore[i]);
        }

        Arrays.sort(totalArr, (o1, o2) -> {
            return o2.score - o1.score;
        });

        for (int i = 0; i < N; i++) {
            if (i != 0 && totalArr[i-1].score == totalArr[i].score)
                totalArr[i].rank = totalArr[i-1].rank;
            else totalArr[i].rank = i+1;
        }

        Arrays.sort(totalArr, (o1, o2) -> {
            return o1.id - o2.id;
        });

        printAnswer();
    }

    public static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new Member[3][N];
        totalArr = new Member[N];
        totalScore = new int[N];

        for (int tc = 0; tc < 3; tc++) {

            st = new StringTokenizer(br.readLine());

            // test마다 점수 입력
            for (int i = 0; i < N; i++) {
                int score = Integer.parseInt(st.nextToken());
                arr[tc][i] = new Member(i, score);
                totalScore[i] += score;
            }
        }
    }

    public static void printAnswer() {
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < 3; tc++) {
            for (int i = 0; i < N; i++) {
                sb.append(arr[tc][i].rank).append(" ");
            }
            sb.append("\n");
        }

        for (int i = 0; i < N; i++) {
            sb.append(totalArr[i].rank).append(" ");
        }

        System.out.println(sb);
    }

    public static class Member {
        int id;
        int score;
        int rank;
        public Member(int id, int score) {
            this.id = id;
            this.score = score;
        }
    }
}