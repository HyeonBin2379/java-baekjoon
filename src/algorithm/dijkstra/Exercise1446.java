package algorithm.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise1446 {

    private static final List<List<Node>> graph = new ArrayList<>();

    static class Node implements Comparable<Node> {

        int offset, dist;

        public Node(int offset, int dist) {
            this.offset = offset;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.dist, o.dist);
        }
    }

    private static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= d; i++) {
            graph.add(new ArrayList<>());
            if (i < d) {
                graph.get(i).add(new Node(i + 1, 1));
            }
        }
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            if (to > d) {
                continue;
            }
            graph.get(from).add(new Node(to, dist));
        }

        dist = IntStream.rangeClosed(0, d).toArray();
        dijkstra();
        System.out.println(dist[d]);
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, dist[0]));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            for (Node next : graph.get(cur.offset)) {
                if (dist[next.offset] >= dist[cur.offset]+next.dist) {
                    dist[next.offset] = dist[cur.offset]+next.dist;
                    pq.offer(new Node(next.offset, dist[next.offset]));
                }
            }
        }
    }
}
