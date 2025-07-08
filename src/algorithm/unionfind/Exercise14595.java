package algorithm.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise14595 {

    static class Pair implements Comparable<Pair> {
        int start, end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Pair o) {
            return this.start != o.start ? Integer.compare(this.start, o.start) : Integer.compare(this.end, o.end);
        }
    }

    private static final PriorityQueue<Pair> pq = new PriorityQueue<>();
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            pq.add(new Pair(from, to));
        }

        parent = IntStream.rangeClosed(0, n).toArray();
        int right = 1;
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int a = Math.max(pair.start, right);
            int b = pair.end;
            for (int i = a; i <= b; i++) {
                union(a, i);
            }
            right = Math.max(b, right);
        }
        System.out.println(IntStream.rangeClosed(1, n).filter(idx -> parent[idx] == idx).count());
    }

    private static int find(int cur) {
        if (parent[cur] == cur) {
            return cur;
        }
        return parent[cur] = find(parent[cur]);
    }

    private static void union(int a, int b) {
        int g1 = find(a);
        int g2 = find(b);

        if (parent[g1] != parent[g2]) {
            parent[g2] = g1;
        }
    }
}
