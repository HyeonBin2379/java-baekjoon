package baekjoon.baekjoon26XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise26935 {

    private static int[] parent, depth;
    private static final List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 그래프 생성 및 각 노드별 깊이 구하기
        IntStream.rangeClosed(0, n).forEach(i -> graph.add(new ArrayList<>()));
        st = new StringTokenizer(br.readLine());
        parent = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = Integer.parseInt(st.nextToken());
            graph.get(parent[i]).add(i);
            graph.get(i).add(parent[i]);
        }
        depth = new int[n+1];
        Arrays.fill(depth, -1);
        dfs();

        // 최소 공통 조상 구하기
        int[] table = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int num = table[0];
        for (int i = 1; i < m; i++) {
            num = lca(num, table[i]);
        }
        System.out.println(num);
    }

    private static void dfs() {
        Stack<Integer> stack = new Stack<>();
        depth[0] = 0;
        stack.add(0);

        while (!stack.isEmpty()) {
            int now = stack.pop();

            for (int next : graph.get(now)) {
                if (depth[next] == -1) {
                    depth[next] = depth[now]+1;
                    stack.push(next);
                }
            }
        }
    }

    private static int lca(int num1, int num2) {
        while (depth[num1] != depth[num2]) {
            if (depth[num1] > depth[num2]) {
                num1 = parent[num1];
            } else {
                num2 = parent[num2];
            }
        }
        while (num1 != num2) {
            num1 = parent[num1];
            num2 = parent[num2];
        }
        return num1;
    }
}
