package algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise11724 {

    private static final List<List<Integer>> graph = new ArrayList<>();
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken())-1;
            graph.get(u).add(v);
            graph.get(u).add(v);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            count++;
            bfs(i);
        }
        System.out.println(count);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : graph.get(now)) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
    }
}
