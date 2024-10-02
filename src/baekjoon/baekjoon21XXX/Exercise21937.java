package baekjoon.baekjoon21XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise21937 {

    private static final Map<Integer, List<Integer>> graph = new HashMap<>();
    private static boolean[] visited;
    private static int depth = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        IntStream.rangeClosed(1, n).forEach(i -> graph.put(i, new ArrayList<>()));
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(b).add(a);
        }

        int start = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        dfs(start);
        System.out.println(depth);
    }

    private static void dfs(int now) {
        visited[now] = true;
        for (int next : graph.get(now)) {
            if (!visited[next]) {
                depth++;
                dfs(next);
            }
        }
    }
}
