package algorithm.unionset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise1976 {

    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        parent = new int[n+1];
        Arrays.fill(parent, -1);
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int connected = Integer.parseInt(st.nextToken());
                if (connected == 1) {
                    union(i, j);
                }
            }
        }

        int[] route = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < m-1; i++) {
            if (find(route[i]) != find(route[i+1])) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    private static void union(int a, int b) {
        int g1 = find(a);
        int g2 = find(b);

        if (g1 == g2) {
            return;
        }
        if (parent[g1] < parent[g2]) {
            int temp = g1;
            g1 = g2;
            g2 = temp;
        }
        if (parent[g1] == parent[g2]) {
            parent[g2]--;
        }
        parent[g2] = g1;
    }

    private static int find(int cur) {
        if (parent[cur] < 0) {
            return cur;
        }
        return parent[cur] = find(parent[cur]);
    }
}
