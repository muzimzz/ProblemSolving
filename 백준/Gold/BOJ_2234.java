package gold;

import java.util.*;
import java.io.*;

public class BOJ_2234 {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] di = {0, -1, 0, 1};
    static int[] dj = {-1, 0, 1, 0};
    static int roomCount, maxRoomSize, maxDoubleRoomSize;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    roomCount++;
                    maxRoomSize = Math.max(bfs(i, j), maxRoomSize);
                }
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int d = 0; d < 4; d++) {
                    if (((1 << d) & map[i][j]) != 0) {
                        visited = new boolean[N][M];
                        map[i][j] -= (1 << d);
                        maxDoubleRoomSize = Math.max(maxDoubleRoomSize, bfs(i, j));
                        map[i][j] += (1 << d);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(roomCount).append("\n");
        sb.append(maxRoomSize).append("\n");
        sb.append(maxDoubleRoomSize);

        System.out.println(sb);

    }

    public static int bfs(int si, int sj) {

        int roomSize = 0;
        Queue<Pos> q = new ArrayDeque<>();
        visited[si][sj] = true;
        q.add(new Pos(si, sj));

        while (!q.isEmpty()) {
            Pos currPos = q.poll();
            roomSize++;
            int ci = currPos.i;
            int cj = currPos.j;

            for (int d = 0; d < 4; d++) {
                if (((1 << d) & map[ci][cj]) == 0) {
                    int ni = ci + di[d];
                    int nj = cj + dj[d];
                    if (0 <= ni && ni < N && 0 <= nj && nj < M && !visited[ni][nj]) {
                        visited[ni][nj] = true;
                        q.add(new Pos(ni, nj));
                    }
                }
            }
        }

        return roomSize;
    }

    static class Pos {
        int i, j;
        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
