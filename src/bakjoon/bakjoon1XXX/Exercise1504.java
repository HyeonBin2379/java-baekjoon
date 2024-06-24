package bakjoon.bakjoon1XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Exercise1504 {
    private static final int INF = 200000001;
    private static Map<Integer, List<Node>> graph;
    private static int[] distance;
    private static boolean[] visited;

    private static class Node implements Comparable<Node> {
        int to, weight;
        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());

        distance = new int[nodeCount +1];
        visited = new boolean[nodeCount +1];
        graph = new LinkedHashMap<>();
        for (int i = 1; i < nodeCount +1; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, weight));
            graph.get(to).add(new Node(from, weight));
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        br.close();

        int answer1 = 0;
        answer1 += dijkstra(1, v1);
        answer1 += dijkstra(v1, v2);
        answer1 += dijkstra(v2, nodeCount);

        int answer2 = 0;
        answer2 += dijkstra(1, v2);
        answer2 += dijkstra(v2, v1);
        answer2 += dijkstra(v1, nodeCount);

        if (answer1 >= INF && answer2 >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(answer1, answer2));
        }
    }

    public static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(distance, INF);
        Arrays.fill(visited, false);
        distance[start] = 0;
        pq.add(new Node(start, distance[start]));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (visited[now.to]) {
                continue;
            }
            visited[now.to] = true;
            for (Node next : graph.get(now.to)) {
                if (!visited[next.to] && distance[now.to]+next.weight < distance[next.to]) {
                    distance[next.to] = distance[now.to]+next.weight;
                    pq.add(new Node(next.to, distance[next.to]));
                }
            }
        }
        return distance[end];
    }
}
