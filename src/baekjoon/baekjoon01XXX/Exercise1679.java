package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Exercise1679 {

    private static int n, k;
    private static int[] numbers;
    private static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        k = Integer.parseInt(br.readLine());

        visited = new int[numbers[n-1]*k+2];
        Arrays.fill(visited, -1);
        bfs();
        for (int i = 1; i < visited.length; i++) {
            if (visited[i] == -1) {
                if (i % 2 == 0) {
                    System.out.println("holsoon win at " + i);
                } else {
                    System.out.println("jjaksoon win at " + i);
                }
                break;
            }
        }
    }

    private static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        visited[0] = 0;
        queue.offer(0);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (visited[now] == k) {
                continue;
            }

            for (int i = 0; i < n; i++) {
                int next = now + numbers[i];
                if (visited[next] == -1) {
                    visited[next] = visited[now]+1;
                    queue.offer(next);
                }
            }
        }
    }
}
