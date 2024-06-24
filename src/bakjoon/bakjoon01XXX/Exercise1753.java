package bakjoon.bakjoon01XXX;

import java.io.*;
import java.util.*;

public class Exercise1753 {
    static class Node implements Comparable<Node>{
        int node, weight;
        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
    private static ArrayList<Node>[] graph;
    private static int[] distance;
    private static boolean[] visited;
    private static int nodeCount;
    private static final int INF = 100000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        graph = new ArrayList[nodeCount+1];
        for (int i = 1; i < nodeCount+1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[from].add(new Node(to, weight));
        }
        br.close();

        distance = new int[nodeCount+1];
        Arrays.fill(distance, INF);
        dijkstra(start);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i < nodeCount+1; i++) {
            bw.write((visited[i]) ? String.valueOf(distance[i]) : "INF");
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        visited = new boolean[nodeCount+1];

        distance[start] = 0;
        queue.add(new Node(start, distance[start]));
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (visited[now.node]) {
                continue;
            }
            visited[now.node] = true;
            for (Node next : graph[now.node]) {
                if (distance[next.node] > distance[now.node]+next.weight) {
                    distance[next.node] = distance[now.node]+next.weight;
                    queue.add(new Node(next.node, distance[next.node]));
                }
            }
        }
    }
}
