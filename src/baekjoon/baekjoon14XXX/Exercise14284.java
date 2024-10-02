package baekjoon.baekjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class Exercise14284 {

    private static class Node implements Comparable<Node> {
        int index;
        long cost;

        public Node(int index, long cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.cost, o.cost);
        }
    }

    private static final Map<Integer, List<Node>> graph = new TreeMap<>();
    private static boolean[] visited;
    private static long[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        IntStream.rangeClosed(1, n).forEach(i -> graph.put(i, new ArrayList<>()));
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, weight));
            graph.get(to).add(new Node(from, weight));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int dest = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        dist = IntStream.rangeClosed(0, n).mapToLong(i -> Long.MAX_VALUE).toArray();
        dijkstra(start, dest);
    }

    private static void dijkstra(int start, int dest) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        dist[start] = 0;
        queue.add(new Node(start, dist[start]));

        while (!queue.isEmpty()) {
            int now = queue.poll().index;

            if (visited[now]) {
                continue;
            }
            visited[now] = true;
            for (Node next : graph.get(now)) {
                if (dist[next.index] > dist[now] + next.cost) {
                    dist[next.index] = dist[now] + next.cost;
                    queue.add(new Node(next.index, dist[next.index]));
                }
            }
        }
        System.out.println(dist[dest]);
    }
}
