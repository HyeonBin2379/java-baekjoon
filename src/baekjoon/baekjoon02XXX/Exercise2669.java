package baekjoon.baekjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise2669 {

    private static final int[][] grid = new int[101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int lx = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());
            int rx = Integer.parseInt(st.nextToken());
            int ry = Integer.parseInt(st.nextToken());

            for (int j = ly; j < ry; j++) {
                for (int k = lx; k < rx; k++) {
                    grid[j][k] = 1;
                }
            }
        }

        int answer = 0;
        for (int[] ints : grid) {
            answer += (int) Arrays.stream(ints).filter(value -> value == 1).count();
        }
        System.out.println(answer);
    }
}
