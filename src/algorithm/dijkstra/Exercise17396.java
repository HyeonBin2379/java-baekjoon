package algorithm.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise17396 {

    static class Node implements Comparable<Node> {
        int index;
        long weight;

        public Node(int index, long weight) {
            this.index = index;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.weight, o.weight);
        }
    }

    private static final long INF = Long.MAX_VALUE;
    private static final List<List<Node>> graph = new ArrayList<>();

    private static int[] enemy;
    private static long[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        enemy = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        IntStream.range(0, n).forEach(idx -> graph.add(new ArrayList<>()));
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Node(to, weight));
            graph.get(to).add(new Node(from, weight));
        }

        dist = new long[n];
        Arrays.fill(dist, INF);
        dijkstra(n);
        System.out.println(dist[n-1] == INF ? -1 : dist[n-1]);
    }

    private static void dijkstra(int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[0] = 0;
        pq.offer(new Node(0, dist[0]));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dist[cur.index] < cur.weight
                    || (enemy[cur.index] == 1 && cur.index != n-1)) {
                continue;
            }

            for (Node next : graph.get(cur.index)) {
                if (dist[next.index] > dist[cur.index]+next.weight) {
                    dist[next.index] = dist[cur.index]+next.weight;
                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }
        }
    }
}
