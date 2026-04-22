package hyundai;

import java.util.*;
import java.io.*;

public class HandlingWork {

    static int H, K, R;
    static Node[] nodes;
    static int nodeSize;

    public static void main(String[] args) throws IOException {

        input();

        // 메인 로직
        int curDay = 1;
        int answer = 0;
        while (curDay <= R) {
            for (int i = 1; i < nodeSize; i++) {
                Node curNode = nodes[i];

                if (isRootNode(i)) { // Root Node
                    if (curDay % 2 == 1 && !curNode.leftTask.isEmpty())
                        answer += curNode.leftTask.poll();

                    if (curDay % 2 == 0 && !curNode.rightTask.isEmpty())
                        answer += curNode.rightTask.poll();

                    continue;   // 업무 보고는 x
                }

                int task = 0;
                if (isLeafNode(i)) {
                    if (!curNode.leafTask.isEmpty())
                        task = curNode.leafTask.poll();
                } else {
                    if (curDay % 2 == 1 && !curNode.leftTask.isEmpty())
                        task = curNode.leftTask.poll();
                    else if (curDay % 2 == 0 && !curNode.rightTask.isEmpty())
                        task = curNode.rightTask.poll();
                }

                if (task != 0) {
                    if (i % 2 == 0) nodes[i / 2].leftTask.add(task);
                    else nodes[i / 2].rightTask.add(task);
                }
            }
            curDay++;
        }

        System.out.println(answer);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        nodeSize = (int) Math.pow(2, H+1);
        nodes = new Node[nodeSize];
        for(int i = 1; i < nodeSize; i++) {
            nodes[i] = new Node();
        }

        for (int i = nodeSize / 2; i < nodeSize; i++) {
            Queue<Integer> task = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < K; k++) {
                task.add(Integer.parseInt(st.nextToken()));
            }
            nodes[i].leafTask = task;
        }

        // for (int i = 1; i < nodeSize; i++) {
        //     System.out.println(i + " " + nodes[i].leafTask);
        // }
    }

    public static class Node {
        Queue<Integer> leftTask = new ArrayDeque<>();
        Queue<Integer> rightTask = new ArrayDeque<>();
        Queue<Integer> leafTask = new ArrayDeque<>();
    }

    public static boolean isLeafNode(int idx) {
        return idx >= nodeSize / 2;
    }

    public static boolean isRootNode(int idx) {
        return idx == 1;
    }
}