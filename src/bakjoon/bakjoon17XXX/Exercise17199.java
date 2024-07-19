package bakjoon.bakjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise17199 {

    private static int[] visited;
    private static final Map<Integer, List<Integer>> graph = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        IntStream.rangeClosed(1, n).forEach(i -> graph.put(i, new ArrayList<>()));
        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(b).add(a);
        }

        for (int i = 1; i <= n; i++) {
            visited = IntStream.rangeClosed(0, n).map(idx -> -1).toArray();
            bfs(i);
            if (IntStream.rangeClosed(1, n).noneMatch(idx -> visited[idx] == -1)) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = 0;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : graph.get(now)) {
                if (visited[next] == -1) {
                    visited[next] = visited[now]+1;
                    queue.add(next);
                }
            }
        }
    }
}
