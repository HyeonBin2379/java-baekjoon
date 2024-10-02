package baekjoon.baekjoon03XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Exercise3182 {

    private static int answer, max;
    private static int[] graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        graph = new int[n];
        for (int i = 0; i < n; i++) {
            graph[i] = Integer.parseInt(br.readLine())-1;
        }

        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            bfs(i);
        }
        System.out.println(answer);
    }

    private static void bfs(int num) {
        Queue<Integer> queue = new LinkedList<>();
        visited[num] = true;
        queue.offer(num);

        int count = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            int next = graph[now];

            if (!visited[next]) {
                visited[next] = true;
                count++;
                queue.offer(next);
            }
        }

        if (max < count) {
            max = count;
            answer = num+1;
        }
    }
}
