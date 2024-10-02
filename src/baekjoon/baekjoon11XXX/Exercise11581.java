package baekjoon.baekjoon11XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Exercise11581 {

    private static final Map<Integer, List<Integer>> graph = new TreeMap<>();
    private static int[] visited;
    private static String answer = "NO CYCLE";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
            if (i < n) {
                int m = Integer.parseInt(br.readLine());
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    graph.get(i).add(Integer.parseInt(st.nextToken()));
                }
            }
        }

        visited = new int[n+1];
        dfs(1);
        System.out.println(answer);
    }

    private static void dfs(int now) {
        if (visited[now] == 1) {
            answer = "CYCLE";
            return;
        }

        visited[now] = 1;
        for (int next : graph.get(now)) {
            if (visited[next] != -1) {
                dfs(next);
            }
        }
        visited[now] = -1;
    }
}
