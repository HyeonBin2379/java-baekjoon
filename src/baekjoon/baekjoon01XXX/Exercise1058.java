package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise1058 {
    private static int size;
    private static int[][] friendship;
    private static final int INF = Integer.MAX_VALUE >> 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        friendship = new int[size][size];
        for (int i = 0; i < size; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < size; j++) {
                if (input[j] == 'Y') {
                    friendship[i][j] = 1;
                } else if (i != j) {
                    friendship[i][j] = INF;
                }
            }
        }
        br.close();
        System.out.println(floyd());
    }

    public static int floyd() {
        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (i == j || j == k || k == i) {
                        continue;
                    }
                    if (friendship[i][j] > friendship[i][k]+friendship[k][j]) {
                        friendship[i][j] = friendship[i][k]+friendship[k][j];
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < size; i++) {
            int temp = 0;
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    continue;
                }
                if (friendship[i][j] <= 2) {
                    temp++;
                }
            }
            answer = Math.max(answer, temp);
        }
        return answer;
    }
}
