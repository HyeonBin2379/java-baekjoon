package bakjoon.bakjoon11XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Exercise11779 {

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
    private static int[] dist, route;

    private static final Map<Integer, List<Edge>> graph = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Edge(to, cost));
        }
        dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dijkstra(start, end);
        getRoute(end);
    }

    private static void dijkstra(int start, int end) {
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        dist[start] = 0;
        queue.add(new Edge(start, dist[start]));

        route = new int[graph.size()+1];
        while (!queue.isEmpty()) {
            Edge now = queue.poll();

            if (dist[now.vertex] < now.cost) {
                continue;
            }
            for (Edge adj : graph.get(now.vertex)) {
                int next = adj.vertex;
                int cost = adj.cost;
                if (dist[next] > dist[now.vertex] + cost) {
                    dist[next] = dist[now.vertex] + cost;
                    route[next] = now.vertex;
                    queue.add(new Edge(next, dist[next]));
                }
            }
        }
        System.out.println(dist[end]);
    }

    private static void getRoute(int end) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;

        stack.push(end);
        while (route[end] != 0) {
            count++;
            stack.push(route[end]);
            end = route[end];
        }

        System.out.println(count+1);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
