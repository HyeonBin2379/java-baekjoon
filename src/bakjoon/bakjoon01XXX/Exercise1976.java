package bakjoon.bakjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise1976 {
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int cityCount = Integer.parseInt(br.readLine());
        int routeLength = Integer.parseInt(br.readLine());
        int[][] map = new int[cityCount + 1][cityCount + 1];
        parent = new int[cityCount+1];
        for (int i = 1; i < cityCount+1; i++) {
            st = new StringTokenizer(br.readLine());
            parent[i] = i;
            for (int j = 1; j < cityCount+1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] route = new int[routeLength + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < routeLength +1; i++) {
            route[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < cityCount+1; i++) {
            for (int j = 1; j < cityCount+1; j++) {
                if (map[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        boolean isConnected = true;
        int index = find(route[1]);
        for (int i = 2; i < routeLength +1; i++) {
            if (index != find(route[i])) {
                isConnected = false;
                break;
            }
        }
        System.out.println((isConnected) ? "YES" : "NO");
    }

    public static int find(int a) {
        if (a == parent[a]) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }
    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (a != b) {
            parent[rootA] = Math.min(rootA, rootB);
            parent[rootB] = parent[rootA];
        }
    }
}
