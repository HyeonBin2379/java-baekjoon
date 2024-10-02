package baekjoon.baekjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise17396 {

    private static class Node implements Comparable<Node> {
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
    private static int[] exposed;
    private static long[] dist;
    private static boolean[] visited;
    private static final List<List<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        exposed = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        IntStream.rangeClosed(0, n-1).forEach(i -> graph.add(new ArrayList<>()));
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, time));
            graph.get(to).add(new Node(from, time));
        }

        dist = IntStream.rangeClosed(0, n-1).mapToLong(i -> Long.MAX_VALUE).toArray();
        visited = new boolean[n];
        dijkstra(n-1);
    }

    private static void dijkstra(int n) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        dist[0] = 0;
        queue.add(new Node(0, dist[0]));

        while (!queue.isEmpty()) {
            int currentNode = queue.poll().index;
            if (visited[currentNode] || exposed[currentNode] == 1) {
                continue;
            }
            visited[currentNode] = true;
            for (Node next : graph.get(currentNode)) {
                if (dist[next.index] > dist[currentNode]+next.cost) {
                    dist[next.index] = dist[currentNode]+next.cost;
                    queue.add(new Node(next.index, dist[next.index]));
                }
            }
        }
        System.out.println(dist[n] == Long.MAX_VALUE ? -1 : dist[n]);
    }
}
