package baekjoon.baekjoon02XXX;

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

public class Exercise2644 {

    private static Map<Integer, List<Integer>> graph;
    private static boolean[] visited;
    private static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeCount = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        graph = new LinkedHashMap<>();
        for (int i = 1; i <= nodeCount; i++) {
            graph.put(i, new ArrayList<>());
        }

        int edgeCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            graph.get(parent).add(child);
            graph.get(child).add(parent);
        }

        int[] relative = new int[nodeCount+1];
        visited = new boolean[nodeCount +1];
        //dfs(start, end, 0);
        bfs(start, end, relative);
        System.out.println(result);
    }

    public static void dfs(int start, int end, int depth) {
        if (start == end) {
            result = depth;
            return;
        }

        visited[start] = true;
        for (Integer next : graph.get(start)) {
            if (!visited[next]) {
                dfs(next, end, depth+1);
            }
        }
    }

    public static void bfs(int start, int end, int[] relative) {
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.offer(start);
        while (!queue.isEmpty()) {
            Integer now = queue.poll();

            if (now == end) {
                result = relative[now];
                break;
            }
            for (Integer next : graph.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    relative[next] = relative[now]+1;
                    queue.offer(next);
                }
            }
        }
    }
}
