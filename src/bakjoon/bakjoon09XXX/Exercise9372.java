package bakjoon.bakjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Exercise9372 {

    private static Map<Integer, List<Integer>> graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            setGraph(n);
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            visited = new boolean[n];
            System.out.println(dfs(1, 0));
        }
    }

    private static void setGraph(int n) {
        graph = new TreeMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
    }

    private static int dfs(int start, int count) {
        visited[start-1] = true;
        for (Integer next : graph.get(start)) {
            if (!visited[next-1]) {
                count = dfs(next, count+1);
            }
        }
        return count;
    }
}
