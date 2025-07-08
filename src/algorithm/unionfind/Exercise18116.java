package algorithm.unionfind;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise18116 {

    private static final long[] parts = new long[1000001];

    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        parent = IntStream.rangeClosed(0, 1000000).toArray();
        Arrays.fill(parts, 1);
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "I" -> {
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    if (find(a) != find(b)) {
                        union(a, b);
                    }
                }
                case "Q" -> {
                    int x = Integer.parseInt(st.nextToken());
                    bw.write(parts[find(x)] + "\n");
                }
            }
        }
        br.close();
        bw.close();
    }

    private static int find(int cur) {
        if (parent[cur] == cur) {
            return cur;
        }
        return parent[cur] = find(parent[cur]);
    }

    private static void union(int a, int b) {
        int g1 = find(a);
        int g2 = find(b);

        if (g1 < g2) {
            parent[g2] = g1;
            parts[g1] += parts[g2];
            parts[g2] = 0;
        } else {
            parent[g1] = g2;
            parts[g2] += parts[g1];
            parts[g1] = 0;
        }
    }
}
