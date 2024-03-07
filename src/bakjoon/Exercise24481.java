package bakjoon;

import java.io.*;
import java.util.*;

public class Exercise24481 {
    private static final Map<Integer, List<Integer>> graph = new LinkedHashMap<>();
    private static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        visited = new int[n];
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
            visited[i] = -1;
        }

        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken()) - 1;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        visited[start] = 0;
        dfs(start);
        Arrays.stream(visited).forEach(System.out::println);
    }

    public static void dfs(int start) {
        Collections.sort(graph.get(start));
        for (Integer next : graph.get(start)) {
            if (visited[next] == -1) {
                visited[next] = visited[start] + 1;
                dfs(next);
            }
        }
    }
}
