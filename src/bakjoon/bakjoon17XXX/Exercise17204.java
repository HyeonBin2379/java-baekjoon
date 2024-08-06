package bakjoon.bakjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise17204 {

    private static int[] graph, visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        graph = new int[n];
        for (int i = 0; i < n; i++) {
            graph[i] = Integer.parseInt(br.readLine());
        }

        visited = new int[n];
        Arrays.fill(visited, -1);
        bfs(k);
    }

    private static void bfs(int target) {
        Queue<Integer> queue = new LinkedList<>();
        visited[0] = 0;
        queue.offer(0);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            int next = graph[now];

            if (visited[next] == -1) {
                visited[next] = visited[now]+1;
                queue.offer(next);
            }
        }
        System.out.println(visited[target]);
    }
}
