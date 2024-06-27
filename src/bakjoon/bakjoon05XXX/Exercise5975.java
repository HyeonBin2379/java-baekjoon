package bakjoon.bakjoon05XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class Exercise5975 {

    private static int[][] graph;
    private static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()) - 1;
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        br.close();
        bfs(m, n);
        printResult(n);
    }

    private static void bfs(int start, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        dist = IntStream.rangeClosed(0, n-1).map(i -> -1).toArray();

        queue.add(start);
        visited[start] = true;
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 0; i < n; i++) {
                if (graph[now][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    dist[i] = dist[now]+1;
                }
            }
        }
    }

    private static void printResult(int n) {
        Map<Integer, List<String>> result = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            if (dist[i] == -1) {
                continue;
            }
            if (!result.containsKey(dist[i])) {
                result.put(dist[i], new ArrayList<>());
            }
            result.get(dist[i]).add(Integer.toString(i+1));
        }
        result.values().forEach(list -> System.out.println(String.join(" ", list)));
    }
}
