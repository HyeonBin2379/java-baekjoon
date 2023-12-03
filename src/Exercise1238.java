import java.io.*;
import java.util.*;

public class Exercise1238 {
    private static final int INF = 1000000001;
    private static int nodeCount;

    public static class Node implements Comparable<Node> {
        int end, cost;
        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());
        int dest = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] graph = new ArrayList[nodeCount + 1];
        ArrayList<Node>[] reverseGraph = new ArrayList[nodeCount + 1];
        for (int i = 1; i < nodeCount+1; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[from].add(new Node(to, cost));
            reverseGraph[to].add(new Node(from, cost));
        }
        br.close();

        int[] dist1 = dijkstra(dest, graph);
        int[] dist2 = dijkstra(dest, reverseGraph);
        int max = 0;
        for (int i = 1; i < nodeCount+1; i++) {
            max = Math.max(max, dist1[i]+dist2[i]);
        }
        System.out.println(max);
    }

    public static int[] dijkstra(int start, ArrayList<Node>[] graph) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[nodeCount + 1];
        int[] distance = new int[nodeCount + 1];
        Arrays.fill(distance, INF);

        distance[start] = 0;
        queue.add(new Node(start, distance[start]));
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (visited[now.end]) {
                continue;
            }
            visited[now.end] = true;
            for (Node next : graph[now.end]) {
                int newCost = distance[now.end]+next.cost;
                if (!visited[next.end] && distance[next.end] > newCost) {
                    distance[next.end] = newCost;
                    queue.add(new Node(next.end, distance[next.end]));
                }
            }
        }
        return distance;
    }
}
