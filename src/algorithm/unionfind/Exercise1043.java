package algorithm.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise1043 {

    private static int[] parent, trustWorthy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] input = br.readLine().split(" ");
        int k = Integer.parseInt(input[0]);
        trustWorthy = IntStream.rangeClosed(1, k).map(idx -> Integer.parseInt(input[idx])).toArray();
        parent = IntStream.rangeClosed(0, n).toArray();
        for (int i = 0; i < k-1; i++) {
            union(trustWorthy[i], trustWorthy[i+1]);
        }

        int[][] parties = new int[m][];
        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            int len = Integer.parseInt(line[0]);
            parties[i] = IntStream.rangeClosed(0, len).map(idx -> Integer.parseInt(line[idx])).toArray();
            for (int j = 2; j <= len; j++) {
                union(parties[i][1], parties[i][j]);
            }
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            answer += notExposed(parties[i][1]) ? 1 : 0;
        }
        System.out.println(answer);
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

        if (parent[g1] < parent[g2]) {
            parent[g2] = g1;
        } else {
            parent[g1] = g2;
        }
    }

    private static boolean notExposed(int curr) {
        for (int person : trustWorthy) {
            if (find(curr) == find(person)) {
                return false;
            }
        }
        return true;
    }
}
