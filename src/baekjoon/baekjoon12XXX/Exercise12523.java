package baekjoon.baekjoon12XXX;

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
import java.util.stream.IntStream;

public class Exercise12523 {

    private static Map<Integer, List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testcase; i++) {
            int n = Integer.parseInt(br.readLine());
            graph = new LinkedHashMap<>();
            IntStream.rangeClosed(1, n).forEach(master -> graph.put(master, new ArrayList<>()));

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int master = Integer.parseInt(st.nextToken());
                graph.get(master).add(j);
            }

            sb.append(String.format("Case #%d:\n", i));
            IntStream.rangeClosed(1, n).forEach(index -> sb.append(bfs(index, n)).append("\n"));
        }
        System.out.print(sb);
    }

    private static int bfs(int start, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        visited[start] = true;
        queue.add(start);

        int count = 1;
        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : graph.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    count++;
                    queue.add(next);
                }
            }
        }
        return count;
    }
}
