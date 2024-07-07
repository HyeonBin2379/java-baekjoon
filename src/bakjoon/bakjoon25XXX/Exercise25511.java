package bakjoon.bakjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise25511 {

    private static final List<List<Integer>> graph = new ArrayList<>();
    private static boolean[] visited;
    private static int[] value;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        IntStream.rangeClosed(0, n).forEach(i -> graph.add(new ArrayList<>()));
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(p).add(c);
        }
        value = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        visited = new boolean[n];
        dfs(0, 0, k);
    }

    private static void dfs(int now, int depth, int target) {
        if (value[now] == target) {
            System.out.println(depth);
            return;
        }
        visited[now] = true;
        for (int next : graph.get(now)) {
            if (!visited[next]) {
                dfs(next, depth+1, target);
            }
        }
    }
}
