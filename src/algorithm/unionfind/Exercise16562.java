package algorithm.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise16562 {

    private static int[] parent, cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        cost = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        parent = IntStream.rangeClosed(0, n).toArray();
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        long total = 0;
        for (int i = 1; i <= n; i++) {
            if (find(i) == i) {
                total += cost[find(i)];
            }
            if (total > k) {
                System.out.println("Oh no");
                return;
            }
        }
        System.out.println(total);
    }

    private static int find(int curr) {
        if (parent[curr] == curr) {
            return curr;
        }
        return parent[curr] = find(parent[curr]);
    }

    private static void union(int a, int b) {
        int g1 = find(a);
        int g2 = find(b);

        if (cost[g1] > cost[g2]) {
            parent[g1] = g2;
        } else {
            parent[g2] = g1;
        }
    }
}
