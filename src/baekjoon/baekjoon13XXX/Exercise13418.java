package baekjoon.baekjoon13XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise13418 {

    static class Edge implements Comparable<Edge> {
        int from, to, slope;

        public Edge(int from, int to, int slope) {
            this.from = from;
            this.to = to;
            this.slope = slope;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(o.slope, this.slope);
        }
    }

    private static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Edge> list = new ArrayList<>();
        for (int i = 0; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int slope = Integer.parseInt(st.nextToken());

            list.add(new Edge(from, to, slope));
        }

        Collections.sort(list);
        int best = mst(list, n);
        Collections.reverse(list);
        int worst = mst(list, n);

        System.out.println(worst-best);
    }

    private static int find(int cur) {
        if (parents[cur] == cur) {
            return cur;
        }
        return parents[cur] = find(parents[cur]);
    }

    private static void union(int a, int b) {
        int g1 = find(a);
        int g2 = find(b);

        if (g1 != g2) {
            parents[g1] = g2;
        }
    }

    private static int mst(List<Edge> list, int n) {
        int dist = 0;

        parents = IntStream.rangeClosed(0, n).toArray();
        for (Edge edge : list) {
            if (find(edge.from) != find(edge.to)) {
                union(edge.from, edge.to);
                dist += (edge.slope == 0) ? 1 : 0;
            }
        }
        return dist*dist;
    }
}
