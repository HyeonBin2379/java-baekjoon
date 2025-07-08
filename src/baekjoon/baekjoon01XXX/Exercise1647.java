package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise1647 {

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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());

            pq.offer(new Edge(cost, from, to));
        }

        int count = 0;
        long answer = 0, maxLen = 0;

        parent = IntStream.rangeClosed(0, n).map(idx -> -1).toArray();
        while (!pq.isEmpty() && count != n-1) {
            Edge edge = pq.poll();

            if (!isDiffGroup(edge.from, edge.to)) {
                continue;
            }
            answer += edge.cost;
            maxLen = Math.max(edge.cost, maxLen);
            count++;
        }

        // 최소신장트리 내 길이가 최대인 간선 제거 = 2개의 마을로 분리
        System.out.println(answer-maxLen);
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
