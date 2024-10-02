package baekjoon.baekjoon01XXX;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Exercise1697 {
    private static int[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        sc.close();

        bfs(start, end);
        System.out.println(visited[end]);
    }

    public static void bfs(int start, int end) {
        int[] nextNumber = new int[] {-1, 1, 0};
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited = new int[Math.max(start, end)*2+1];
        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (now == end) {
                break;
            }

            for (int num : nextNumber) {
                int next = (num != 0) ? now+num : now*2;

                if (0 <= next && next < visited.length && visited[next] == 0) {
                    queue.offer(next);
                    visited[next] = visited[now]+1;
                }
            }
        }
    }
}
