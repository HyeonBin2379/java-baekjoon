package bakjoon.bakjoon05XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class Exercise5938 {

    private static final Map<Integer, List<Integer>> graph = new TreeMap<>();
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        setGraph(n);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        visited = new boolean[n+1];
        dfs(1);

        int count = (int) IntStream.rangeClosed(2, n).filter(index -> !visited[index]).count();
        if (count == 0) {
            System.out.println(0);
            return;
        }
        for (int i = 2; i <= n; i++) {
            if (!visited[i]) {
                System.out.println(i);
            }
        }
    }

    private static void setGraph(int n) {
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
    }

    private static void dfs(int start) {
        visited[start] = true;
        for (Integer next : graph.get(start)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
