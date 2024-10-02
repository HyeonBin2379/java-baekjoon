package baekjoon.baekjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise2096 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] maxDp = new int[3];
        int[] minDp = new int[3];

        int[] maxTemp = new int[3];
        int[] minTemp = new int[3];
        for (int i = 0; i < n; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    maxTemp[j] = input[j] + Math.max(maxDp[j], maxDp[j + 1]);
                    minTemp[j] = input[j] + Math.min(minDp[j], minDp[j + 1]);
                } else if (j == 1) {
                    maxTemp[j] = input[j] + Arrays.stream(maxDp).reduce(maxDp[0], Integer::max);
                    minTemp[j] = input[j] + Arrays.stream(minDp).reduce(minDp[0], Integer::min);
                } else {
                    maxTemp[j] = input[j] + Math.max(maxDp[j], maxDp[j - 1]);
                    minTemp[j] = input[j] + Math.min(minDp[j], minDp[j - 1]);
                }
            }
            maxDp = maxTemp.clone();
            minDp = minTemp.clone();
        }
        System.out.println(Arrays.stream(maxDp).reduce(maxDp[0], Integer::max)
                + " " + Arrays.stream(minDp).reduce(minDp[0], Integer::min));
    }
}