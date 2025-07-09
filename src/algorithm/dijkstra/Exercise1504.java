package algorithm.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Exercise1504 {

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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        while (e-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());
            graph.get(from).add(new Node(to, cost));
            graph.get(to).add(new Node(from, cost));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 중간 정점 v1, v2까지의 이동 거리 구하기
        minDist = new long[n+1];
        dijkstra(v1);
        long v1_1 = minDist[1];
        long v1_v2 = minDist[v2];
        long v1_n = minDist[n];

        dijkstra(v2);
        long v2_1 = minDist[1];
        long v2_n = minDist[n];

        // 두 정점 v1, v2를 경유할 때, 가능한 루트는 아래의 2가지
        long answer = Math.min(v1_1+v1_v2+v2_n, v2_1+v1_v2+v1_n);

        System.out.println(answer >= INF ? -1 : answer);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(minDist, INF);
        minDist[start] = 0;
        pq.offer(new Node(start, minDist[start]));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

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
