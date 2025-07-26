package algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise1949 {

    private static final List<List<Integer>> graph = new ArrayList<>();
    private static long[] village, dp1, dp2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        village = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        IntStream.range(0, n).forEach(idx -> graph.add(new ArrayList<>()));
        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        dp1 = new long[n];
        dp2 = new long[n];
        dfs(0, 0);
        System.out.println(Math.max(dp1[0], dp2[0]));
    }

    private static void dfs(int cur, int parent) {
        // dfs 호출이 발생할 때마다 각 정점들을 최초 방문 -> 중복 계산 방지 로직 불필요
        dp1[cur] = village[cur];
        dp2[cur] = 0;

        for (int next : graph.get(cur)) {
            if (parent == next) {
                continue;
            }
            dfs(next, cur);
            dp1[cur] += dp2[next];
            dp2[cur] += Math.max(dp1[next], dp2[next]);
        }
    }
}
