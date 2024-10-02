package baekjoon.baekjoon15XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise15591 {

    private static class Edge {
        int num;
        long usado;

        public Edge(int num, long usado) {
            this.num = num;
            this.usado = usado;
        }
    }
    private static final List<List<Edge>> graph = new ArrayList<>();
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        IntStream.range(0, n).forEach(i -> graph.add(new ArrayList<>()));
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken())-1;
            int q = Integer.parseInt(st.nextToken())-1;
            long r = Long.parseLong(st.nextToken());
            graph.get(p).add(new Edge(q, r));
            graph.get(q).add(new Edge(p, r));
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            long k = Long.parseLong(st.nextToken());
            int v = Integer.parseInt(st.nextToken())-1;

            visited = new boolean[n];
            bfs(k, v);
        }
    }

    private static void bfs(long k, int start) {
        Queue<Edge> queue = new ArrayDeque<>();
        visited[start] = true;
        queue.offer(new Edge(start, k));

        int count = 0;
        while (!queue.isEmpty()) {
            Edge now = queue.poll();

            for (Edge next : graph.get(now.num)) {
                if (!visited[next.num] && next.usado >= k) {
                    visited[next.num] = true;
                    count++;
                    queue.offer(next);
                }
            }
        }
        System.out.println(count);
    }
}
