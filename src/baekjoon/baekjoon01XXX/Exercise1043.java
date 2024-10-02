package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise1043 {
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int[] knowingTruth = new int[T];
        for (int i = 0; i < T; i++) {
            knowingTruth[i] = Integer.parseInt(st.nextToken());
        }

        parent = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            parent[i] = i;
        }
        int[][] party = new int[M][];
        for (int i = 0; i < M; i++) {
            party[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int firstPerson = party[i][1];
            for (int j = 2; j < party[i][0]+1; j++) {
                union(firstPerson, party[i][j]);
            }
        }
        br.close();

        int result = 0;
        for (int i = 0; i < M; i++) {
            boolean isPossible = true;
            int firstPerson = party[i][1];
            for (int k : knowingTruth) {
                if (checkSame(firstPerson, k)) {
                    isPossible = false;
                    break;
                }
            }
            result += (isPossible) ? 1 : 0;
        }
        System.out.println(result);
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
        if (rootA != rootB) {
            parent[rootA] = Math.min(rootA, rootB);
            parent[rootB] = parent[rootA];
        }
    }

    public static boolean checkSame(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        return rootA == rootB;
    }
}
