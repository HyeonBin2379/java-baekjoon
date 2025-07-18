package algorithm.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Exercise5972 {

    private static final int INF = (int)1e9;
    private static final List<List<Node>> graph = new ArrayList<>();

    static class Node implements Comparable<Node>{
        int index, weight;

        public Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    private static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Node(to, weight));
            graph.get(to).add(new Node(from, weight));
        }

        dist = new int[n+1];
        Arrays.fill(dist, INF);
        dijkstra();
        System.out.println(dist[n]);
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[1] = 0;
        pq.add(new Node(1, dist[1]));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dist[cur.index] < cur.weight) {
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
