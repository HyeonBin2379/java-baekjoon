package algorithm.dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Exercise1753 {

    private static final int INF = (int)1e9;
    private static final List<List<Node>> graph = new ArrayList<>();

    static class Node implements Comparable<Node> {
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

    private static long[] minDist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        minDist = new long[v+1];
        Arrays.fill(minDist, INF);
        while (e-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());

            graph.get(from).add(new Node(to, cost));
        }
        br.close();

        dijkstra(k);

        for (int i = 1; i <= v; i++) {
            if (minDist[i] == INF) {
                bw.write("INF\n");
            } else {
                bw.write(minDist[i] + "\n");
            }
        }
        bw.close();
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        minDist[start] = 0;
        pq.offer(new Node(start, minDist[start]));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            // 이미 거리를 구한 정점에 대해 중복 방문을 방지
            if (minDist[cur.index] != cur.cost) {
                continue;
            }
            for (Node next : graph.get(cur.index)) {
                if (minDist[next.index] > minDist[cur.index]+next.cost) {
                    minDist[next.index] = minDist[cur.index]+next.cost;
                    pq.offer(new Node(next.index, minDist[next.index]));
                }
            }
        }
    }
}
