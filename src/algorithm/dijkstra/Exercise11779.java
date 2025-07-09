package algorithm.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Exercise11779 {

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
    private static int[] prev;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());
            graph.get(from).add(new Node(to, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        minDist = new long[n+1];
        Arrays.fill(minDist, INF);
        prev = new int[n+1];
        dijkstra(start, end);
        System.out.println(makePath(start, end));
    }

    private static void dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
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
                    prev[next.index] = cur.index;
                }
            }
        }
        System.out.println(minDist[end]);
    }

    private static String makePath(int start, int end) {
        List<String> path = new ArrayList<>();
        int cur = end;
        while (cur != start) {
            path.add(Integer.toString(cur));
            cur = prev[cur];
        }
        path.add(Integer.toString(cur));
        Collections.reverse(path);
        return String.format("%d\n%s", path.size(), String.join(" ", path));
    }
}
