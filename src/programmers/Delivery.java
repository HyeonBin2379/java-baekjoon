package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class DeliverySolution {
    private final Map<Integer, List<Edge>> graph = new LinkedHashMap<>();
    private int[] distance;
    private boolean[] visited;

    static class Edge implements Comparable<Edge> {
        int weight, end;
        Edge(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    public void setGraph(int N, int[][] road) {
        distance = new int[N+1];
        Arrays.fill(distance, 1000000001);
        visited = new boolean[N+1];
        for (int i = 1; i < N+1; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] ints : road) {
            graph.get(ints[0]).add(new Edge(ints[1], ints[2]));
            graph.get(ints[1]).add(new Edge(ints[0], ints[2]));
        }
    }
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        setGraph(N, road);
        distance[1] = 0;
        pq.offer(new Edge(1, distance[1]));
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (visited[now.end]) {
                continue;
            }

            visited[now.end] = true;
            for (Edge next : graph.get(now.end)) {
                if (distance[next.end] > distance[now.end]+next.weight) {
                    distance[next.end] = distance[now.end]+next.weight;
                    pq.offer(new Edge(next.end, distance[next.end]));
                }
            }
        }

        for (int i = 1; i < N+1; i++) {
            if (distance[i] < K) {
                answer++;
            }
        }
        return answer;
    }
}
public class Delivery {
    public static void main(String[] args) {
        DeliverySolution dijkstra = new DeliverySolution();
        int n = 5;
        int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        int k = 3;
        System.out.println(dijkstra.solution(n, road, k));
    }
}
