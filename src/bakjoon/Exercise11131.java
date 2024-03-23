package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise11131 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int count = Integer.parseInt(br.readLine());
            int[] weight = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int sum = 0;
            for (int j = 0; j < count; j++) {
                sum += 100 * weight[j];
            }
            if (sum == 0) {
                System.out.println("Equilibrium");
            } else if (sum < 0) {
                System.out.println("Left");
            } else {
                System.out.println("Right");
            }
        }
    }
}
