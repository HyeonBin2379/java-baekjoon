package baekjoon.baekjoon24XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise24447 {
    private static Map<Integer, List<Integer>> graph;
    private static long[] depth;
    private static long[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        depth = new long[nodeCount +1];
        Arrays.fill(depth, -1);

        visited = new long[nodeCount+1];
        graph = new LinkedHashMap<>();
        for (int i = 1; i < nodeCount +1; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        br.close();
        bfs(start);

        long sum = 0;
        for (int i = 1; i < nodeCount+1; i++) {
            sum += visited[i] * depth[i];
        }
        System.out.println(sum);
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        int count = 1;

        depth[start] = 0;
        visited[start] = count++;
        queue.offer(start);
        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            for (Integer next : graph.get(now)) {
                if (visited[next] == 0) {
                    queue.offer(next);
                    depth[next] = depth[now]+1;
                    visited[next] = count++;
                }
            }
        }
    }
}
