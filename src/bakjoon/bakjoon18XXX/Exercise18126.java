package bakjoon.bakjoon18XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class Exercise18126 {

    private static class Node {
        int num;
        long distance;

        public Node(int num, long distance) {
            this.num = num;
            this.distance = distance;
        }
    }
    private static long[] visited;
    private static final Map<Integer, List<Node>> graph = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        IntStream.rangeClosed(1, n).forEach(i -> graph.put(i, new ArrayList<>()));

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        visited = IntStream.rangeClosed(0, n).mapToLong(i -> -1L).toArray();
        bfs(n);
    }

    private static void bfs(int n) {
        Queue<Node> queue = new LinkedList<>();
        visited[1] = 0;
        queue.add(new Node(1, visited[1]));

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (Node next : graph.get(now.num)) {
                if (visited[next.num] == -1) {
                    visited[next.num] = visited[now.num] + next.distance;
                    queue.add(new Node(next.num, visited[next.num]));
                }
            }
        }

        System.out.println(IntStream.rangeClosed(1, n)
                .mapToLong(idx -> visited[idx])
                .filter(dist -> dist != -1)
                .max()
                .getAsLong());
    }
}
