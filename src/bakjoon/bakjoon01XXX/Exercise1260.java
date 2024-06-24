package bakjoon.bakjoon01XXX;

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

public class Exercise1260 {
    private static final StringBuilder sb = new StringBuilder();
    private static final Map<Integer, List<Integer>> graph = new LinkedHashMap<>();
    private static boolean[] visited;
    private static int nodeCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        setGraph();
        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        sortGraph();
        br.close();

        visited = new boolean[nodeCount+1];
        dfs(start);
        sb.append("\n");

        visited = new boolean[nodeCount+1];
        bfs(start);
        System.out.println(sb);
    }

    public static void setGraph() {
        for (int i = 1; i <= nodeCount; i++) {
            graph.put(i, new ArrayList<>());
        }
    }
    public static void sortGraph() {
        for (int i = 1; i <= nodeCount; i++) {
            graph.get(i).sort(Integer::compareTo);
        }
    }

    public static void dfs(int start) {
        sb.append(start).append(" ");
        visited[start] = true;
        for (Integer next : graph.get(start)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.offer(start);
        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            sb.append(now).append(" ");

            for (Integer next : graph.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
