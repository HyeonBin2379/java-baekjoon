package bakjoon.bakjoon18XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise18786 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] points = new int[n][];
        for (int i = 0; i < n; i++) {
            points[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (i == j || k == i || k == j) {
                        continue;
                    }
                    if (points[i][0] == points[j][0] && points[i][1] == points[k][1]) {
                        int w = Math.abs(points[i][0]-points[k][0]);
                        int h = Math.abs(points[i][1]-points[j][1]);
                        answer = Math.max(w*h, answer);
                    }
                }
            }
        }
        System.out.println(answer);
    }
}