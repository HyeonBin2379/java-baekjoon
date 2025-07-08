package algorithm.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Exercise1368 {

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
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        // 가상의 정점 1개 추가 -> 정점의 개수는 n+1, 추가해야 할 간선은 n개
        for (int i = 1; i <= n; i++) {
            int wellCost = Integer.parseInt(br.readLine());
            pq.offer(new Edge(wellCost, i, 0));
        }
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                long cost = Long.parseLong(st.nextToken());
                if (i < j) {
                    pq.offer(new Edge(cost, i, j));
                }
            }
        }

        long answer = 0;
        int count = 0;
        parent = new int[n+1];
        Arrays.fill(parent, -1);
        while (!pq.isEmpty() && count != n) {
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
        if (parent[g1] == parent[g2]) {
            parent[g1] = g2;
        } else {
            parent[g2] = g1;
        }
        return true;
    }
}
