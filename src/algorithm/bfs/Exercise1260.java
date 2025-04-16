package algorithm.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise1260 {

    private static final List<List<Integer>> graph = new ArrayList<>();

    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        IntStream.rangeClosed(0, n).forEach(idx -> graph.add(new ArrayList<>()));
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        IntStream.rangeClosed(0, n).forEach(idx -> graph.get(idx).sort(null));

        visited = new boolean[n+1];
        dfs(v);
        System.out.println();
        visited = new boolean[n+1];
        bfs(v);
    }

    private static void dfs(int start) {
        visited[start] = true;
        System.out.print(start + " ");
        for (int next : graph.get(start)) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next);
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            System.out.print(now + " ");

            for (int next : graph.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
