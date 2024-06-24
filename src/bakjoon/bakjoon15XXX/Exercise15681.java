package bakjoon.bakjoon15XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Exercise15681 {

    private static int[] visited;
    private static final Map<Integer, List<Integer>> tree = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        setTree(n);
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            tree.get(from).add(to);
            tree.get(to).add(from);
        }

        visited = new int[n+1];
        Arrays.fill(visited, -1);
        dfs(r);
        for (int i = 0; i < q; i++) {
            int subRoot = Integer.parseInt(br.readLine());
            System.out.println(visited[subRoot]);
        }
    }

    private static void setTree(int n) {
        for (int i = 1; i <= n; i++) {
            tree.put(i, new ArrayList<>());
        }
    }

    private static int dfs(int now) {
        visited[now] = 1;
        for (int next : tree.get(now)) {
            if (visited[next] == -1) {
                visited[now] += dfs(next);
            }
        }
        return visited[now];
    }
}
