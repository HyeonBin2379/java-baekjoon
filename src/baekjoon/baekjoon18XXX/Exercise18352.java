package baekjoon.baekjoon18XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise18352 {
    private static Map<Integer, List<Integer>> graph;
    private static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());
        int distance = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        dist = new int[nodeCount+1];
        graph = new LinkedHashMap<>();
        for (int i = 1; i < nodeCount+1; i++) {
            graph.put(i, new ArrayList<>());
            dist[i] = -1;
        }
        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
        }
        br.close();

        bfs(start);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < nodeCount+1; i++) {
            if (dist[i] == distance) {
                sb.append(i).append("\n");
            }
        }
        System.out.print((sb.length() > 0) ? sb : -1);
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        dist[start] = 0;
        queue.offer(start);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : graph.get(now)) {
                if (dist[next] == -1) {
                    dist[next] = dist[now] + 1;
                    queue.offer(next);
                }
            }
        }
    }
}
