package bakjoon.bakjoon12XXX;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Exercise12761 {

    private static int a, b;
    private static final int[] visited = new int[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        int n = sc.nextInt();
        int m = sc.nextInt();
        bfs(n, m);
    }

    private static int[] setMove(int now) {
        return new int[]{now+1, now-1, now-a, now+a, now-b, now+b, now*a, -now*a, now*b, -now*b};
    }
    private static void bfs(int start, int dest) {
        Queue<Integer> queue = new LinkedList<>();
        Arrays.fill(visited, -1);
        visited[start] = 0;
        queue.offer(start);

        while (!queue.isEmpty()) {
            Integer now = queue.poll();

            int[] move = setMove(now);
            for (int next : move) {
                if (next >= 0 && next < visited.length && visited[next] == -1) {
                    visited[next] = visited[now] + 1;
                    queue.offer(next);
                }
            }
        }
        System.out.println(visited[dest]);
    }
}
