package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Exercise1197 {
    private static class Edge implements Comparable<Edge>{
        int weight;
        int start, end;
        public Edge(int weight, int start, int end) {
            this.weight = weight;
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }
    }
    private static final PriorityQueue<Edge> edges = new PriorityQueue<>();
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());

        parent = new int[nodeCount+1];
        for (int i = 1; i < nodeCount+1; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges.offer(new Edge(weight, from, to));
        }
        br.close();
        System.out.println(mst());
    }

    public static long mst() {
        long result = 0;
        while (!edges.isEmpty()) {
            Edge now = edges.poll();
            assert now != null;
            if (!checkSame(now.start, now.end)) {
                union(now.start, now.end);
                result += now.weight;
            }
        }
        return result;
    }
    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootA] = Math.min(rootA, rootB);
            parent[rootB] = parent[rootA];
        }
    }
    public static int find(int a) {
        if (a == parent[a]) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }
    public static boolean checkSame(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        return rootA == rootB;
    }
}
