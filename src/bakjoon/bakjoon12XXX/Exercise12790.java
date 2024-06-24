package bakjoon.bakjoon12XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise12790 {
    private static final int[] multiple = {1, 5, 2, 2};
    private static final int[] min = {1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int power = 0;
            for (int j = 0; j < 4; j++) {
                data[j] += data[j+4];
                power += (j < 3) ? Math.max(data[j], min[j])*multiple[j] : data[j]*multiple[j];
            }
            System.out.println(power);
        }
    }
}
