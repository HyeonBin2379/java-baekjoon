package baekjoon.baekjoon24XXX;

import java.io.*;
import java.util.*;

public class Exercise24482 {
    private static final Map<Integer, List<Integer>> graph = new LinkedHashMap<>();
    private static int[] depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        depth = new int[n];
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
            depth[i] = -1;
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

        Arrays.fill(depth, -1);
        depth[start] = 0;
        dfs(start);
        Arrays.stream(depth).forEach(System.out::println);
    }

    public static void dfs(int start) {
        graph.get(start).sort(Collections.reverseOrder());
        for (Integer next : graph.get(start)) {
            if (depth[next] < 0) {
                depth[next] = depth[start] + 1;
                dfs(next);
            }
        }
    }
}
