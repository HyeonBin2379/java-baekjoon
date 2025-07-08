package algorithm.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise11725 {

    private static final List<List<Integer>> tree = new ArrayList<>();
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        parent = new int[n+1];
        dfs(1);
        IntStream.rangeClosed(2, n).forEach(idx -> System.out.println(parent[idx]));
    }

    private static void dfs(int cur) {
        for (int next : tree.get(cur)) {
            if (parent[cur] == next) {
                continue;
            }
            parent[next] = cur;
            dfs(next);
        }
    }
}
