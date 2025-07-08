package algorithm.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Exercise15681 {

    private static final List<List<Integer>> graph = new ArrayList<>();
    private static int[] childCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        childCnt = new int[n+1];
        makeTree(r, -1);
        for (int i = 0; i < q; i++) {
            int root = Integer.parseInt(br.readLine());
            System.out.println(childCnt[root]);
        }
    }

    private static void makeTree(int cur, int parent) {
        childCnt[cur] = 1;
        for (int node : graph.get(cur)) {
            if (node != parent) {
                makeTree(node, cur);
                childCnt[cur] += childCnt[node];
            }
        }
    }
}
