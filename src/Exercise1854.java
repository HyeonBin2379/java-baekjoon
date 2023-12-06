import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise1854 {
    private static Map<Integer, ArrayList<Node>> graph;
    private static Map<Integer, PriorityQueue<Integer>> distance;
    private static int k;

    private static class Node implements Comparable<Node> {
        int end, cost;
        public Node(Integer end, Integer cost) {
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
        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        distance = new LinkedHashMap<>();
        graph = new LinkedHashMap<>();
        for (int i = 1; i < nodeCount +1; i++) {
            // k번째 최단거리를 바로 peek할 수 있게 항상 맨 앞에 오도록 정렬
            distance.put(i, new PriorityQueue<>(Collections.reverseOrder()));
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, cost));
        }
        br.close();

        dijkstra(1);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i < nodeCount +1; i++) {
            if (distance.get(i).size() == k) {
                bw.write(distance.get(i).peek()+"\n");
            } else {
                bw.write(-1 + "\n");
            }
        }
        bw.flush();
        bw.close();
    }

    public static void dijkstra(int start) {
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        distance.get(start).add(0);

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (Node next : graph.get(now.end)) {
                if (distance.get(next.end).size() < k) {
                    distance.get(next.end).offer(now.cost+next.cost);
                    queue.offer(new Node(next.end, now.cost+next.cost));
                } else {
                    Integer nextDist = distance.get(next.end).peek();
                    assert nextDist != null;
                    if (nextDist > now.cost + next.cost) {
                        distance.get(next.end).poll();
                        distance.get(next.end).add(now.cost+next.cost);
                        queue.offer(new Node(next.end, now.cost+next.cost));
                    }
                }
            }
        }
    }
}