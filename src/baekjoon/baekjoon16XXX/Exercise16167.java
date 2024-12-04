package baekjoon.baekjoon16XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise16167 {

    private static class Node implements Comparable<Node> {
        int nodeNum, cost;

        public Node(int nodeNum, int cost) {
            this.nodeNum = nodeNum;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    private static final List<List<Node>> graph = new ArrayList<>();
    private static final int INF = (int)1e9;
    private static int[] distance, prevNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        IntStream.rangeClosed(0, n).forEach(idx -> graph.add(new ArrayList<>()));

        while (r-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int baseRate = Integer.parseInt(st.nextToken());
            int additional = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            graph.get(to).add(new Node(from, getCost(baseRate, additional, time)));
        }

        distance = new int[n+1];
        prevNode = new int[n+1];
        Arrays.fill(distance, INF);
        dijkstra(n);

        if (distance[1] == INF) {
            System.out.println("It is not a great way.");
        } else {
            System.out.println(distance[1] + " " + getPathLength(n));
        }
    }

    public static int getCost(int base, int additional, int time) {
        return base + Math.max(time-10, 0) * additional;
    }

    public static void dijkstra(int n) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        distance[n] = 0;
        queue.offer(new Node(n, distance[n]));
        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (distance[now.nodeNum] < now.cost) {
                continue;
            }
            for (Node next : graph.get(now.nodeNum)) {
                if (distance[next.nodeNum] > distance[now.nodeNum]+next.cost) {
                    distance[next.nodeNum] = distance[now.nodeNum]+next.cost;
                    prevNode[next.nodeNum] = now.nodeNum;
                    queue.add(new Node(next.nodeNum, distance[next.nodeNum]));
                }
            }
        }
    }

    public static int getPathLength(int n) {
        int count = 1;
        int now = 1;
        while (now != n) {
            now = prevNode[now];
            count++;
        }
        return count;
    }
}
