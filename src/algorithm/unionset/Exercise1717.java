package algorithm.unionset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise1717 {

    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        Arrays.fill(parent, -1);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int option = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            switch (option) {
                case 0 -> union(a, b);
                case 1 -> {
                    if (find(a) == find(b)) {
                        System.out.println("yes");
                    } else {
                        System.out.println("no");
                    }
                }
            }
        }
    }

    private static int find(int cur) {
        if (parent[cur] < 0) {
            return cur;
        }
        return parent[cur] = find(parent[cur]);
    }

    private static void union(int a, int b) {
        int group1 = find(a);
        int group2 = find(b);

        if (group1 == group2) {
            return;
        }
        if (parent[group1] < parent[group2]) {
            int temp = group1;
            group1 = group2;
            group2 = temp;
        }
        if (parent[group1] == parent[group2]) {
            parent[group1]--;
        }
        parent[group2] = group1;
    }
}
