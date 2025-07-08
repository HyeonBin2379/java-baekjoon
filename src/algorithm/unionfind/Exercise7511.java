package algorithm.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise7511 {

    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int i = 1; i <= tc; i++) {
            int n = Integer.parseInt(br.readLine());
            int k = Integer.parseInt(br.readLine());

            parent = new int[n+1];
            Arrays.fill(parent, -1);
            while (k-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }

            sb.append("Scenario ").append(i).append(":\n");
            int m = Integer.parseInt(br.readLine());
            while (m-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int result = (find(a) == find(b)) ? 1 : 0;
                sb.append(result).append("\n");
            }
            sb.append("\n");
        }
        System.out.print(sb);
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
            parent[g1]--;
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
