package bakjoon.bakjoon24XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise24446 {
    private static Map<Integer, List<Integer>> graph;
    private static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        visited = new int[nodeCount +1];
        Arrays.fill(visited, -1);
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

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i < nodeCount +1; i++) {
            bw.write(visited[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = 0;
        queue.offer(start);
        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            for (Integer next : graph.get(now)) {
                if (visited[next] == -1) {
                    queue.offer(next);
                    visited[next] = visited[now]+1;
                }
            }
        }
    }
}
