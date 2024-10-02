package baekjoon.baekjoon20XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise20674 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int days = Integer.parseInt(br.readLine());

        int[] testCase = new int[days];
        for (int i = 0; i < days; i++) {
            testCase[i] = Integer.parseInt(br.readLine());
        }

        int disposed = 0;
        for (int i = 1; i < days; i++) {
            if (testCase[i] > testCase[i-1]) {
                int diff = testCase[i] - testCase[i - 1];
                testCase[i] -= diff;
                disposed += diff;
            }
        }
        System.out.println(disposed);
    }
}
