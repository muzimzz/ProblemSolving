package hyundai;

import java.util.*;
import java.io.*;

public class Crossway { // 우측 확인: A -> D, B -> A, C -> B, D -> C

    static int N;
    static Queue<Car> q;
    static Deque<Car>[] crossWay = new ArrayDeque[4];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            crossWay[i] = new ArrayDeque<>();
        }

        q = new PriorityQueue<>((o1, o2) -> {
            return o1.time - o2.time;
        });

        N = Integer.parseInt(br.readLine());
        int t = 0;
        char w = ' ';
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            t = Integer.parseInt(st.nextToken());
            w = st.nextToken().charAt(0);
            q.add(new Car(i, t, w));
        }

        int passed = 0;
        int curTime = 0;
        int[] answer = new int[N];
        for (int i = 0; i < N; i++)
            answer[i] = -1;

        while (passed < N) {
            boolean flag = false;
            if (flag)
                break;

            while (!q.isEmpty() && q.peek().time <= curTime) {
                Car car = q.poll();
                crossWay[car.way].add(car);
            }

            if (!q.isEmpty() && isCrossWayEmpty()) {
                curTime = q.peek().time;
                continue;
            }

            boolean[] isExist = new boolean[4];
            int cntExist = 0;
            for (int i = 0; i < 4; i++) {
                if (!crossWay[i].isEmpty()) {
                    isExist[i] = true;
                    cntExist++;
                }
            }
            if (cntExist == 4) break;

            boolean[] canMove = new boolean[4];

            for(int i = 0; i < 4; i++) {
                if (isExist[i]) {
                    if (!isExist[(i+3) % 4]) {
                        canMove[i] = true;
                        flag = true;
                    }
                }
            }

            if (flag) {
                for (int i = 0; i < 4; i++) {
                    if (canMove[i]) {
                        answer[crossWay[i].poll().id] = curTime;
                        passed++;
                    }
                }
            }

            curTime++;
        }

        for (int i = 0; i < N; i++)
            sb.append(answer[i]).append("\n");

        System.out.println(sb);

    }

    public static class Car {
        int id;
        int time;
        int way;
        public Car(int id, int time, char way) {
            this.id = id;
            this.time = time;
            this.way = way - 'A';
        }
    }

    public static boolean isCrossWayEmpty() {
        for (Deque<Car> way : crossWay)
            if (!way.isEmpty())
                return false;

        return true;
    }
}