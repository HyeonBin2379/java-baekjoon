package baekjoon.baekjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise14732 {

    private static final int[][] map = new int[501][501];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i = input[0]; i < input[2]; i++) {
                for (int j = input[1]; j < input[3]; j++) {
                    map[i][j]++;
                }
            }
        }
        int answer = 0;
        for (int i = 0; i <= 500; i++) {
            answer += (int) Arrays.stream(map[i]).filter(cnt -> cnt > 0).count();
        }
        System.out.println(answer);
    }
}
