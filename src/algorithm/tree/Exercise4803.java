package algorithm.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise4803 {

    private static List<List<Integer>> graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 1;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) {
                break;
            }

            graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            int answer = 0;
            visited = new boolean[n+1];
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    answer += bfs(i);
                }
            }


            if (answer > 1) {
                System.out.printf("Case %d: A forest of %d trees.\n", count, answer);
            } else if (answer == 1) {
                System.out.printf("Case %d: There is one tree.\n", count);
            } else {
                System.out.printf("Case %d: No trees.\n", count);
            }
            count++;
        }
    }

    private static int bfs(int root) {
        Queue<Integer> queue = new LinkedList<>();
        int node = 0;
        int edge = 0;

        queue.add(root);
        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (visited[now]) {
                continue;
            }

            visited[now] = true;
            node++;
            for (int next : graph.get(now)) {
                edge++;
                if (!visited[next]) {
                    queue.add(next);
                }
            }
        }

        return node == (edge / 2) + 1 ? 1 : 0;
    }
}
