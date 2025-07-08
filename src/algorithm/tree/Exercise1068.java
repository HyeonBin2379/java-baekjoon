package algorithm.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise1068 {

    private static int count;
    private static int[] parent;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = 0;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = Integer.parseInt(st.nextToken());
            if (parent[i] < 0) {
                root = i;
            }
        }
        int k = Integer.parseInt(br.readLine());

        erase(k);

        count = 0;
        visited = new boolean[n];
        countLeaf(root);
        System.out.println(count);
    }

    private static void erase(int cur) {
        parent[cur] = -2;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == cur) {
                erase(i);
            }
        }
    }

    private static void countLeaf(int cur) {
        boolean isLeaf = true;

        visited[cur] = true;
        if (parent[cur] == -2) {
            return;
        }
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == cur && !visited[i]) {
                countLeaf(i);
                isLeaf = false;
            }
        }
        count += isLeaf ? 1 : 0;
    }

}
