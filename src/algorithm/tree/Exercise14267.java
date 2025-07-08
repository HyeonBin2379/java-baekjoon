package algorithm.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Exercise14267 {

    private static final List<List<Integer>> tree = new ArrayList<>();
    private static long[] praise, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                st.nextToken();
                continue;
            }
            int supervisor = Integer.parseInt(st.nextToken());
            tree.get(supervisor).add(i);
        }

        praise = new long[n+1];
        answer = new long[n+1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int person = Integer.parseInt(st.nextToken());
            long degree = Long.parseLong(st.nextToken());
            praise[person] += degree;
        }
        dfs(1, 0);
        for (int i = 1; i <= n; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    private static void dfs(int cur, long score) {
        answer[cur] += (score+praise[cur]);
        for (int sub : tree.get(cur)) {
            dfs(sub, score+praise[cur]);
        }
    }
}
