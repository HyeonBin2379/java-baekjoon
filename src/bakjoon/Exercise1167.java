package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise1167 {
    private static class Node {
        int to, weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    private static int nodeCount;
    private static ArrayList<Node>[] graph;
    private static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nodeCount = Integer.parseInt(br.readLine());

        graph = new ArrayList[nodeCount+1];
        for (int i = 1; i <= nodeCount; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= nodeCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            while (true) {
                int to = Integer.parseInt(st.nextToken());
                if (to == -1) {
                    break;
                }
                int weight = Integer.parseInt(st.nextToken());
                graph[from].add(new Node(to, weight));
                graph[to].add(new Node(from, weight));
            }
        }

        bfs(1);
        bfs(getMaxIndex());
        System.out.println(Arrays.stream(distance).max().getAsInt());
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[nodeCount + 1];
        distance = new int[nodeCount+1];

        visited[start] = true;
        queue.offer(start);
        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            for (Node next : graph[now]) {
                if (!visited[next.to]) {
                    visited[next.to] = true;
                    distance[next.to] = distance[now] + next.weight;
                    queue.offer(next.to);
                }
            }
        }
    }

    public static int getMaxIndex() {
        int max = 1;
        for (int i = 2; i <= nodeCount; i++) {
            max = (distance[max] < distance[i]) ? i : max;
        }
        return max;
    }
}
