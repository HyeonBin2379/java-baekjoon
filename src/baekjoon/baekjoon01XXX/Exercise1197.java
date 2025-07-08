package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Exercise1197 {

    static class Node implements Comparable<Node> {
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
    private static final List<List<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, cost));
            graph.get(to).add(new Node(from, cost));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] check = new boolean[v + 1];
        check[1] = true;
        for (Node next : graph.get(1)) {
            pq.offer(next);
        }

        long answer = 0;
        for (int count = 0; count < v-1 && !pq.isEmpty();) {
            Node node = pq.poll();

            if (check[node.index]) {
                continue;
            }

            answer += node.cost;
            check[node.index] = true;
            count++;
            for (Node next : graph.get(node.index)) {
                pq.offer(next);
            }
        }
        System.out.println(answer);
    }
}
