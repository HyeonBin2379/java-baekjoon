package baekjoon.baekjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise9893 {

    private static class Edge {
        int index, cost;
        Edge(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }
    private static class Node extends Edge {
        int length;
        Node(int index, int cost, int length) {
            super(index, cost);
            this.length = length;
        }
    }
    private static long[] minCost, minLength;
    private static final List<List<Edge>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        IntStream.rangeClosed(0, m-1).forEach(i -> graph.add(new ArrayList<>()));
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Edge(to, cost));
        }

        minCost = IntStream.rangeClosed(0, n-1).mapToLong(i -> Long.MAX_VALUE).toArray();
        minLength = IntStream.rangeClosed(0, n-1).mapToLong(i -> Long.MAX_VALUE).toArray();
        System.out.println(bfs());
    }

    private static long bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 0));
        minCost[0] = 0;
        minLength[0] = 0;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (Edge next : graph.get(current.index)) {
                int newCost = current.cost + next.cost;
                int newLength = current.length + 1;

                if (newLength <= minLength[next.index]) {
                    minLength[next.index] = newLength;
                    minCost[next.index] = Math.min(newCost, minCost[next.index]);
                    queue.add(new Node(next.index, newCost, newLength));
                }
            }
        }
        return minCost[1];
    }
}
