package bakjoon.bakjoon05XXX;

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

public class Exercise5972 {

    private static class Node implements Comparable<Node> {
        int index, cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    private static boolean[] check;
    private static int[] dist;
    private static final int INF = Integer.MAX_VALUE;
    private static final Map<Integer, List<Node>> graph = new TreeMap<>();

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

        check = new boolean[n+1];
        dist = IntStream.rangeClosed(0, n).map(i -> INF).toArray();
        dijkstra(n);
    }

    private static void dijkstra(int n) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        dist[1] = 0;
        queue.add(new Node(1, 0));

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll().index;

            if (check[currentVertex]) {
                continue;
            }
            check[currentVertex] = true;
            for (Node next : graph.get(currentVertex)) {
                if (dist[next.index] > dist[currentVertex]+next.cost) {
                    dist[next.index] = dist[currentVertex]+next.cost;
                    queue.add(new Node(next.index, dist[next.index]));
                }
            }
        }
        System.out.println(dist[n]);
    }
}
