package algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise1260 {

    private static final List<List<Integer>> graph = new ArrayList<>();
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
            Collections.sort(graph.get(a));
            Collections.sort(graph.get(b));
        }

        visited = new boolean[n+1];
        dfs(v);
        System.out.println();
        visited = new boolean[n+1];
        bfs(v, n);
    }

    private static void bfs(int start, int n) {
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");

            for (int next : graph.get(now)) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
    }

    private static void dfs(int start) {
        visited[start] = true;
        System.out.print(start + " ");
        for (int next : graph.get(start)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
