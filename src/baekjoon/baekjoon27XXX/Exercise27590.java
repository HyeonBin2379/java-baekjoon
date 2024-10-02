package baekjoon.baekjoon27XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise27590 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] sun = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] moon = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sunYear = sun[1] - sun[0];
        int moonYear = moon[1] - moon[0];

        while (sunYear != moonYear) {
            if (sunYear < moonYear) {
                sunYear += sun[1];
            } else {
                moonYear += moon[1];
            }
        }
        System.out.println(sunYear);
    }
}
