package bakjoon;

import java.io.*;
import java.util.*;

public class Exercise24484 {

    private static final List<List<Integer>> graph = new ArrayList<>();
    private static long[] depth, order;
    private static long rank = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
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

        for (int i = 0; i < n; i++) {
            graph.get(i).sort(Collections.reverseOrder());
        }

        order = new long[n];
        depth = new long[n];
        Arrays.fill(depth, -1);
        dfs(start, 0);

        long sum = 0;
        for (int i = 0; i < depth.length; i++) {
            sum += (depth[i] * order[i]);
        }
        System.out.println(sum);
    }

    public static void dfs(int start, long count) {
        depth[start] = count;
        order[start] = rank++;
        for (Integer next : graph.get(start)) {
            if (order[next] == 0) {
                dfs(next, count+1);
            }
        }
    }
}
