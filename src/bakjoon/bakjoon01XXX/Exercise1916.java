package bakjoon.bakjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Exercise1916 {

    private static class Edge implements Comparable<Edge> {
        int vertex, cost;

        public Edge(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost-o.cost;
        }
    }
    private static Integer[] dist;
    private static boolean[] visited;

    private static final List<List<Edge>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            int cost = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Edge(to, cost));
        }
        dist = new Integer[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        StringTokenizer st = new StringTokenizer(br.readLine());
        visited = new boolean[n];
        int start = Integer.parseInt(st.nextToken())-1;
        int end = Integer.parseInt(st.nextToken())-1;
        dijkstra(start);
        System.out.println(dist[end]);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        dist[start] = 0;
        queue.add(new Edge(start, dist[start]));

        while (!queue.isEmpty()) {
            Edge now = queue.poll();

            if (visited[now.vertex]) {
                continue;
            }
            visited[now.vertex] = true;
            for (Edge adj : graph.get(now.vertex)) {
                int next = adj.vertex;
                int cost = adj.cost;
                if (dist[next] > dist[now.vertex] + cost) {
                    dist[next] = dist[now.vertex] + cost;
                    queue.add(new Edge(next, dist[next]));
                }
            }
        }
    }
}
