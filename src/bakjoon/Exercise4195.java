package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise4195 {
    private static int[] parent;
    private static int[] level;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int friendship = Integer.parseInt(br.readLine());
            parent = new int[friendship*2];
            level = new int[friendship*2];
            for (int j = 0; j < friendship*2; j++) {
                parent[j] = j;
                level[j] = 1;
            }

            int index = 0;
            Map<String, Integer> network = new HashMap<>();
            for (int j = 0; j < friendship; j++) {
                st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();
                if (!network.containsKey(a)) {
                    network.put(a, index++);
                }
                if (!network.containsKey(b)) {
                    network.put(b, index++);
                }
                sb.append(union(network.get(a), network.get(b))).append("\n");
            }
        }
        br.close();
        System.out.print(sb);
    }

    public static int find(int a) {
        if (a == parent[a]) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }
    public static int union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootB] = rootA;
            level[rootA] += level[rootB];
        }
        return level[rootA];
    }
}
