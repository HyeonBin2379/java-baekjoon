package algorithm.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Exercise1697 {

    private static final int[] moves = {-1, 1, 2};

    private static int[] dist;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        dist = new int[200001];
        Arrays.fill(dist, -1);
        bfs(n, k);
    }

    private static void bfs(int start, int end) {
        Queue<Integer> queue = new ArrayDeque<>();
        dist[start] = 0;
        queue.add(start);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == end) {
                System.out.println(dist[now]);
                return;
            }

            for (int move : moves) {
                int next = Math.abs(move) == 1 ? now+move : now*move;

                if (next < 0 || next >= dist.length) {
                    continue;
                }

                if (dist[next] == -1) {
                    dist[next] = dist[now]+1;
                    queue.offer(next);
                }
            }
        }
    }
}
