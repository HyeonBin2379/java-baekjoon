package codekata.baekjoon;

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

public class Baekjoon2606 {

    private static Map<Integer, List<Integer>> graph = new HashMap<>();
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visited = new boolean[n+1];
        int result = bfs();
        System.out.println(result);
    }

    private static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        visited[1] = true;
        queue.add(1);

        int count = 0;
        while (!queue.isEmpty()) {
            Integer now = queue.poll();

            for (Integer next : graph.get(now)) {
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
