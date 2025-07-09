package algorithm.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Exercise1238 {

    private static final int INF = (int)1e9;
    private static List<List<Node>> normal;

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
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        normal = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            normal.add(new ArrayList<>());
        }
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());
            normal.get(from).add(new Node(to, cost));
        }

        long answer = 0;
        minDist = new long[n+1];
        for (int i = 1; i <= n; i++) {
            long first = dijkstra(i, x);
            long second = dijkstra(x, i);
            answer = Math.max(first+second, answer);
        }
        System.out.println(answer);
    }

    private static long dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(minDist, INF);
        minDist[start] = 0;
        pq.offer(new Node(start, minDist[start]));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (minDist[cur.index] != cur.cost) {
                continue;
            }

            for (Node next : normal.get(cur.index)) {
                if (minDist[next.index] > minDist[cur.index] + next.cost) {
                    minDist[next.index] = minDist[cur.index] + next.cost;
                    pq.offer(new Node(next.index, minDist[next.index]));
                }
            }
        }
        return minDist[end];
    }
}
