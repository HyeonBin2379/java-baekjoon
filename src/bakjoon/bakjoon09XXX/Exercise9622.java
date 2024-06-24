package bakjoon.bakjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise9622 {
    private static final double[] maxLimit = {56.0, 45.0, 25.0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int[] allowed = new int[testCase];
        for (int i = 0; i < testCase; i++) {
            String input = br.readLine().replace("  ", " ");
            double[] data = Arrays.stream(input.split(" ")).mapToDouble(Double::parseDouble).toArray();
            double sum = Arrays.stream(data).sum() - data[3];

            if ((!isOverLimit(data) || sum <= 125.00) && data[3] <= 7.00) {
                allowed[i] = 1;
            } else {
                allowed[i] = 0;
            }
        }
        Arrays.stream(allowed).forEach(System.out::println);
        System.out.println(Arrays.stream(allowed).filter(value -> value == 1).count());
    }

    public static boolean isOverLimit(double[] data) {
        for (int i = 0; i < 3; i++) {
            if (data[i] > maxLimit[i]) {
                return true;
            }
        }
        return false;
    }
}
