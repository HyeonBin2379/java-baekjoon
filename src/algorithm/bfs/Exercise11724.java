package algorithm.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise11724 {

    private static final List<List<Integer>> graph = new ArrayList<>();

    private static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        IntStream.range(0, n).forEach(idx -> graph.add(new ArrayList<>()));
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken())-1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        visited = new int[n];
        Arrays.fill(visited, -1);
        for (int i = 0; i < n; i++) {
            if (visited[i] == -1) {
                bfs(i);
            }
        }
        System.out.println(Arrays.stream(visited).distinct().count());
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        visited[start] = start;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : graph.get(now)) {
                if (visited[next] == -1) {
                    visited[next] = start;
                    queue.offer(next);
                }
            }
        }
    }
}
