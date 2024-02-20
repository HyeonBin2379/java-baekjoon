package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class FarthestNodeSolution {
    private final Map<Integer, List<Integer>> graph = new LinkedHashMap<>();
    private boolean[] visited;
    private int[] distance;

    public int solution(int n, int[][] edge) {
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] ints : edge) {
            graph.get(ints[0]).add(ints[1]);
            graph.get(ints[1]).add(ints[0]);
        }

        visited = new boolean[n+1];
        distance = new int[n+1];
        bfs(1);
        int max = Arrays.stream(distance).max().getAsInt();
        return (int) Arrays.stream(distance).filter(value -> value == max).count();
    }

    public void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (Integer next : graph.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    distance[next] = distance[now] + 1;
                    queue.add(next);
                }
            }
        }
    }
}
public class FarthestNode {
    public static void main(String[] args) {
        int n = 6;
        int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(new FarthestNodeSolution().solution(n, vertex));
    }
}
