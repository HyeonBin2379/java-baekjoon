package bakjoon.bakjoon11XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Exercise11558 {

    private static int[] graph;
    private static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        while (testcase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            graph = new int[n+1];
            for (int i = 1; i <= n; i++) {
                graph[i] = Integer.parseInt(br.readLine());
            }

            visited = new int[n+1];
            Arrays.fill(visited, -1);
            bfs(n);
        }
    }

    private static void bfs(int target) {
        Queue<Integer> queue = new LinkedList<>();
        visited[1] = 0;
        queue.offer(1);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            int next = graph[now];

            if (visited[next] == -1) {
                visited[next] = visited[now]+1;
                queue.offer(next);
            }
        }
        System.out.println(visited[target] != -1 ? visited[target] : 0);
    }
}
