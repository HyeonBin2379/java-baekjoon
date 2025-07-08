package algorithm.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Exercise1197 {

    static class Edge implements Comparable<Edge> {
        long cost;
        int from, to;

        public Edge(long cost, int from, int to) {
            this.cost = cost;
            this.from = from;
            this.to = to;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.cost, o.cost);
        }
    }
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        parent = new int[v+1];
        Arrays.fill(parent, -1);
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            long dist = Long.parseLong(st.nextToken());
            pq.add(new Edge(dist, from, to));
        }

        int count = 0;
        int answer = 0;
        while (!pq.isEmpty() && count != v-1) {
            Edge edge = pq.poll();
            if (!isDiffGroup(edge.from, edge.to)) {
                continue;
            }
            answer += edge.cost;
            count++;
        }
        System.out.println(answer);
    }

    private static int find(int cur) {
        if (parent[cur] < 0) {
            return cur;
        }
        return parent[cur] = find(parent[cur]);
    }

    private static boolean isDiffGroup(int a, int b) {
        int g1 = find(a);
        int g2 = find(b);

        if (g1 == g2) {
            return false;
        }
        if (parent[g1] < parent[g2]) {
            parent[g1]--;
        }
        if (parent[g2] == parent[g1]) {
            parent[g1] = g2;
        } else {
            parent[g2] = g1;
        }
        return true;
    }
}
