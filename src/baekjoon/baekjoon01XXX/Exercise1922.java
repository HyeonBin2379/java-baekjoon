package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise1922 {

    static class Edge implements Comparable<Edge> {
        int from, to;
        long cost;

        public Edge(int from, int to, long cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.cost, o.cost);
        }
    }
    private static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());
            pq.add(new Edge(from, to, cost));
        }

        int edgeCnt = 0;
        long answer = 0;
        parents = IntStream.rangeClosed(0, n).toArray();
        while (!pq.isEmpty() && edgeCnt != n-1) {
            Edge edge = pq.poll();

            if (!isDiffGroup(edge.from, edge.to)) {
                continue;
            }
            answer += edge.cost;
            edgeCnt++;
        }
        System.out.println(answer);
    }

    private static int find(int curr) {
        if (parents[curr] == curr) {
            return curr;
        }
        return parents[curr] = find(parents[curr]);
    }

    private static boolean isDiffGroup(int a, int b) {
        int g1 = find(a);
        int g2 = find(b);

        if (g1 == g2) {
            return false;
        }
        if (parents[g1] < parents[g2]) {
            parents[g2] = g1;
        } else {
            parents[g1] = g2;
        }
        return true;
    }
}
