package baekjoon.baekjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise2563 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[101][101];
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            for (int i = r; i < r+10; i++) {
                for (int j = c; j < c+10; j++) {
                    map[i][j] = 1;
                }
            }
        }

        System.out.println(Arrays.stream(map).flatMapToInt(Arrays::stream).sum());
    }
}
