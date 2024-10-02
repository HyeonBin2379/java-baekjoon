package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise1051 {

    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        for (int k = Math.min(n, m)-1; k > 0; k--) {
            for (int i = 0; i < n -k; i++) {
                for (int j = 0; j < m -k; j++) {
                    if (check(i, j, k)) {
                        System.out.println((k+1)*(k+1));
                        return;
                    }
                }
            }
        }
        System.out.println(1);
    }

    private static boolean check(int startR, int startC, int size) {
        return map[startR][startC] == map[startR][startC+size]
                && map[startR][startC] == map[startR+size][startC]
                && map[startR][startC] == map[startR+size][startC+size];
    }
}
