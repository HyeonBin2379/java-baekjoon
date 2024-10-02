package baekjoon.baekjoon18XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise18868 {
    private static int[][] multi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int space = Integer.parseInt(st.nextToken());
        int planet = Integer.parseInt(st.nextToken());

        multi = new int[space][planet];
        for (int i = 0; i < space; i++) {
            multi[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int count = 0;
        for (int i = 0; i < space-1; i++) {
            for (int j = i+1; j < space; j++) {
                if (isEqual(i, j, planet)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static boolean isEqual(int a, int b, int planet) {
        for (int i = 0; i < planet-1; i++) {
            for (int j = i+1; j < planet; j++) {
                if (!check(a, b, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean check(int a, int b, int i, int j) {
        return (multi[a][i] < multi[a][j] && multi[b][i] < multi[b][j])
                || (multi[a][i] == multi[a][j] && multi[b][i] == multi[b][j])
                || (multi[a][i] > multi[a][j] && multi[b][i] > multi[b][j]);
    }
}
