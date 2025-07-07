package algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise5567 {

    private static final List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        bfs(n);
    }

    private static void bfs(int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        int[] visited = new int[n+1];
        Arrays.fill(visited, -1);
        visited[1] = 0;
        queue.offer(1);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : graph.get(now)) {
                if (visited[next] == -1) {
                    queue.offer(next);
                    visited[next] = visited[now]+1;
                }
            }
        }
        System.out.println(Arrays.stream(visited)
                .filter(cnt -> cnt == 1 || cnt == 2)
                .count());
    }
}
